package mars.mips.SO.ProcessManager;

import java.util.ArrayList;

public class ProcessTable {
	private ArrayList<PCB> listReady = new ArrayList<>();
	private ArrayList<PCB> listExec = new ArrayList<>();
	
	public void incrementReady (String iniID, int PID) {
		listReady.add(new PCB(iniID, PID));
	}
	
	public void incrementExec (String iniID, int PID) {
		listExec.add(new PCB(iniID, PID));
	}

	public ArrayList<PCB> getListReady() {
		return listReady;
	}

	public ArrayList<PCB> getListExec() {
		return listExec;
	}
	
}
