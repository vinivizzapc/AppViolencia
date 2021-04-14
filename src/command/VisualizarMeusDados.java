package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Service.UsuarioService;

public class VisualizarMeusDados implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		
		int idUsuario = (Integer)request.getSession().getAttribute("idUsuario");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");

		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(pNome);
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);

		UsuarioService us = new UsuarioService();
		
		RequestDispatcher view = null;
		
		usuario = us.carregar(usuario.getIdUsuario());
		request.setAttribute("usuario", usuario);
		view = request.getRequestDispatcher("MeusDados.jsp");
		view.forward(request, response);
	}
}