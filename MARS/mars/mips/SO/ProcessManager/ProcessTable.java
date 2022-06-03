package mars.mips.SO.ProcessManager;

import java.util.ArrayList;

public class ProcessTable {
	private static ArrayList<PCB> listReady = new ArrayList<>();
	//private ArrayList<PCB> listExec = new ArrayList<>();
	private static PCB processoAtual;
	private static int processoId = 0;
	private static ArrayList<Integer> listIds = new ArrayList<>();
	
	public static void incrementReady (int address, int estadoProcesso, int priority, int... end) {	
		PCB auxiliar = new PCB(address, processoId, estadoProcesso, priority, end);
		listReady.add(processoId, auxiliar);
		listIds.add(processoId);
		processoId++;
		Scheduler.addProcess(auxiliar);
	}
	
	/*public void incrementExec (String iniID, int PID, int estadoProcesso) {
		listExec.add(new PCB(iniID, PID, estadoProcesso));
	}*/
	
	public static ArrayList<PCB> getListReady() {
		return listReady;
	}

	/*public ArrayList<PCB> getListExec() {
		return listExec;
	}*/
	
	public static void removeReady(int valor) {
		//Removento da lista de processos prontos
		//e setando um novo processo em execu��o
		listReady.remove(processoAtual);
		listIds.remove(listIds.indexOf(valor));
		//setProcessoAtual();
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
		processoAtual = Scheduler.nextProcess();

		if (processoAtual.getPID() == -1) // será -1 quando a fila/lista estiver vazia
			PCB.fisicalRegister(); //reseta os registradores
		else {
			processoAtual.setEstadoProcesso(1);
			//carregar regs
			processoAtual.processRegisters();
		}
	}
	
	public static int getIdProcessoAtual() {
		return listReady.get(0).getPID();
	}

	public static ArrayList<Integer> getListIds() {
		return listIds;
	}
	
}