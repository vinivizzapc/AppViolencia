package Service;

import Model.Usuario;

import java.util.ArrayList;

import dao.UsuarioDAO;

public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();

	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}

	public void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public void excluir(int idUsuario) {
		dao.excluir(idUsuario);
	}

	public Usuario carregar(int idUsuario) {
		return dao.carregar(idUsuario);
	}
	
	public Usuario carregarEmail(String email) {
		return dao.carregarEmail(email);
	}

	public ArrayList<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}

	public ArrayList<Usuario> listarUsuarios(String chave) {
		return dao.listarUsuarios(chave);
	}
	
	public boolean validar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(usuario);
	}
}
