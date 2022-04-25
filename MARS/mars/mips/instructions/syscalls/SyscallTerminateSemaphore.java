package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;

import java.util.ArrayList;

import mars.*;

public class SyscallTerminateSemaphore extends AbstractSyscall{


	public SyscallTerminateSemaphore() {
		super(64, "TerminateSemaphore");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
		// TODO Auto-generated method stub
		try{
			SyscallCreateSemaphore.blockedList.clear(); // Limpa o semaforo
		}catch(Exception err){
			SystemIO.printString("ERR:\n");
			System.out.println(err);
		}
		
	}

}
