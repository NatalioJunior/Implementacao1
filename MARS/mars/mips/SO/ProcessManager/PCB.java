package mars.mips.SO.ProcessManager;

import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;

public class PCB {
	public enum estado{ PRONTO, EXECUTANDO, BLOQUEADO };
	private Register[] regisFile;
	private Register hi, lo;
	private int iniAD;
	private int pcAtual; //pro caso de o processo parar no meio
	private int PID;
	private int estadoProcesso;
	private int prioridade;
	
	public PCB(int iniAD, int pID, int estadoProcesso) {
		this.iniAD = iniAD;
		this.pcAtual = iniAD;
		
		this.regisFile = RegisterFile.getRegisters();
		this.hi = new Register("hi", 33, RegisterFile.getValue(33));
		this.lo = new Register("hi", 34, RegisterFile.getValue(34));
		
		this.PID = pID;
		this.setEstadoProcesso(estadoProcesso);
		
	}

	public PCB(int iniAD){ //usado no escalonamento por prioridade
		this.iniAD = iniAD;
	}
	
	public Register[] getRegisFile() {
		return regisFile;
	}
	
	public void processRegisters() {
		//carrega os registradores do processo para os físicos
		for (int i = 0; i < 35; i++) {
			if (i == 32) RegisterFile.setProgramCounter((iniAD == pcAtual) ? iniAD : pcAtual); //pro caso de o processo parar no meio
			else if (i == 33) RegisterFile.updateRegister(i, hi.getValue());
			else if (i == 34) RegisterFile.updateRegister(i, lo.getValue());
			else RegisterFile.updateRegister(i, regisFile[i].getValue());
		}
	}
	
	public void setRegisFile() {
		for (int i = 0; i < RegisterFile.getRegisters().length; i++) {
			regisFile[i].setValue(RegisterFile.getRegisters()[i].getValue());
		}
		
		pcAtual = RegisterFile.getProgramCounter();
		hi.setValue(RegisterFile.getValue(33));
		lo.setValue(RegisterFile.getValue(34));
	}
	
	public static void fisicalRegister() {
		//reseta os registradores físicos
		RegisterFile.resetRegisters();
	}
	
	public int getIniAD() {
		return iniAD;
	}
	
	public void setIniAD(int iniAD) {
		this.iniAD = iniAD;
	}
	
	public int getPcAtual() {
		return pcAtual;
	}
	
	public void setPcAtual(int pcAtual) {
		this.pcAtual = pcAtual;
	}
	
	public int getPID() {
		return PID;
	}
	
	public void setPID(int pID) {
		PID = pID;
	}

	public int getEstadoProcesso() {
		return estadoProcesso;
	}

	public void setEstadoProcesso(int estadoProcesso) {
		this.estadoProcesso = estadoProcesso;
	}

	public int getPrioridade() {
		return estadoProcesso;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	
	
}
