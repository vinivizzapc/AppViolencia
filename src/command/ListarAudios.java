package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AudioVO;
import Service.AudioService;

public class ListarAudios implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idUsuario = (Integer)request.getSession().getAttribute("idUsuario");
		
		AudioService as = new AudioService();
		ArrayList<AudioVO> lista = null;
		
		lista = as.ListarAudios(idUsuario);

		request.setAttribute("lista", lista);	
			
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("MeusAudios.jsp");
		dispatcher.forward(request, response);

	}

}
