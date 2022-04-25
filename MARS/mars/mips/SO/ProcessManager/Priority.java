package mars.mips.SO.ProcessManager;

import java.util.LinkedList;
import java.util.Queue;

public class Priority {
	private static Queue<PCB> queuePriority0 = new LinkedList<>();
    private static Queue<PCB> queuePriority1 = new LinkedList<>();
    private static Queue<PCB> queuePriority2 = new LinkedList<>();
	
	public static void incrementQueue (PCB process) {
		if(process.getPrioridade() == 0)
            queuePriority0.add(process);

        else if (process.getPrioridade() == 1)
            queuePriority1.add(process);

        else if (process.getPrioridade() == 2)
            queuePriority2.add(process);
	}
	
	public static PCB removeQueue() {
		if(queuePriority0.size() > 0)
            return queuePriority0.remove();

        else if(queuePriority1.size() > 0)
            return queuePriority1.remove();

        else if(queuePriority2.size() > 0)
            return queuePriority2.remove();
            
        else return new PCB(-1);
	}

}
