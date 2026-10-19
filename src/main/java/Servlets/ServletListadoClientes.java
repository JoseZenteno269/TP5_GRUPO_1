package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Entidades.Clientes;
import I_Negocio.I_NegocioClientes;
import Negocio.NegocioClientes;

public class ServletListadoClientes extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final I_NegocioClientes negocioClientes = new NegocioClientes();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Clientes> listaClientes = negocioClientes.obtenerClientes();

        request.setAttribute("listaClientes", listaClientes);

        request.getRequestDispatcher("/Listado.jsp").forward(request, response);
    }
}