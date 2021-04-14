package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Usuario;
import Service.UsuarioService;

public class FazerLoginUsu implements Command{

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
						
		UsuarioService cs = new UsuarioService();
		usuario.setEmail(pEmail);
		
		if(cs.validar(usuario)) {
			HttpSession session = request.getSession();
			usuario = cs.carregarEmail(usuario.getEmail());
			session.setAttribute("logado", usuario);
			session.setAttribute("idUsuario", usuario.getIdUsuario());
			session.setAttribute("logNome", usuario.getNome());
			System.out.println("logou" + usuario);
			response.sendRedirect("index.jsp");
			
		}
		else {
			System.out.println("Não logou" + usuario);
			request.setAttribute("erro", "Usuário e/ou senha inválidos");
			request.getRequestDispatcher("LoginUsu.jsp").forward(request, response);
		return;
		}
	}
}
