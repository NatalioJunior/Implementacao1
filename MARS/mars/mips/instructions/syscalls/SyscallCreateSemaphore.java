package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;

import java.util.ArrayList;

import mars.*;

public class SyscallCreateSemaphore extends AbstractSyscall {

  public static int initialValue;
  public static ArrayList<PCB> blockedList = new ArrayList<>();

	public SyscallCreateSemaphore(int value) { // parametro: Inteiro que representa o valor inicial do semaforo
		super(63, "CreateSemaphore");

    SyscallCreateSemaphore.initialValue = value;
	}

	@Override
	public void simulate(ProgramStatement statement) throws ProcessingException {
   if(ProcessTable.getProcessoAtual().getEstadoProcesso() == 2){ // Caso processo esteja em estado 'BLOQUEADO' e adicionado ao semaforo 
     setBlockedList(ProcessTable.getProcessoAtual());
   }
	}

  // getters & setters
  public static int getInitialValue (){
    return initialValue;
  }
  public static void setInitialValue (int value){
    initialValue = value;
  }

  public static ArrayList<PCB> getBlockedList() {
    final ArrayList<PCB> result = new ArrayList<>();

    for (PCB process : blockedList ){
      result.add(process);
    }

    return result;
  }

  public void setBlockedList (PCB value){
    blockedList.add(value);
  }

}
