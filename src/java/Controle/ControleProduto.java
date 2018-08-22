package Controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*package Controle*/
import DAO.ProdutoDAO;
import Modelo.Produto;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ControleProduto", urlPatterns = {"/ControleProduto"})
public class ControleProduto extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        if (acao.equals("CadastrarProduto")) {
            
            Produto produto = new Produto();
            
            produto.setNome(request.getParameter("nome"));
            produto.setDescricao(request.getParameter("descricao"));
            produto.setCategoria(request.getParameter("categoria"));
            produto.setPrecoUnitario(Double.parseDouble(request.getParameter("precoUnitario")));
            produto.setImagem(request.getParameter("Imagem"));

            ProdutoDAO dao = new ProdutoDAO();
            dao.cadastrarProduto(produto);

            request.setAttribute("msg", "Produto cadastrado com sucesso");
            RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
            rd.forward(request, response);

            //LISTAR
            
        } else if (acao.equals("Listar")) {

            ProdutoDAO dao = new ProdutoDAO();
            ArrayList<Produto> produto = (ArrayList<Produto>) dao.listar();

            //atribuir a lista ao request
            request.setAttribute("listaProduto", produto);
            request.getRequestDispatcher("/admin/listaProduto.jsp").forward(request, response);
            
            //CONSULTAR
            
            } else if (acao.equals("ConsultaProduto")) {

                ProdutoDAO dao = new ProdutoDAO();
                int id = Integer.parseInt(request.getParameter("id"));

                Produto produto = new Produto();
                produto.setId(id);

                dao.consultarProduto(produto);

                request.setAttribute("produto", produto);
                request.getRequestDispatcher("/admin/alterar_produto.jsp").forward(request, response);

                // ALTERAR
                
            } else if (acao.equals("Alterar")) {
                Produto produto = new Produto();
                produto.setId(Integer.parseInt(request.getParameter("id")));

                ProdutoDAO produtoDAO = new ProdutoDAO();
                
                produtoDAO.alterar(produto);
                request.setAttribute("produto", produto);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
                rd.forward(request, response);
                

            } else if (acao.equals("AlterarProduto")) {
                Produto p = new Produto();
                p.setId(Integer.parseInt(request.getParameter("id")));
                ProdutoDAO dao = new ProdutoDAO();
                p = dao.consultarProduto(p);
                request.setAttribute("produto", p);
                request.getRequestDispatcher("/admin/alterar_produto.jsp").forward(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
   
                
                
                // EXCLUIR
                
        } else if (acao.equals("Excluir")) {

            ProdutoDAO dao = new ProdutoDAO();
            int id = Integer.parseInt(request.getParameter("id"));

            Produto produto = new Produto();
            produto.setId(id);

            dao.excluir(produto);

            out.println("Produto EXCLUIDO ");

            RequestDispatcher rd = request.getRequestDispatcher("ControleProduto?acao=Listar");
            rd.forward(request, response);

        } else if (acao.equals("listaProdutos")) {
                //monta uma lista para exibição na pagina principal
                ArrayList<Produto> produtos = new ProdutoDAO().listar();
                //armazena os produto na requisição
                request.setAttribute("produtos", produtos);
                //invia para index.jsp
                request.getRequestDispatcher("/home_carrinho.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
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
