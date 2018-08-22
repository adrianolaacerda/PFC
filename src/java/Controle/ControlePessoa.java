/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.PessoaDAO;
import Modelo.Pessoa;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "ControlePessoa", urlPatterns = {"/ControlePessoa"})
public class ControlePessoa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        try {

            //CADASTRAR
            if (acao.equals("CadastrarPessoa")) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(request.getParameter("txtNome"));
                pessoa.setCpf(Integer.parseInt(request.getParameter("txtCPF")));
                pessoa.setRg(Integer.parseInt(request.getParameter("txtRG")));
                pessoa.setDataNasc(Date.valueOf(request.getParameter("txtdataNasc")));
                pessoa.setEmail(request.getParameter("txtEmail"));
                pessoa.setTelefone(request.getParameter("txtTelefone"));
                pessoa.setLogradouro(request.getParameter("txtLogradouro"));
                pessoa.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
                pessoa.setCep(Integer.parseInt(request.getParameter("txtCEP")));
                pessoa.setBairro(request.getParameter("txtBairro"));
                pessoa.setCidade(request.getParameter("txtCidade"));
                pessoa.setEstado(request.getParameter("txtEstado"));

                PessoaDAO pessoaDAO = new PessoaDAO();
                pessoaDAO.cadastrarPessoa(pessoa);

                request.setAttribute("pessoa", pessoa);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/cadastro_usuario.jsp");
                rd.forward(request, response);

                // LISTAR 
            } else if (acao.equals("Listar")) {

                PessoaDAO dao = new PessoaDAO();
                ArrayList<Pessoa> pessoa = dao.listarPessoa();

                //atribuir a lista ao request
                request.getSession().setAttribute("listaPessoa", pessoa);
                request.getRequestDispatcher("/admin/listaPessoa.jsp").forward(request, response);

                // CONSULTAR 
            } else if (acao.equals("consultarPessoa")) {

                PessoaDAO dao = new PessoaDAO();
                int id = Integer.parseInt(request.getParameter("id"));

                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);

                dao.consultarPessoa(pessoa);

                request.setAttribute("pessoa", pessoa);
                request.getRequestDispatcher("/admin/alterar_pessoa.jsp").forward(request, response);


                // ALTERAR
            } else if (acao.equals("Alterar")) {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(request.getParameter("txtNome"));
                pessoa.setCpf(Integer.parseInt(request.getParameter("txtCPF")));
                pessoa.setRg(Integer.parseInt(request.getParameter("txtRG")));
                pessoa.setDataNasc(Date.valueOf(request.getParameter("txtdataNasc")));
                pessoa.setEmail(request.getParameter("txtEmail"));
                pessoa.setTelefone(request.getParameter("txtTelefone"));
                pessoa.setLogradouro(request.getParameter("txtLogradouro"));
                pessoa.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
                pessoa.setCep(Integer.parseInt(request.getParameter("txtCEP")));
                pessoa.setBairro(request.getParameter("txtBairro"));
                pessoa.setCidade(request.getParameter("txtCidade"));
                pessoa.setEstado(request.getParameter("txtEstado"));
                pessoa.setId(Integer.parseInt(request.getParameter("txtID")));

                PessoaDAO pessoaDAO = new PessoaDAO();
                
                //PrintWriter out = response.getWriter();
                pessoaDAO.alterar(pessoa);
                request.setAttribute("pessoa", pessoa);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
                rd.forward(request, response);

                // AlterarPessoa
                } else if (acao.equals("AlterarPessoa")) {
                Pessoa p = new Pessoa();
                p.setId(Integer.parseInt(request.getParameter("id")));
                PessoaDAO dao = new PessoaDAO();
                p = dao.consultarPessoa(p);
                request.setAttribute("pessoa", p);
                request.getRequestDispatcher("/admin/alterar_pessoa.jsp").forward(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
        
                
                // EXCLUIR
            } else if (acao.equals("Excluir")) {

                PessoaDAO dao = new PessoaDAO();
                int id = Integer.parseInt(request.getParameter("id"));

                Pessoa pessoa = new Pessoa();
                pessoa.setId(id);
                dao.excluir(pessoa);

                RequestDispatcher rd = request.getRequestDispatcher("ControlePessoa?acao=Listar");
                rd.forward(request, response);
            }
        } catch (Exception erro) {
            erro.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
