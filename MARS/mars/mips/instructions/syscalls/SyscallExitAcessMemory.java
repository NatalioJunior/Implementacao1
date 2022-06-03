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
		JOptionPane.showMessageDialog(null, "O endereço acessado está fora dos limites de memória para o processo em execução!", null, 0 );
		throw new ProcessingException();
	}

}
