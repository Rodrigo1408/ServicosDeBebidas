package br.com.servicosdebebidas.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.servicosdebebidas.dao.FornecedorDAO;
import br.com.servicosdebebidas.dao.ProdutoDAO;
import br.com.servicosdebebidas.domain.Fornecedor;
import br.com.servicosdebebidas.domain.Produto;
import br.com.servicosdebebidas.util.JSFUtil;

@SuppressWarnings("deprecation")
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;

	private Produto produto;

	private ArrayList<Fornecedor> comboFornecedores;

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}

	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fornecedor> getComboFornecedores() {
		return comboFornecedores;
	}

	public void setComboFornecedores(ArrayList<Fornecedor> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public void carregarListagem() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		try {
			FornecedorDAO fDao = new FornecedorDAO();
			comboFornecedores = fDao.listar();
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void novo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararEditar() {
		try {
			FornecedorDAO fDao = new FornecedorDAO();
			comboFornecedores = fDao.listar();
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			JSFUtil.adicionarMensagemSucesso("Produto excluído com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

}
