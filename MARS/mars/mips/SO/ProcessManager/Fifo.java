package mars.mips.SO.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

public class Fifo {
	private static Queue<PCB> queueProcess = new LinkedList<>();
	
	public static void incrementQueue (PCB process) {
		queueProcess.add(process);
	}
	
	public static PCB removeQueue() {
		return queueProcess.remove();
	}
	
	public static PCB peekQueue() {
		return queueProcess.peek();
	}

}
