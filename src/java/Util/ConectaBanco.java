/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author 11151505692
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    public static Connection getConexao() {
        Connection conexao = null;
        try {
            //driver que será utilizado             
            Class.forName("org.postgresql.Driver");
            //cria um objeto de conexao com um banco especificado no caminho... 
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pfc", "postgres", "postgres");
            
            conexao.setAutoCommit(false);
        } catch (ClassNotFoundException erro1) {
            throw new RuntimeException(erro1);
        } catch (SQLException erro2) {
            throw new RuntimeException(erro2);
        }
        return conexao;
    }
}
