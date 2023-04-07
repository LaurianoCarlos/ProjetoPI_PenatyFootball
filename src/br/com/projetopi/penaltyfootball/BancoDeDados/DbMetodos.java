package br.com.projetopi.penaltyfootball.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class DbMetodos {
	
	public static void adicionarNaTabelaRanking(String nome, int pontuacao) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	        // Carrega o driver JDBC do MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Define os parâmetros de conexão
	        String url = "jdbc:mysql://containers-us-west-39.railway.app:7370/railway";
	        String user = "root";
	        String password = "lMnPfO3W5wHiMC8kANDh";

	        // Estabelece a conexão
	        conn = DriverManager.getConnection(url, user, password);

	        // Verifica se já existe um registro com o mesmo nome e pontuação
	        String sqlVerifica = "SELECT nome, pontuacao FROM rankeada WHERE nome = ? AND pontuacao = ?";
	        PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica);
	        stmtVerifica.setString(1, nome);
	        stmtVerifica.setInt(2, pontuacao);
	        rs = stmtVerifica.executeQuery();

	        if (rs.next()) {
	            // Já existe um registro com os mesmos valores de nome e pontuação
	            System.out.println("Já existe um registro com os valores informados.");
	        } else {
	            // Prepara a instrução SQL
	            String sql = "INSERT INTO rankeada (nome, pontuacao) VALUES (?, ?)";
	            stmt = conn.prepareStatement(sql);

	            // Define os parâmetros da instrução SQL
	            stmt.setString(1, nome);
	            stmt.setInt(2, pontuacao);

	            // Executa a instrução SQL
	            stmt.executeUpdate();

	            System.out.println("Registro adicionado com sucesso.");
	        }
	    } catch (ClassNotFoundException e) {
	        // Se o driver JDBC não puder ser carregado, exibe uma mensagem de erro
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // Se ocorrer um erro durante a conexão ou consulta, exibe uma mensagem de erro
	        e.printStackTrace();
	    } finally {
	        try {
	            // Fecha os recursos
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (rs != null) {
	                rs.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            // Se ocorrer um erro ao fechar os recursos, exibe uma mensagem de erro
	            e.printStackTrace();
	        }
	    }
	}


}
