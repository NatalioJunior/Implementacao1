package mars.mips.SO.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

public class Fifo {
	private static Queue<PCB> queueProcess = new LinkedList<>();
	
	public static void incrementQueue (PCB process) {
		queueProcess.add(process);
	}
	
	public static PCB removeQueue() {
		if(queueProcess.size() > 0)
            return queueProcess.remove();
            
        else return new PCB(-1); //se a fila estiver vazia retorna um processo com pid -1
	}
	
	public static PCB peekQueue() {
		return queueProcess.peek();
	}

}
