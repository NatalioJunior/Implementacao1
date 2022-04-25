package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.*;
import java.util.*;

public class SyscallUpSemaphore extends AbstractSyscall{
	ArrayList<PCB> blockedList = new ArrayList<>();
	public SyscallUpSemaphore() {
		super(66, "UpSemaphore");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		blockedList = SyscallCreateSemaphore.getBlockedList();

		if (blockedList.isEmpty() ){
			SyscallCreateSemaphore.setInitialValue(SyscallCreateSemaphore.getInitialValue() + 1); //Incrementando valor inicial do semaforo
		}else {
			ProcessTable.incrementReady(blockedList.get(blockedList.size() - 1).getPID(), 0); // Alterando estado do ultimo item do semaforo para 'PRONTO'
		}
		SystemIO.printString("Hello Syscall!\n");
	}

}
