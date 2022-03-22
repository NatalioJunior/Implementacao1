package mars.mips.instructions.syscalls;
import mars.util.*;
import mars.*;

public class MySyscall extends AbstractSyscall{

	public MySyscall() {
		super(18, "MySyscall");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		SystemIO.printString("Olá Syscall!\n");
	}

}
