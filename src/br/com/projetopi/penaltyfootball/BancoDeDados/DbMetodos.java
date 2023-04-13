package br.com.projetopi.penaltyfootball.BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class DbMetodos {
	
	public static void adicionarNaTabelaRanking(String nome, int pontuacao) {
		//Atributos de conexão JBDC
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        // Carrega o driver JDBC do MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Define os parâmetros de conexão
	        String url = "jdbc:mysql://containers-us-west-39.railway.app:7370/railway";
	        String usuario = "root";
	        //senha do banco de dados
	        String senha = "lMnPfO3W5wHiMC8kANDh";

	        // Estabelece a conexão
	        conn = DriverManager.getConnection(url, usuario, senha);

	        // Verifica se já existe um registro com o mesmo nome e pontuação no banco de dados
	        // Comando utilizado no banco de dados
	        String sqlVerifica = "SELECT nome, pontuacao FROM rankeada WHERE nome = ? AND pontuacao = ?";
	        PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica);
	        stmtVerifica.setString(1, nome);
	        stmtVerifica.setInt(2, pontuacao);
	        rs = stmtVerifica.executeQuery();

	        if (rs.next()) {
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
	public static void exibirRanking() {
		//Atributos de conexão JBDC
		System.out.println();
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        // Carrega o driver JDBC do MySQL
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // Define os parâmetros de conexão
	        String url = "jdbc:mysql://containers-us-west-39.railway.app:7370/railway";
	        String usuario = "root";
	        String senha = "lMnPfO3W5wHiMC8kANDh";

	        // Estabelece a conexão
	        conn = DriverManager.getConnection(url, usuario, senha);

	        // Prepara a instrução SQL para mostra as 10 melhores posicoes do ranking
	        String sql = "SELECT id, nome, pontuacao FROM rankeada ORDER BY pontuacao DESC LIMIT 10";
	        stmt = conn.prepareStatement(sql);

	        // Executa a consulta SQL
	        rs = stmt.executeQuery();

	        // Imprime os resultados
	        System.out.println("RANKING GLOBAL");
	        int contador = 0;
	        while (rs.next()) {
	            contador++;
	            int id = rs.getInt("id");
	            String nome = rs.getString("nome");
	            int pontuacao = rs.getInt("pontuacao");
	            System.out.println( contador +" Posicao" +" Id: " + id  + " - " + nome + " - " + pontuacao + " Pontos");
	            
	        }
                 //excessão
	    } catch (ClassNotFoundException e) {
	        // Se o driver JDBC não puder ser carregado, exibe uma mensagem de erro
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // Se ocorrer um erro durante a conexão ou consulta, exibe uma mensagem de erro
	        e.printStackTrace();
	    } finally {
	        try {
	            // Fecha os recursos
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            // Se ocorrer um erro ao fechar os recursos, exibe uma mensagem de erro
	            e.printStackTrace();
	        }
	    }
	    System.out.println();
	}
}
