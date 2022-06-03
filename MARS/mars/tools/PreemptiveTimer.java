
package mars.tools;

import javax.print.attribute.PrintRequestAttribute;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

import mars.*;
import mars.mips.SO.ProcessManager.ProcessTable;
import mars.mips.SO.ProcessManager.Scheduler;
import mars.mips.hardware.AccessNotice;
import mars.mips.hardware.AddressErrorException;
import mars.mips.hardware.Memory;
import mars.mips.hardware.MemoryAccessNotice;
import mars.mips.instructions.BasicInstruction;
import mars.mips.instructions.BasicInstructionFormat;

 public class PreemptiveTimer extends AbstractMarsToolAndApplication {

   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
	
   private static String heading =  "Escalonamento preemptivo com contagem de instru��es";
   private static String version = "Version 2.0";
   private static String name = "Preemptive Timer";
   
   protected int counter = 0;
   private JTextField counterField;
   
   protected int max = 0;
   private JTextField maxField;
   
   private boolean startFlag = false;
   private JButton start;
   
   private String[] schedulers = {"FIFO", "Prioridade", "Loteria"};
   private JComboBox<String> schedulerField;
   
   private boolean reset = false;
   
   private static boolean preemptive = false; //será verdadeiro quando estiver ocorrendo uma preempção e servirá de flag para o memory manager

   public static boolean getPreemptive() {
	   return preemptive;
   }

   public static void setPreemptive() {
	   preemptive = false;
   }
   
   //ignora o �ltimo endere�o porque p/ um programa executar 2 vezes seguidas a mesma instru��o ele vai estar em loop infinito
   protected int lastAddress = -1; 
	         	
	/**
	 * Simple constructor, likely used to run a stand-alone memory reference visualizer.
	 * @param title String containing title for title bar
	 * @param heading String containing text for heading shown in upper part of window.
	 */
    public PreemptiveTimer(String title, String heading) {
      super(title,heading);
   }
	 
	 /**
	  *  Simple constructor, likely used by the MARS Tools menu mechanism
	  */
    public PreemptiveTimer() {
      super (name+", "+version, heading);
   }
		 
		 
	/**
	 * Main provided for pure stand-alone use.  Recommended stand-alone use is to write a 
	 * driver program that instantiates a MemoryReferenceVisualization object then invokes its go() method.
	 * "stand-alone" means it is not invoked from the MARS Tools menu.  "Pure" means there
	 * is no driver program to invoke the application.
	 */
    public static void main(String[] args) {
      new PreemptiveTimer(name+", "+version,heading).go();
   }
	

    /**
	  *  Required method to return Tool name.  
	  *  @return  Tool name.  MARS will display this in menu item.
	  */
    public String getName() {
      return name;
   }
	
   /**
	 *  Implementation of the inherited abstract method to build the main 
	 *  display area of the GUI.  It will be placed in the CENTER area of a 
	 *  BorderLayout.  The title is in the NORTH area, and the controls are 
	 *  in the SOUTH area.
	 */
    protected JComponent buildMainDisplayArea() {
    	// Create everything
		JPanel panel = new JPanel(new GridBagLayout());

		counterField = new JTextField("0", 10);
		counterField.setEditable(false);
		
		maxField = new JTextField("0", 10);
		maxField.setEditable(true);
		
		start = new JButton("Start counter");
		start.addActionListener(
			new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		        	startFlag = true;
		        	Scheduler.setAlgorithm((String)schedulerField.getSelectedItem());
		    	}
		    });
		
		schedulerField = new JComboBox<>(schedulers);
		schedulerField.setSelectedIndex(0);
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 30, 0);
		panel.add(counterField, c);
		
		c.insets = new Insets(0, 0, 20, 0);
		c.gridy++;
		panel.add(maxField, c);
		
		c.insets = new Insets(0, 0, 10, 0);
		c.gridy++;
		panel.add(schedulerField, c);
		
		c.insets = new Insets(0, 0, 5, 0);
		c.gridy++;
		panel.add(start, c);
		
		// Labels
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 30, 0);
		panel.add(new JLabel("Contador: "), c);
		
		c.insets = new Insets(0, 0, 20, 0);
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy++;
		panel.add(new JLabel("Numero maximo de instrucoes: "), c);
		
		c.insets = new Insets(0, 0, 10, 0);
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy++;
		panel.add(new JLabel("Algoritmo: "), c);
		
		return panel;	
   }
    
    @Override
	protected void addAsObserver() {
		addAsObserver(Memory.textBaseAddress, Memory.textLimitAddress);
	}
    
    @Override
	protected void processMIPSUpdate(Observable resource, AccessNotice notice) {
		if (!notice.accessIsFromMIPS()) return;
		
		if (notice.getAccessType() != AccessNotice.READ) return;
		
		MemoryAccessNotice m = (MemoryAccessNotice) notice;
		int a = m.getAddress();
		
		if (a == lastAddress) return;
		lastAddress = a;
		
		if (startFlag) {
			counter++;
			updateDisplay();
		}
	}
	
//	@Override
	protected void initializePreGUI() {
		counter = 0;
		lastAddress = -1;
		max = 0;
	}
	
// @Override
	protected void reset() {
		counter = 0;
		lastAddress = -1;	
		max = 0;
		reset = true;
		startFlag = false;
		updateDisplay();
	}
	
//	@Override
	protected void updateDisplay() {
		if(reset) reset = false;
		
		maxField.setEditable(reset);
	
		max = Integer.parseInt(maxField.getText());
		
		if (counter - 1 == max) {
			//reinicia o contador
			counter = 0;
			
			//muda o processo
			if (ProcessTable.getProcessoAtual().getPID() != -1 && ProcessTable.getProcessoAtual() != null) { // sera -1 se a ultima operacao encontrou uma fila/lista vazia
				//salva  contexto do processo atual
				ProcessTable.processExec(ProcessTable.getIdProcessoAtual());
				//retorna pro fim da fila
				Scheduler.addProcess(ProcessTable.getProcessoAtual());
			}
			preemptive = true;
			//seta um novo
			ProcessTable.setProcessoAtual();
		} 
		
		counterField.setText(String.valueOf(counter));
	}
	
}