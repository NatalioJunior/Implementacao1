package mars.mips.instructions.syscalls;
import mars.util.*;
import mars.*;

public class SemaphoreDownSyscall extends AbstractSyscall{

	public SemaphoreDownSyscall() {
		super(65, "DownSemaphore");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		SystemIO.printString("Hello Syscall!\n");
	}

}
