package br.com.servicosdebebidas.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.servicosdebebidas.dao.FornecedorDAO;
import br.com.servicosdebebidas.domain.Fornecedor;
import br.com.servicosdebebidas.util.JSFUtil;


@SuppressWarnings("deprecation")
@ManagedBean(name = "MBFornecedor")
@ViewScoped
public class FornecedorBean {
	private ArrayList<Fornecedor> itens;
	private ArrayList<Fornecedor> itensFiltrados;
	private Fornecedor fornecedor;

	public ArrayList<Fornecedor> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Fornecedor> itens) {
		this.itens = itens;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	/**
	 * A ação acontece quando a página é carregada.
	 */
	@PostConstruct
	public void prepararPesquisa() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			itens = dao.listar();
		}catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		fornecedor = new Fornecedor();
	}

	public void novo() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fornecedor salvo com sucesso!");
		}catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso!");
		}catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			FornecedorDAO dao = new FornecedorDAO();
			itens = dao.listar();
			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso!");
		}catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public ArrayList<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


}
