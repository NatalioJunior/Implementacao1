package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.*;
import java.util.*;

public class SemaphoreDownSyscall extends AbstractSyscall{
	ArrayList<PCB> blockedList = new ArrayList<>();
	SemaphoreCreateSyscall createSemaphore = new SemaphoreCreateSyscall();

	public SemaphoreDownSyscall() {
		super(65, "DownSemaphore");
		// TODO Auto-generated constructor stub
		createSemaphore.setInitialValue(createSemaphore.getInitialValue());
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		if (blockedList.isEmpty() ){
			createSemaphore.setInitialValue(createSemaphore.getInitialValue() - 1); //Decrementando valor inicial do semaforo
		}else {
			ProcessTable.incrementReady(blockedList.get(blockedList.size() - 1).getPID(), 2); // Alterando estado do ultimo item do semaforo para 'BLOQUEADO'
		}
	}

}
