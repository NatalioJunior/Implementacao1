package mars.mips.SO.ProcessManager;

public class MemoryManager {
	private int tamanho_Pagina_Virtual;
	private int maxBlocos;
	private int pagingMethod;		//Configuração do tipo de algoritmo de substituição de páginas da memória virtual (enum Algorithm)
	
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
