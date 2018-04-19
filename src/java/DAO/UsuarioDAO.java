/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author 11151505692
 */
import Modelo.PerfilDeAcesso;
import Modelo.Pessoa;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Util.ConectaBanco;
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
            PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO usuario VALUES(DEFAULT, ?, ?, ?, ?)");
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getPerfil().toString());
            pstmt.setInt(4, usuario.getPessoa().getId());
            pstmt.executeUpdate();

            pstmt = conexao.prepareStatement("SELECT id FROM usuario WHERE login = ?");
            pstmt.setString(1, usuario.getLogin());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
            }
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
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

            consultaPorID(usuario);
            listarUsuario.add(usuario);

        }

        return listarUsuario;
    }

    public Usuario consultaPorID(Usuario usuario) {

        try {

            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPerfil(PerfilDeAcesso.valueOf(rs.getString("perfil")));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    public void alterar(Usuario usuario) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_USUARIO);

            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setString(3, usuario.getPerfil().toString());
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
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE_USUARIO);
            pstmt.setInt(1, usuario.getId());
            pstmt.execute();

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
