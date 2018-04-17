package Controle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package Controle*/
import DAO.ProdutoDAO;
import Modelo.Categoria;
import Modelo.Produto;
import Modelo.TipoProduto;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author 11151505692
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
            if (acao.equals("Cadastrar")) {
                Produto produto = new Produto();
                produto.setNome(request.getParameter("txtNome"));
                produto.setImagem(request.getParameter("flImagem"));
                produto.setDataValidade(Date.valueOf(request.getParameter("txtDValidade")));
                String tipoPreco = request.getParameter("optTPreco");
                    if (tipoPreco.equalsIgnoreCase("Duzia")) {
                        produto.setTipoPreco(TipoProduto.Duzia);
                    } else
                    if (tipoPreco.equalsIgnoreCase("Unidade")) {
                        produto.setTipoPreco(TipoProduto.Unidade);
                    } else
                    if (tipoPreco.equalsIgnoreCase("Peso")) {
                        produto.setTipoPreco(TipoProduto.Peso);
                    } else {
                        produto.setTipoPreco(TipoProduto.Selecionar);
                    }
                produto.setPreco(Double.parseDouble(request.getParameter("txtPreco")));
                produto.setQuantidade(Integer.parseInt(request.getParameter("txtQuantidade")));
                produto.setQuantidadeMinima(Integer.parseInt(request.getParameter("txtQMinima")));
                String categoria = request.getParameter("optCategoria");
                    if (categoria.equalsIgnoreCase("Fruta")) {
                        produto.setCategoria(Categoria.Frutas);
                    } else
                    if (categoria.equalsIgnoreCase("Legumes")) {
                        produto.setCategoria(Categoria.Legumes);
                    } else
                    if (categoria.equalsIgnoreCase("Verdura")) {
                        produto.setCategoria(Categoria.Verduras);
                    } else {
                        produto.setCategoria(Categoria.Selecionar);
                    }

                ProdutoDAO dao = new ProdutoDAO();
                dao.cadastrar(produto);

                request.setAttribute("msg", "Produto cadastrado com sucesso");
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
                rd.forward(request, response);
            
        }else if (acao.equals("Listar")) {

            ProdutoDAO dao = new ProdutoDAO();
            ArrayList<Produto> produto = dao.listar();

            //atribuir a lista ao request
            request.setAttribute("listaProduto", produto);
            request.getRequestDispatcher("/admin/listaProduto.jsp").forward(request, response);

        }else if (acao.equals("Excluir")) {

            ProdutoDAO dao = new ProdutoDAO();
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            Produto produto = new Produto();
            produto.setCodigo(codigo);

            dao.excluir(produto);


            out.println("Produto EXCLUIDO ");
            
                RequestDispatcher rd = request.getRequestDispatcher("ControleProduto?acao=Listar");
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
