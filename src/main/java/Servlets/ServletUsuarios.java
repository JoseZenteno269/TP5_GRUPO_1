package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import I_Negocio.I_NegocioUsuarios;
import Negocio.NegocioUsuario;


@WebServlet("/ServletUsuarios")
public class ServletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final I_NegocioUsuarios negocioUsuarios = new NegocioUsuario();

    public ServletUsuarios() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String usuario = request.getParameter("txtUsuario");
		String password = request.getParameter("txtPassword");

		if (esVacio(usuario) || esVacio(password)) {
			mostrarLoginConError(request, response, "Ingresá el usuario y la contraseña.");
			return;
		}

		if (!Boolean.TRUE.equals(negocioUsuarios.validarUsuario(usuario, password))) {
			mostrarLoginConError(request, response, "Usuario o contraseña incorrectos.");
			return;
		}

		request.getSession().setAttribute("usuario", usuario);
		response.sendRedirect(request.getContextPath() + "/ServletClientes");
	}

	private boolean esVacio(String valor) {
		return valor == null || valor.isBlank();
	}

	private void mostrarLoginConError(HttpServletRequest request, HttpServletResponse response,
			String mensaje) throws ServletException, IOException {
		request.setAttribute("mensajeError", mensaje);
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

}
