package br.com.servicosdebebidas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.servicosdebebidas.domain.Fornecedor;
import br.com.servicosdebebidas.factory.ConexaoFactory;

public class FornecedorDAO {
	
	public void salvar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores");
		sql.append("(fornecedor)");
		sql.append("VALUES (?)");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, fornecedor.getFornecedor());
		comando.executeUpdate();
	}
	
	public void excluir(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores");
		sql.append("WHERE CodFornecedor = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, fornecedor.getCodigo());
		comando.executeUpdate();
	}
	
	public void editar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores");
		sql.append("SET fornecedor = ? ");
		sql.append("WHERE CodFornecedor = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setString(1, fornecedor.getFornecedor());
		comando.setLong(2, fornecedor.getCodigo());
		comando.executeUpdate();		
	}
	
	public Fornecedor pesquisar(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CodFornecedor, fornecedor, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE CodFornecedor = ? ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		comando.setLong(1, fornecedor.getCodigo());
		
		ResultSet resultSet = comando.executeQuery();
		Fornecedor retorno = null;
		if(resultSet.next()) {
			retorno = new Fornecedor();
			retorno.setCodigo(resultSet.getLong("CodFornecedor"));
			retorno.setFornecedor(resultSet.getString("fornecedor"));
			retorno.setDescricao(resultSet.getString("descricao"));
		}
		return retorno;
	}
	
	public static ArrayList<Fornecedor> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CodFornecedor, fornecedor, descricao ");
		sql.append("FROM fornecedores ");
		// ordena a lista por descrições ascendentes.
		sql.append("ORDER BY CodFornecedor ASC ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		
		ResultSet resultSet = comando.executeQuery();
		ArrayList<Fornecedor> retorno = new ArrayList<Fornecedor>();
		while(resultSet.next()) {
			Fornecedor f = new Fornecedor();
			f.setCodigo(resultSet.getLong("CodFornecedor"));
			f.setFornecedor(resultSet.getString("fornecedor"));
			f.setDescricao(resultSet.getString("descricao"));
			retorno.add(f);
		}
		return retorno;
	}
	
	public static ArrayList<Fornecedor> buscarPorFornecedor(Fornecedor fornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CodFornecedor, fornecedor, descricao ");
		sql.append("FROM fornecedores ");
		// ajuda com consultas por palavra inserida na descrição.
		sql.append("WHERE fornecedor LIKE ? ");
		sql.append("ORDER BY fornecedor ASC ");
		
		Connection connection = ConexaoFactory.conectar();
		PreparedStatement comando = connection.prepareStatement(sql.toString());
		// a percentagem torna a posição da descrição na cadeia para se tornar irrelevante.
		comando.setString(1, "%"+fornecedor.getFornecedor()+"%");
		
		ResultSet resultSet = comando.executeQuery();
		ArrayList<Fornecedor> retorno = new ArrayList<Fornecedor>();
		while(resultSet.next()) {
			Fornecedor f = new Fornecedor();
			f.setCodigo(resultSet.getLong("CodFornecedor"));
			f.setFornecedor(resultSet.getString("fornecedor"));
			f.setDescricao(resultSet.getString("descricao"));
			retorno.add(f);
		}
		return retorno;
	}
	
	public static void main(String[] args) {
		
		Fornecedor f1 = new Fornecedor();
		Fornecedor f2 = new Fornecedor();
		f1.setCodigo(1L);
		f1.setFornecedor("Ypióca");
		f1.setDescricao("Cachaça");
		f2.setCodigo(6L);
		f2.setFornecedor("Skol");
		f2.setDescricao("Cerveja");
		
		FornecedorDAO fdao = new FornecedorDAO();
		
		try {
			ArrayList<Fornecedor> fornecedor = buscarPorFornecedor(f1);
			for(Fornecedor f : fornecedor) {
				System.out.println(f.toString());
			}
			
			System.out.println("Operação realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar executar os metodos");
			e.printStackTrace();
		}
	}

}
