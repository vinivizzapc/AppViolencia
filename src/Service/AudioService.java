package Service;

import java.util.ArrayList;

import Model.AudioVO;
import dao.AudioDAO;

public class AudioService {
	AudioDAO dao = new AudioDAO();

	public void InserirAudio(AudioVO audio) {
		dao.InserirAudio(audio);
	}

	public void AtualizarAudio(AudioVO audio) {
		dao.AtualizarAudio(audio);
	}
	
	public void AtualizarNomeAudio(AudioVO audio) {
		dao.AtualizarNomeAudio(audio);
	}

	public void ExcluirAudio(AudioVO audio) {
		dao.ExcluirAudio(audio);
	}

	public AudioVO GetAudioById(int idCodigo, int id) {
		return dao.GetAudioById(idCodigo, id);
	}
	
	public AudioVO GetAudioByIdIn(int idCodigo, int id) {
		return dao.GetAudioByIdIn(idCodigo, id);
	}

	public ArrayList<AudioVO> ListarAudios(int idUsuario) {
		return dao.ListarAudios(idUsuario);
	}
}
