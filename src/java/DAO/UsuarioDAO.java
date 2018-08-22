/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author PC
 */
import Modelo.PerfilDeAcesso;
import Modelo.Pessoa;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.ConectaBanco;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private Connection conexao = null;

    public UsuarioDAO() {

        this.conexao = ConectaBanco.getConexao();

    }

    // SQL Usuario
    private static final String CADASTRAR_USUARIO = "INSERT INTO usuario (login, senha, perfil) VALUES (?,?,?)";
    private static final String AUTENTICAR_USUARIO = "SELECT * FROM usuario WHERE login=? AND senha=?";
    private static final String SELECT_USUARIO = "SELECT * FROM usuario";
    private static final String UPDATE_USUARIO = "UPDATE usuario SET  login = ?, senha = ?, perfil = ? WHERE id = ?";
    private static final String DELETE_USUARIO = "DELETE FROM usuario WHERE id = ?";

    public void cadastrarUsuario(Usuario usuario) {
 try {
            conexao.setAutoCommit(false);
           
            
            PreparedStatement pstmtUsuario = conexao.prepareStatement(CADASTRAR_USUARIO, PreparedStatement.RETURN_GENERATED_KEYS);
           
            pstmtUsuario.setString(1, usuario.getLogin());
            pstmtUsuario.setString(2, usuario.getSenha());
            pstmtUsuario.setString(3, usuario.getPerfil().toString());
            pstmtUsuario.execute();
            
            ResultSet rsIdUsuario = pstmtUsuario.getGeneratedKeys();
            rsIdUsuario.next();
            //seta o id do cliente gerado no banco
            usuario.setId(rsIdUsuario.getInt("id"));
            
           
            //confirma as operações
            conexao.commit();
   
        }catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Usuario.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
      
    public Usuario autenticarUsuario(Usuario usuario) {
        Usuario usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICAR_USUARIO);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            rsUsuario = pstmt.executeQuery();
            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setLogin(rsUsuario.getString("login"));
                usuarioAutenticado.setSenha(rsUsuario.getString("senha"));
                usuarioAutenticado.setPerfil(PerfilDeAcesso.valueOf(rsUsuario.getString("perfil")));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return usuarioAutenticado;
    }

    public ArrayList<Usuario> listarUsuario() throws SQLException {
        ArrayList<Usuario> listarUsuario = new ArrayList<Usuario>();

        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setPessoa(new Pessoa());
            usuario.getPessoa().setId(rs.getInt("usuario"));
            usuario.setPerfil(PerfilDeAcesso.valueOf(rs.getString("perfil")));

            ///consultaPorID(usuario);
            listarUsuario.add(usuario);

        }

        return listarUsuario;
    }

    public Usuario ConsultarUsuario(Usuario usuario) {

        try {

            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                
               
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfil(PerfilDeAcesso.valueOf(rs.getString("perfil")));
                
                return usuario;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    

    public void alterar(Usuario usuario) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_USUARIO);

            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getPerfil().toString());
            pstmt.setInt(4, usuario.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void excluir(Usuario usuario) {
        
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_USUARIO);
            pstmt.setInt(1, usuario.getId());
            pstmt.execute();
            conexao.commit();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
