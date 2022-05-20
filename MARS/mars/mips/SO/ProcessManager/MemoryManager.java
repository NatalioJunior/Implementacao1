package mars.mips.SO.ProcessManager;

public class MemoryManager {
	private int tamanho_Pagina_Virtual;
	private int maxBlocos;
	private int pagingMethod;		//Configura��o do tipo de algoritmo de substitui��o de p�ginas da mem�ria virtual (enum Algorithm)
	
	public int getTamanho_Pagina_Virtual() {
		return tamanho_Pagina_Virtual;
	}
	public void setTamanho_Pagina_Virtual(int tamanho_Pagina_Virtual) {
		this.tamanho_Pagina_Virtual = tamanho_Pagina_Virtual;
	}
	public int getMaxBlocos() {
		return maxBlocos;
	}
	public void setMaxBlocos(int maxBlocos) {
		this.maxBlocos = maxBlocos;
	}
	public int getPagingMethod() {
		return pagingMethod;
	}
	public void setPagingMethod(int pagingMethod) {
		this.pagingMethod = pagingMethod;
	}

}
