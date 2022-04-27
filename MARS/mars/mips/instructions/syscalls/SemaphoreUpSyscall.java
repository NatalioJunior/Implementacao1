package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.*;
import java.util.*;

public class SemaphoreUpSyscall extends AbstractSyscall{
	ArrayList<PCB> blockedList = new ArrayList<>();
	SemaphoreCreateSyscall createSemaphore = new SemaphoreCreateSyscall();
	
	public SemaphoreUpSyscall() {
		super(66, "UpSemaphore");
		// TODO Auto-generated constructor stub
		createSemaphore.setInitialValue(createSemaphore.getInitialValue());
	}
	
	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		
		if (blockedList.isEmpty() ){
			createSemaphore.setInitialValue(createSemaphore.getInitialValue() + 1); //Incrementando valor inicial do semaforo
		}else {
			ProcessTable.incrementReady(blockedList.get(blockedList.size() - 1).getPID(), 0); // Alterando estado do ultimo item do semaforo para 'PRONTO'
		}
		SystemIO.printString("Hello Syscall!\n");
	}

}

