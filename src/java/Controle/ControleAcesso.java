/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Usuario;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11151505692
 */
@WebServlet(name = "ControleAcesso", urlPatterns = {"/ControleAcesso"})
public class ControleAcesso extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try{
            String acao = request.getParameter("acao");
            if(acao.equals("Entrar")){
                Usuario usuario = new Usuario();
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(usuario);
                //se o usuario existe no banco de dados
                if(usuarioAutenticado!=null){
                    
                    //cria uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado",usuarioAutenticado);
                    
                    //redireciona para a pagina principal
                    //response.sendRedirect("principal.jsp");
                    request.setAttribute("msg", "Bem-Vindo!");
                    RequestDispatcher rd = request.getRequestDispatcher("admin/autenticado_adm.jsp");
                    rd.forward(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("admin/autenticado_adm.jsp");
                    request.setAttribute("msg", "Login ou Senha estão incorretos");
                    rd.forward(request, response);                   
                }
            }else
                if (acao.equals("Sair")){
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.removeAttribute("usuarioAutenticado");
                    response.sendRedirect("logout.jsp");
                }
        }catch (Exception erro){
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
