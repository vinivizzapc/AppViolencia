package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Usuario;

public class UsuarioDAO {
	public int criar(Usuario usuario) {
		String sqlInsert = "INSERT INTO Usuario(Nome, Email, Senha) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}

	public void atualizar(Usuario usuario) {
        String sqlUpdate = "UPDATE usuario SET Nome=?, Email=?, Senha=? WHERE idUsuario=?";
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setInt(4, usuario.getIdUsuario());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void excluir(int idUsuario) {
		String sqlDelete = "DELETE FROM usuario WHERE idUsuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, idUsuario);
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		String sqlSelect = "SELECT idUsuario, Nome, Email, Senha FROM Usuario WHERE Usuario.idUsuario = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getIdUsuario());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
				} else {
					usuario.setIdUsuario(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
	
	public Usuario carregarEmail(String email) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		String sqlSelect = "SELECT idUsuario, Nome, Email, Senha FROM usuario WHERE Usuario.email = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getEmail());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
				} else {
					usuario.setIdUsuario(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public ArrayList<Usuario> listarUsuarios() {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT idUsuario, Nome, Email FROM usuario";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Usuario> listarUsuarios(String chave) {
		Usuario usuario;
		ArrayList<Usuario> lista = new ArrayList<>();
		String sqlSelect = "SELECT idUsuario, Nome, Email FROM usuario where upper(nome)like ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					usuario = new Usuario();
					usuario.setIdUsuario(rs.getInt("idUsuario"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public boolean validar(Usuario usuario) {
		String sqlSelect = "SELECT email, senha from usuario where email = ? and senha = ?";
		try {
			Connection conn = ConnectionFactory.obtemConexao();
			try(PreparedStatement stm = conn.prepareStatement(sqlSelect);){
				stm.setString(1, usuario.getEmail());
				stm.setString(2, usuario.getSenha());
				try(ResultSet rs = stm.executeQuery()){
					if(rs.next()) {
						return true;
					}
					else {
						return false;
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}catch(SQLException e1) {
				System.out.println(e1.getStackTrace());
			}
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
		return false;
	}
}