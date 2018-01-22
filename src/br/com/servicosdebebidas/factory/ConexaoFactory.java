package br.com.servicosdebebidas.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	//private static final String DRIVER = "org.postgresql.Driver";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "hunter23";
	private static final String URL = "jdbc:postgresql://localhost:5432/servicosdb";

	public static Connection conectar() throws SQLException{
		DriverManager.registerDriver(new org.postgresql.Driver());
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		return connection;
	}
	
	public static void main(String[] args) {
		try {
			Connection connection = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso!");
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a conexão.");
		}
	}
}
