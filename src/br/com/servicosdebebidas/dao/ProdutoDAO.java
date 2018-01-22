package br.com.servicosdebebidas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.servicosdebebidas.domain.Fornecedor;
import br.com.servicosdebebidas.domain.Produto;
import br.com.servicosdebebidas.factory.ConexaoFactory;

public class ProdutoDAO {

	public void salvar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, preco, quantidade, CodFornecedor)");
		sql.append("VALUES (?, ?, ?, ?)");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, produto.getDescricao());
		comando.setDouble(2, produto.getPreco());
		comando.setLong(3, produto.getQuantidade());
		comando.setLong(4, produto.getFornecedor().getCodigo());
		comando.executeUpdate();
	}
	
	public static ArrayList<Produto> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.CodProduto, p.produto, p.descricao, p.quantidade, p.preco, f.CodFornecedor, f.fornecedor, f.descricao");
		sql.append("FROM produtos as p ");
		sql.append("INNER JOIN fornecedores as f ON p.CodFornecedor = f.CodFornecedor; ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		
		ResultSet resultSet = comando.executeQuery();
		ArrayList<Produto> retorno = new ArrayList<Produto>();
		while(resultSet.next()) {
			Fornecedor f = new Fornecedor();
			f.setCodigo(resultSet.getLong("f.CodFornecedor"));
			f.setFornecedor(resultSet.getString("f.fornecedor"));
			f.setDescricao(resultSet.getString("f.descricao"));
			
			Produto p = new Produto();
			p.setCodigo(resultSet.getLong("p.CodProduto"));
			p.setDescricao(resultSet.getString("p.descricao"));
			p.setPreco(resultSet.getDouble("p.preco"));
			p.setQuantidade(resultSet.getInt("p.quantidade"));
			p.setFornecedor(f);
			retorno.add(p);
		}
		return retorno;		
	}
	
	public void excluir(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE*FROM produtos");
		sql.append("WHERE CodProduto = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, produto.getCodigo());
		comando.executeUpdate();
	}
	
	public void editar(Produto produto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?, preco = ?, quantidade = ?, CodFornecedor = ? ");
		sql.append("WHERE CodProduto = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, produto.getDescricao());
		comando.setDouble(2, produto.getPreco());
		comando.setLong(3, produto.getQuantidade());
		comando.setLong(4, produto.getFornecedor().getCodigo());
		comando.setLong(5, produto.getCodigo());
		comando.executeUpdate();		
	}	
}
