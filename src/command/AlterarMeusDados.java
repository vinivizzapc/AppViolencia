package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioService;

public class AlterarMeusDados implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String pIdUsuario = request.getParameter("idUsuario");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		int idUsuario = 1;
		
		try {
			idUsuario = Integer.parseInt(pIdUsuario);
		}catch (NumberFormatException e) { 
			throw new ServletException(e);
		}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(pNome); 
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);

		
		UsuarioService cs = new UsuarioService();
		RequestDispatcher view = null;
		
		cs.atualizar(usuario);
		HttpSession session = request.getSession();
		session.setAttribute("logado", usuario);
		session.setAttribute("idCliente", usuario.getIdUsuario());
		session.setAttribute("logNome", usuario.getNome());
		request.setAttribute("cliente", usuario);
		view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	}
}
