package mars.mips.SO.ProcessManager;

import java.util.ArrayList;

import mars.mips.hardware.RegisterFile;

public class ProcessTable {
	private static ArrayList<PCB> listReady = new ArrayList<>();
	//private ArrayList<PCB> listExec = new ArrayList<>();
	private static PCB processoAtual;
	private static int processoId = 0;
	
	public static void incrementReady (int address, int estadoProcesso) {	
		PCB auxiliar = new PCB(address, processoId, estadoProcesso);
		listReady.add(auxiliar);
		processoId++;
		auxiliar.setEstadoProcesso(0);
		Escalonador.incrementQueue(auxiliar);
	}
	
	/*public void incrementExec (String iniID, int PID, int estadoProcesso) {
		listExec.add(new PCB(iniID, PID, estadoProcesso));
	}*/
	
	public ArrayList<PCB> getListReady() {
		return listReady;
	}

	/*public ArrayList<PCB> getListExec() {
		return listExec;
	}*/
	
	public static void removeReady(int valor) {
		//Removento da lista de processos prontos
		//e setando um novo processo em execução
		listReady.remove(valor);
		processoId--;
		Escalonador.removeQueue();
		setProcessoAtual();
		
	}
	
	
	public static void processExec(int valor) {
		//mudando o estado do processo para pronto e
		//guarando os valores do registrador fisico
		//no registrador do PCB
		processoAtual.setEstadoProcesso(0);
		processoAtual.setRegisFile();
		
		listReady.get(valor).setEstadoProcesso(0);;
		listReady.get(valor).setRegisFile();
		
	}

	public static PCB getProcessoAtual() {
		return processoAtual;
	}

	public static void setProcessoAtual() {
		//setar o processo atual como o pico do escalonador
		processoAtual = Escalonador.peekQueue();
		processoAtual.setEstadoProcesso(1);
		
		//carregar regs
		for (int i = 0; i < 32; i++) {
			RegisterFile.updateRegister(i, processoAtual.getRegisFile()[i].getValue());
		}
		
		RegisterFile.setProgramCounter(processoAtual.getIniAD());

	}
	
	public static int getIdProcessoAtual() {
		return listReady.indexOf(processoAtual);
		
	}
	
}
