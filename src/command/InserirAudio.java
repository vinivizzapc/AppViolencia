package command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AudioVO;
import Service.AudioService;

public class InserirAudio implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeAudio = request.getParameter("nomeAudio");
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		
		InputStream is = request.getPart("Arquivo").getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		
		int nRead;
		byte[] data = new byte[16384];

		while ((nRead = is.read(data, 0, data.length)) != -1) {
			buffer.write(data, 0, nRead);
		}

		byte[] arquivo = buffer.toByteArray();
		
		AudioVO audio = new AudioVO();
		audio.setIdUsuario(idUsuario);
		audio.setNomeAudio(nomeAudio);
		audio.setArchivoaudioby(arquivo);

		AudioService as = new AudioService();
		as.InserirAudio(audio);

		response.sendRedirect("controller.do?command=ListarAudios&idUsuario=" + audio.getIdUsuario());
	}
}
