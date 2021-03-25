package br.ifpr.pedido.dominio;

public enum TipoTelefone {

	CELULAR("Celular"), CASA("Casa"), TRABALHO("Trabalho");
	
	private String tipoStr;
	
	private TipoTelefone(String tipoStr) {
		this.tipoStr = tipoStr;
	}
	
	public String getTipoStr() {
		return this.tipoStr;
	}
}
