package mars.mips.SO.ProcessManager;

import mars.Globals;
import mars.ProcessingException;
import mars.mips.hardware.AddressErrorException;
import mars.mips.hardware.RegisterFile;
import mars.mips.instructions.syscalls.SyscallExitAcessMemory;

public class MemoryManager {
	private static int tamanho_Pagina_Virtual;
	private static int maxBlocos;
	private int pagingMethod;		//Configuração do tipo de algoritmo de substituição de páginas da memória virtual (enum Algorithm)
	
	public int getTamanho_Pagina_Virtual() {
		return tamanho_Pagina_Virtual;
	}
	public static void setTamanho_Pagina_Virtual(int size_virtual_page) {
		tamanho_Pagina_Virtual = size_virtual_page;
	}
	public int getMaxBlocos() {
		return maxBlocos;
	}
	public static void setMaxBlocos(int maximo_Blocos) {
		maxBlocos = maximo_Blocos;
	}
	public int getPagingMethod() {
		return pagingMethod;
	}
	public void setPagingMethod(int pagingMethod) {
		this.pagingMethod = pagingMethod;
	}
	
	public static void acessMemory() throws ProcessingException {
		if (ProcessTable.getProcessoAtual() != null) {
			if (RegisterFile.getProgramCounter() < ProcessTable.getProcessoAtual().getLimite_Superior() ||
					RegisterFile.getProgramCounter() > ProcessTable.getProcessoAtual().getLimite_Inferior()) {
				try {
					new SyscallExitAcessMemory().simulate(Globals.memory.getStatement(RegisterFile.getProgramCounter()));
				} catch (AddressErrorException e) {} 
			}
		}	
	}

}
