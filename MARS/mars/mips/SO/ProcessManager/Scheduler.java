package mars.mips.SO.ProcessManager;

enum Algorithm{fifo, priority, lottery};

public class Scheduler {
    private static Algorithm algorithm = Algorithm.lottery;

    public static String getAlgorithm(){
        return algorithm.name();
    }

    public static void setAlgorithm(String a) {
    	if(a == "FIFO") algorithm = Algorithm.fifo;
    	else if (a == "Prioridade") algorithm = Algorithm.priority;
    	else if (a == "Loteria") algorithm = Algorithm.lottery;
    }

    public static void addProcess(PCB process) {
        if (algorithm == Algorithm.fifo)
            Fifo.incrementQueue(process);
        else if (algorithm == Algorithm.priority)
            Priority.incrementQueue(process);
        //o de loteria usa a lista de prontos
    }

    public static PCB nextProcess() {
        if (algorithm == Algorithm.fifo)
            return Fifo.removeQueue();
        else if(algorithm == Algorithm.priority)
            return Priority.removeQueue();
        else 
            return Lottery.nextProcess();
    }

}

