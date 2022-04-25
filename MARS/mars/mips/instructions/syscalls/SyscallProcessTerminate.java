package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.mips.hardware.*;
import mars.*;

public class SyscallProcessTerminate extends AbstractSyscall {

	public SyscallProcessTerminate() {
		super(62, "ProcessTerminate");
	}

	public void simulate(ProgramStatement statement) throws ProcessingException {
		//Remover o processo feito
		ProcessTable.removeReady(ProcessTable.getIdProcessoAtual());
		//inicia o próximo processo
		ProcessTable.setProcessoAtual();
	}

}