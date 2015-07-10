package paqueteservlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Persona;
import conexionBD.PersonaDAO;

/**
 *
 * @author Patripon
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    Persona user = new Persona();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
        try{
        
        user.setDni(request.getParameter("dni"));
        user.setPass(request.getParameter("pass"));
        PersonaDAO personaDAO = new PersonaDAO();
        user = personaDAO.login(user);
        if (user.isValido()) {
            //La interfaz HttpSession nos permite identificar el usuario a traves de varias paginas web
            HttpSession session = request.getSession(true);
            //Guardamos el objeto user en la sesion actual con el nombre UsuarioSesionActual
            session.setAttribute("UsuarioSesionActual", user);
            response.sendRedirect("mapaAsientos.jsp"); //redirecciona a la pagina de inicio
        }else {
            response.sendRedirect("falloRegistro.jsp"); //redirecciona a la apagina de registro
        }
        }catch (Throwable ex){
                   System.out.println(ex);
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
