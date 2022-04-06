package mars.mips.SO.ProcessManager;

import mars.mips.hardware.Register;
import mars.mips.hardware.RegisterFile;

public class PCB {
	public enum estado{ PRONTO, EXECUTANDO, BLOQUEADO };
	private Register[] regisFile;
	private String iniID;
	private int PID;
	
	public PCB(String iniID, int pID) {
		this.regisFile = RegisterFile.getRegisters();
		this.iniID = iniID;
		this.PID = pID;
	}
	
	public Register[] getRegisFile() {
		return regisFile;
	}
	
	public void updateRegFile (int num) {
		RegisterFile.updateRegister(num, regisFile[num].getValue());
	}
	
	public void setRegisFile(Register[] regisFile) {
		this.regisFile = regisFile;
	}
	public String getIniID() {
		return iniID;
	}
	public void setIniID(String iniID) {
		this.iniID = iniID;
	}
	public int getPID() {
		return PID;
	}
	public void setPID(int pID) {
		PID = pID;
	}
	
	
}
