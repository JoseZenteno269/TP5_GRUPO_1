package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import Negocio.NegocioUsuarios;

@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	NegocioUsuarios negocioUsuarios = new NegocioUsuarios(); 
	
	private static final long serialVersionUID = 1L;

    public ServletUsuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
//    	RequestDispatcher dispatcher = request.getRequestDispatcher("/InsertarArticulos.jsp");
//		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnIngresar") != null) {
			
			Boolean estado = false; 
			estado = negocioUsuarios.validarUsuario(request.getParameter("txtUsuario"), request.getParameter("txtPassword"));
			
			request.setAttribute("Estado", estado);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
