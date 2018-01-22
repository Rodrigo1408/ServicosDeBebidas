package br.com.servicosdebebidas.domain;

public class Fornecedor {
	
	private Long   codigo;
	private String fornecedor;
	private String descricao;
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Código: "+codigo+" Fornecedor: "+fornecedor+ "Descrição: "+descricao;
	}

}
