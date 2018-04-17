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

/**
 *
 * @author thays.reis
 */
public class ProdutoDAO {
    private static final String INSERT = "INSERT INTO produto (nome, imagem, dataValidade, tipoPreco, preco, quantidade, quantidadeMinima, categoria) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM produto";
    private static final String UPDATE = "UPDATE produto SET codigo = ?, nome = ?, imagem = ?, dataValidade = ?, tipoPreco = ?, preco = ?, quantidade = ?, quantidadeMinima = ? WHERE codigo = ?";
    private static final String DELETE = "DELETE FROM produto WHERE codigo = ?";
    
    public void cadastrar(Produto produto){
        Connection conexao = null; 
        PreparedStatement pstmt = null;
        try {

            conexao = ConectaBanco.getConexao();

            pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getImagem());
            pstmt.setDate(3, produto.getDataValidade());
            pstmt.setString(4, produto.getTipoPreco().toString());
            pstmt.setDouble(5, produto.getPreco());
            pstmt.setInt(6, produto.getQuantidade());
            pstmt.setInt(7, produto.getQuantidadeMinima());
            pstmt.setString(8, produto.getCategoria().toString());
            pstmt.execute();
        }  catch (SQLException sqlErro) {
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
    }
    
    public ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> listaProduto = new ArrayList<Produto>();

        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            

            produto.setCodigo(rs.getInt("codigo"));
            produto.setNome(rs.getString("nome"));
            produto.setImagem(rs.getString("imagem"));
            produto.setDataValidade(rs.getDate("dataValidade"));
            produto.setTipoPreco(TipoProduto.valueOf(rs.getString("tipoPreco")));
            produto.setPreco(rs.getDouble("preco"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setQuantidadeMinima(rs.getInt("quantidadeMinima"));
            produto.setCategoria(Categoria.valueOf(rs.getString("categoria")));
            
            consultarProduto(produto);
            listaProduto.add(produto);

        }

        return listaProduto;
    }
    
     private void consultarProduto(Produto produto){
        
        try{
            
        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);

        ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Produto prod = new Produto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getDouble("preco"));
                
                produto.addProduto(produto);
            }
   
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        
        
    }

    public void excluir(Produto produto) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, produto.getCodigo());
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
