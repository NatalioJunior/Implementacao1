package mars.mips.instructions.syscalls;
import mars.mips.SO.ProcessManager.*;
import mars.util.*;

import java.util.ArrayList;

import mars.*;

public class SemaphoreCreateSyscall extends AbstractSyscall {

  public static int initialValue;
  public static ArrayList<PCB> blockedList = new ArrayList<>();

	public SemaphoreCreateSyscall() { // parametro: Inteiro que representa o valor inicial do semaforo
		super(63, "CreateSemaphore");
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
