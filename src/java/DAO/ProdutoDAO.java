/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Produto;
import Modelo.TipoProduto;
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

    private static final String CADASTRAR_PRODUTO = "INSERT INTO produto (nome, datavalidade, quantidade, preco, tipoPreco, categoria,imagem) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_PRODUTO = "SELECT * FROM produto";
    private static final String UPDATE_PRODUTO = "UPDATE produto SET id = ?, nome = ?, dataValidade = ?, quantidade = ?, preco = ?, tipoPreco = ?, categoria=?, imagem = ? WHERE id = ?";
    private static final String DELETE_PRODUTO = "DELETE FROM produto WHERE id = ?";

    public void cadastrarProduto(Produto produto) {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        try {

            conexao = ConectaBanco.getConexao();

            pstmt = conexao.prepareStatement(CADASTRAR_PRODUTO, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, produto.getNome());
            pstmt.setDate(2, produto.getDataValidade());
            pstmt.setInt(3, produto.getQuantidade());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setString(5, produto.getTipoPreco().toString());
            pstmt.setString(6, produto.getCategoria().toString());
            pstmt.setString(7, produto.getImagem());
            pstmt.execute();
            
            ResultSet rsIDProduto = pstmt.getGeneratedKeys();
            rsIDProduto.next();
            //seta o id do cliente gerado no banco
            produto.setId(rsIDProduto.getInt("id"));

            //confirma as operações
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
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_PRODUTO);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDataValidade(rs.getDate("dataValidade"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setTipoPreco(TipoProduto.valueOf(rs.getString("tipoPreco")));
            produto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
            produto.setImagem(rs.getString("imagem"));

            consultarProduto(produto);
            listaProduto.add(produto);

        }

        return listaProduto;
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
                prod.setDataValidade(rs.getDate("dataValidade"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setTipoPreco(TipoProduto.valueOf(rs.getString("tipoPreco")));
                prod.setCategoria(Categoria.valueOf(rs.getString("categoria")));
                prod.setImagem(rs.getString("imagem"));

                return prod;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public void alterar(Produto produto) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_PRODUTO);

            pstmt.setString(1, produto.getNome());
            pstmt.setDate(2, produto.getDataValidade());
            pstmt.setInt(3, produto.getQuantidade());
            pstmt.setDouble(4, produto.getPreco());
            pstmt.setString(5, produto.getTipoPreco().toString());
            pstmt.setString(6, produto.getCategoria().toString());
            pstmt.setString(7, produto.getImagem());
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

    public void excluir(Produto produto) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE_PRODUTO);
            pstmt.setInt(1, produto.getId());
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
