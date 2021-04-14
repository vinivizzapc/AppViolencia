package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioService;

public class CriarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pIdUsuario = request.getParameter("idUsuario");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");

		int idUsuario = -1;
		try {
			idUsuario = Integer.parseInt(pIdUsuario);
		} catch (NumberFormatException e) {
		}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNome(pNome); 
		usuario.setEmail(pEmail);
		usuario.setSenha(pSenha);

		UsuarioService us = new UsuarioService();
		int retorno = us.criar(usuario);
		
		if(retorno == -1) {
			System.out.println("Não Cadastrou" + usuario);
			request.setAttribute("err", "Email já existente");
			request.getRequestDispatcher("Cadastro.jsp").forward(request, response);
		}
		
		if(us.validar(usuario)) {
			HttpSession session = request.getSession();
			usuario = us.carregarEmail(usuario.getEmail());
			session.setAttribute("logado", usuario);
			session.setAttribute("idUsuario", usuario.getIdUsuario());
			session.setAttribute("logNome", usuario.getNome());
			System.out.println("logou" + usuario);
			response.sendRedirect("Consentimento.jsp");
			
		}
	}
}
