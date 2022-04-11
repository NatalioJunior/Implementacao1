package mars.mips.SO.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

public class Escalonador {
	private static Queue<PCB> queueProcess = new LinkedList<>();
	
	public static void incrementQueue (PCB process) {
		queueProcess.add(process);
	}
	
	public static  void removeQueue() {
		queueProcess.remove();
	}
	
	public static PCB peekQueue() {
		return queueProcess.peek();
	}
	
	public static void nextProcess() {
		
	}


	
	
	
}
