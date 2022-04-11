package mars.mips.SO.ProcessManager;

import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;
import mars.mips.SO.ProcessManager.Escalonador;

public class PCB {
	public enum estado{ PRONTO, EXECUTANDO, BLOQUEADO };
	private Register[] regisFile;
	private int iniAD;
	private int PID;
	private int estadoProcesso;
	
	public PCB(int iniAD, int pID, int estadoProcesso) {
		this.iniAD = iniAD;
		
		this.regisFile = RegisterFile.getRegisters();
		
		this.PID = pID;
		this.setEstadoProcesso(estadoProcesso);
		
	}
	
	public Register[] getRegisFile() {
		return regisFile;
	}
	
	public void updateRegFile (int num) {
		RegisterFile.updateRegister(num, regisFile[num].getValue());
	}
	
	public void setRegisFile() {
		for (int i = 0; i < RegisterFile.getRegisters().length; i++) {
			regisFile[i].setValue(RegisterFile.getRegisters()[i].getValue());
		}
	}
	
	public void fisicalRegister() {
		//alterar os rgistradores fisicos para os registradores do processo
		RegisterFile.resetRegisters();
		
		for (int i = 0; i < RegisterFile.getRegisters().length; i++) {
			RegisterFile.updateRegister(i, regisFile[i].getValue());
		}
	}
	
	public int getIniAD() {
		return iniAD;
	}
	
	public void setIniAD(int iniAD) {
		this.iniAD = iniAD;
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
	
	
}
