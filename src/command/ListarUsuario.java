package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Service.UsuarioService;

public class ListarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String chave = request.getParameter("data[search]"); 
		UsuarioService us = new UsuarioService();
		ArrayList<Usuario> lista = null;
		
			if (chave != null && chave.length() > 0) {
				lista = us.listarUsuarios(chave);
			} 
			else {
				lista = us.listarUsuarios();
			}
			request.setAttribute("lista", lista);
			
			
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("ListarUsuarios.jsp");
		dispatcher.forward(request, response);

	}

}
