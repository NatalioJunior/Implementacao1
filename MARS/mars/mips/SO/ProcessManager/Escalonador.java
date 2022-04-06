package mars.mips.SO.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

public class Escalonador {
	private Queue<PCB> queueProcess = new LinkedList<>();
	
	public PCB Escalonar () {
		return queueProcess.remove();
	}
	
	public void incrementQueue (PCB process) {
		queueProcess.add(process);
	}
}
