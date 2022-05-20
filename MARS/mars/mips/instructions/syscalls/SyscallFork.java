package mars.mips.instructions.syscalls;

import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.mips.hardware.*;
import mars.*;

public class SyscallFork extends AbstractSyscall{

	public SyscallFork() {
        super(60, "Fork");
     }

	public void simulate(ProgramStatement statement) throws ProcessingException {
		
		int address = new Integer(RegisterFile.getValue(4)); //4 � a posi��o do a0 no vetor de registradores em Register File
		int end = new Integer(RegisterFile.getValue(5)); //5 � a posi��o do a1 no vetor de registradores em Register File
		
		//Adicionando o novo processo no escalonador e na tabela de processos
		ProcessTable.incrementReady(address, 0, end);

	}
    
}
