package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;
import mars.mips.hardware.*;
import mars.*;

public class SyscallProcessChange extends AbstractSyscall{

	public SyscallProcessChange() {
		super(61, "ProcessChange");
	}

	public void simulate(ProgramStatement statement) throws ProcessingException {
		
		//Ver o processo atual e processa-lo
		if(ProcessTable.getProcessoAtual() == null) {
			//se for o primeiro processo só seta
			ProcessTable.setProcessoAtual();
		} else {
			//salva  contexto do processo atual
			ProcessTable.processExec(ProcessTable.getIdProcessoAtual());
			//seta um novo
			ProcessTable.setProcessoAtual();
		}
	}
	
}
