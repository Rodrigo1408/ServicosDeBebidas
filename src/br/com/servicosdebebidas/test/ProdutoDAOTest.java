package br.com.servicosdebebidas.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.servicosdebebidas.dao.ProdutoDAO;
import br.com.servicosdebebidas.domain.Fornecedor;
import br.com.servicosdebebidas.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws SQLException{
		Produto p = new Produto();
		p.setDescricao("Vinho do gaúcho");
		p.setPreco(59.9D);
		p.setQuantidade(13);
		
		Fornecedor f = new Fornecedor();
		f.setCodigo(1L);
		
		p.setFornecedor(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> produtos = dao.listar();
		
		for(Produto produto : produtos) {
			System.out.println(produto.toString());
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(2L);
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
	}
    
	@Test
	public void editar() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(1L);
		p.setDescricao("Vinho do gaúcho");
		p.setQuantidade(32);
		p.setPreco(45.5);
		Fornecedor f = new Fornecedor();
		f.setCodigo(1L);
		p.setFornecedor(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}
}
