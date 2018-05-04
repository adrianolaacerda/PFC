/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.PerfilDeAcesso;
import Modelo.Usuario;
import DAO.UsuarioDAO;
import Modelo.Pessoa;
import java.io.IOException;
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
@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

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

            if (acao.equals("Cadastrar")) {
                Usuario usuario = new Usuario();
                usuario.setLogin(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                usuario.setPessoa(new Pessoa());
                usuario.getPessoa().setId(Integer.parseInt(request.getParameter("idPessoa")));
                String perfil = request.getParameter("optPerfil");
                if (perfil.equalsIgnoreCase("funcionario")) {
                    usuario.setPerfil(PerfilDeAcesso.Funcionario);
                } else {
                    usuario.setPerfil(PerfilDeAcesso.Cliente);
                }

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuario = usuarioDAO.cadastrarUsuario(usuario);
                
                if (usuario.getId() != 0) {
                    request.setAttribute("msg", "cadastrado com sucesso");
                    request.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/admin/sucesso.jsp");
                } else {
                    request.setAttribute("msg", "usuario ja existe");
                request.setAttribute("usuario", usuario);
                response.sendRedirect(request.getContextPath() + "/admin/usuario-existe.jsp");
                }
                 
                //RequestDispatcher rd = request.getRequestDispatcher("/admin/cadastro_usuario.jsp");
                //rd.forward(request, response);

            } else if (acao.equals("Listar")) {

                UsuarioDAO dao = new UsuarioDAO();
                ArrayList<Usuario> usuario = dao.listarUsuario();

                //atribuir a lista ao request
                request.getSession().setAttribute("listaUsuario", usuario);
                response.sendRedirect(request.getContextPath() + "/admin/listaUsuario.jsp");
                //request.getRequestDispatcher("/admin/listaUsuario.jsp").forward(request, response);

            } else if (acao.equals("ConsultarUsuario")) {

                UsuarioDAO dao = new UsuarioDAO();
                int id = Integer.parseInt(request.getParameter("id"));

                Usuario usuario = new Usuario();
                usuario.setId(id);

                dao.ConsultarUsuario(usuario);

                request.setAttribute("usuario", usuario);
                request.getRequestDispatcher("/alterar_usuario.jsp").forward(request, response);

            } else if (acao.equals("Alterar")) {
                Usuario usuario = new Usuario();
                usuario.setId(Integer.parseInt(request.getParameter("id")));

                UsuarioDAO usuariodao = new UsuarioDAO();
                usuariodao.alterar(usuario);
                request.setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");
                rd.forward(request, response);

            } else if (acao.equals("AlterarUsuario")) {
                Usuario u = new Usuario();
                u.setId(Integer.parseInt(request.getParameter("id")));
                UsuarioDAO dao = new UsuarioDAO();
                u = dao.ConsultarUsuario(u);
                request.setAttribute("usuario", u);
                request.getRequestDispatcher("/alterar_usuario.jsp").forward(request, response);
                RequestDispatcher rd = request.getRequestDispatcher("/admin/sucesso.jsp");

            } else if (acao.equals("Excluir")) {

                UsuarioDAO dao = new UsuarioDAO();
                int id = Integer.parseInt(request.getParameter("id"));

                Usuario usuario = new Usuario();
                usuario.setId(id);

                dao.excluir(usuario);

                out.println("Usuario EXCLUIDO ");

                RequestDispatcher rd = request.getRequestDispatcher("ControleUsuario?acao=Listar");
                rd.forward(request, response);

            }

        } catch (Exception erro) {
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
