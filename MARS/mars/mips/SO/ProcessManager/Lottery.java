package mars.mips.SO.ProcessManager;

import java.util.Random;

public class Lottery {

	public static PCB nextProcess() {
        int size = ProcessTable.getListIds().size();

        Random r = new Random();

		return (size > 0) ? ProcessTable.getListReady().get(r.nextInt(size)) : new PCB(-1); 
        //se a lista estiver vazia retorna um processo com endereço -1
	}

}