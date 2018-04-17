/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Pessoa;
import Modelo.Usuario;
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
public class PessoaDAO {

    //conexão com o banco 
    private Connection conexao = null;

    public PessoaDAO() {

        this.conexao = ConectaBanco.getConexao();

    }

    // tabela pessoa (SQL)
    private static final String CADASTRA_PESSOA = "INSERT INTO pessoa (nome, cpf, rg, dataNasc, email, telefone, logradouro, numero, cep, bairro, cidade, estado ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_PESSOA = "SELECT * FROM pessoa";
    private static final String UPDATE_PESSOA = "UPDATE pessoa SET nome = ?, cpf = ?, rg = ?, dataNasc = ?, email = ?, telefone = ?, logradouro = ?, numero = ?, cep = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?";
    private static final String DELETE_PESSOA = "DELETE FROM pessoa WHERE id = ?";

    // cadastrar novo usuário
    public void cadastrarPessoa(Pessoa pessoa) {

        try {
            conexao.setAutoCommit(false);

            PreparedStatement pstmtPessoa = conexao.prepareStatement(CADASTRA_PESSOA, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmtPessoa.setString(1, pessoa.getNome());
            pstmtPessoa.setInt(2, pessoa.getCpf());
            pstmtPessoa.setInt(3, pessoa.getRg());
            pstmtPessoa.setDate(4, pessoa.getDataNasc());//
            pstmtPessoa.setString(5, pessoa.getEmail());
            pstmtPessoa.setString(6, pessoa.getTelefone());
            pstmtPessoa.setString(7, pessoa.getLogradouro());
            pstmtPessoa.setInt(8, pessoa.getNumero());
            pstmtPessoa.setInt(9, pessoa.getCep());
            pstmtPessoa.setString(10, pessoa.getBairro());
            pstmtPessoa.setString(11, pessoa.getCidade());
            pstmtPessoa.setString(12, pessoa.getEstado());
            pstmtPessoa.execute();

            ResultSet rsIDPessoa = pstmtPessoa.getGeneratedKeys();
            rsIDPessoa.next();
            //seta o id do cliente gerado no banco
            pessoa.setId(rsIDPessoa.getInt("id"));

            //confirma as operações
            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();

            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Pessoa.class.getName()).
                    log(Level.SEVERE, "Erro ao cadastrar: " + e.getMessage());
        } finally {
            //4
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Pessoa> listarPessoa() throws SQLException {
        ArrayList<Pessoa> listarPessoa = new ArrayList<Pessoa>();

        Connection conexao = ConectaBanco.getConexao();

        PreparedStatement pstmt = conexao.prepareStatement(SELECT_PESSOA);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Pessoa pessoa = new Pessoa();

            pessoa.setId(rs.getInt("id"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setCpf(rs.getInt("cpf"));
            pessoa.setRg(rs.getInt("rg"));
            pessoa.setDataNasc(rs.getDate("dataNasc"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setLogradouro(rs.getString("logradouro"));
            pessoa.setNumero(rs.getInt("numero"));
            pessoa.setCep(rs.getInt("cep"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setCidade(rs.getString("cidade"));
            pessoa.setEstado(rs.getString("estado"));

            consultaPorID(pessoa);
            listarPessoa.add(pessoa);

        }

        return listarPessoa;
    }

    public void consultaPorID(Pessoa pessoa) {

        try {

            Connection conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(SELECT_PESSOA);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Pessoa pessoas = new Pessoa();

                pessoas.setId(rs.getInt("id"));
                pessoas.setNome(rs.getString("nome"));
                pessoas.setCpf(rs.getInt("cpf"));
                pessoas.setRg(rs.getInt("rg"));
                pessoas.setDataNasc(rs.getDate("dataNasc"));
                pessoas.setEmail(rs.getString("email"));
                pessoas.setTelefone(rs.getString("telefone"));
                pessoas.setLogradouro(rs.getString("logradouro"));
                pessoas.setNumero(rs.getInt("numero"));
                pessoas.setCep(rs.getInt("cep"));
                pessoas.setBairro(rs.getString("bairro"));
                pessoas.setCidade(rs.getString("cidade"));
                pessoas.setEstado(rs.getString("estado"));

                pessoa.addPessoa(pessoa);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void alterar(Pessoa pessoa) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_PESSOA);

            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getCpf());
            pstmt.setInt(3, pessoa.getRg());
            pstmt.setDate(4, pessoa.getDataNasc());
            pstmt.setString(5, pessoa.getEmail());
            pstmt.setString(6, pessoa.getTelefone());
            pstmt.setString(7, pessoa.getLogradouro());
            pstmt.setInt(8, pessoa.getNumero());
            pstmt.setInt(9, pessoa.getCep());
            pstmt.setString(10, pessoa.getBairro());
            pstmt.setString(11, pessoa.getCidade());
            pstmt.setString(12, pessoa.getEstado());
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

    public void excluir(Pessoa pessoa) {
        Connection conexao = null;

        try {

            conexao = ConectaBanco.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement(DELETE_PESSOA);
            pstmt.setInt(1, pessoa.getId());
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
