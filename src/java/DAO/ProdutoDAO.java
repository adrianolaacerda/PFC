/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Produto;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProdutoDAO {

    private Connection conexao = null;

    public ProdutoDAO() {

        this.conexao = ConectaBanco.getConexao();

    }

    private static final String CADASTRAR_PRODUTO = "INSERT INTO produto (nome, descricao, categoria, precoUnitario, imagem) VALUES(?,?,?,?,?)";
    private static final String SELECT_PRODUTO = "SELECT * FROM produto";
    private static final String UPDATE_PRODUTO = "UPDATE produto SET nome = ?, descricao = ?, categoria = ?,precoUnitario = ?, imagem = ? WHERE id = ?";
    private static final String DELETE_PRODUTO = "DELETE FROM produto WHERE id = ?";
    private static final String SELECTID = "select * from produto where id = ?";

    public void cadastrarProduto(Produto produto) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {

            conexao = ConectaBanco.getConexao();

            pstmt = conexao.prepareStatement(CADASTRAR_PRODUTO, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setDouble(4, produto.getPrecoUnitario());
            pstmt.setString(5, produto.getImagem());
            pstmt.execute();

            ResultSet rsIDProduto = pstmt.getGeneratedKeys();
            rsIDProduto.next();
            //seta o id do cliente gerado no banco
            produto.setId(rsIDProduto.getInt("id"));

            //confirma as operaÃ§Ãµes
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Produto.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        ResultSet rs;

        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_PRODUTO);

        rs = pstmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
            produto.setImagem(rs.getString("imagem"));
            produtos.add(produto);

        }

        return produtos;
    }

    public Produto consultarProduto(Produto produto) {

        try {

            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_PRODUTO);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setCategoria(rs.getString("categoria"));
                prod.setPrecoUnitario(rs.getDouble("precoUnitario"));
                prod.setImagem(rs.getString("imagem"));

                return prod;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Produto consultarPorId(int id) {
        Connection conexao = null;
        Produto produto = new Produto();
        try {
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECTID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPrecoUnitario(rs.getDouble("precoUnitario"));
                produto.setImagem(rs.getString("imagem"));
            }
        } catch (SQLException ex1) {
            throw new RuntimeException(ex1);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex2) {
                throw new RuntimeException(ex2);
            }

        }
        return produto;
    }

    public void alterar(Produto produto) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_PRODUTO);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setString(3, produto.getCategoria());
            pstmt.setDouble(4, produto.getPrecoUnitario());
            pstmt.setString(5, produto.getImagem());
            pstmt.setInt(6, produto.getId());
            pstmt.executeUpdate();
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

    public void excluir(Produto produto) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_PRODUTO);
            pstmt.setInt(1, produto.getId());
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
