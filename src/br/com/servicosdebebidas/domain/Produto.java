package br.com.servicosdebebidas.domain;

public class Produto {
	
	private Long       codigo;
	private String     descricao;
	private Integer    quantidade;
	private Double     preco;
	private Fornecedor fornecedor = new Fornecedor();

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
    
	@Override
	public String toString() {
		return "cod: "+codigo+" des: "+descricao+" pre: "+preco+" qua: "+quantidade+" codF: "+fornecedor.getCodigo().toString();
	}


}
