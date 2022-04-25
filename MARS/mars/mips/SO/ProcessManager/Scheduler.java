package mars.mips.SO.ProcessManager;

enum Algorithm{fifo, prioridade, loteria};

public class Scheduler {
    private static Algorithm algorithm;

    public Algorithm getAlgorithm(){
        return algorithm;
    }

    public void setAlgorithm(Algorithm a) {
        algorithm = a;
    }

    public static void addProcess(PCB process) {
        if (algorithm == Algorithm.fifo)
            Fifo.incrementQueue(process);

    }

    public static PCB nextProcess() {
        if (algorithm == Algorithm.fifo)
            return Fifo.removeQueue();
        
            return null;
    }

}
