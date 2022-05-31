package mars.mips.instructions.syscalls;

import javax.swing.JOptionPane;

import mars.ProcessingException;
import mars.ProgramStatement;
import mars.mips.SO.ProcessManager.MemoryManager;

public class SyscallExitAcessMemory extends AbstractSyscall{

	public SyscallExitAcessMemory() {
		super(19, "ExitAcessMemory");
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException{
		JOptionPane.showMessageDialog(null, "O endere�o acessado est� fora dos limites de mem�ria para o processo em execu��o!", null, 0 );
		throw new ProcessingException();
	}

}
