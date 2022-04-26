package mars.mips.SO.ProcessManager;

enum Algorithm{fifo, priority, lottery};

public class Scheduler {
    private static Algorithm algorithm = Algorithm.fifo;

    public Algorithm getAlgorithm(){
        return algorithm;
    }

    public void setAlgorithm(Algorithm a) {
        algorithm = a;
    }

    public static void addProcess(PCB process) {
        if (algorithm == Algorithm.fifo)
            Fifo.incrementQueue(process);
        else if (algorithm == Algorithm.fifo)
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
