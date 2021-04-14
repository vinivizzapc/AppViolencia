package dao;

import Model.AudioVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AudioDAO {

    public ArrayList<AudioVO> ListarAudios(int idUsuario) {
        ArrayList<AudioVO> list = new ArrayList<AudioVO>();
        String sql = "SELECT * FROM gravacoes WHERE idUsuario = ?;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = ConnectionFactory.obtemConexao().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                AudioVO vo = new AudioVO();
                vo.setId(rs.getInt(1));
                vo.setBase64(rs.getString(2));
                vo.setNomeAudio(rs.getString(3));
                vo.setData(rs.getString(5));
	            list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
            }
        }
        return list;
    }

    public void InserirAudio(AudioVO vo) {
        String sql = "INSERT INTO gravacoes (id, audio, nomeAudio, idUsuario, data) VALUES(NULL, ?, ?, ?, NOW());";
        PreparedStatement ps = null;
        try {
            ps = ConnectionFactory.obtemConexao().prepareStatement(sql);
            ps.setBytes(1, vo.getArchivoaudioby());
            ps.setString(2, vo.getNomeAudio());
            ps.setInt(3, vo.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }

    public void AtualizarAudio(AudioVO vo) {
        String sql = "UPDATE gravacoes SET nomeAudio = ?, audio = ? WHERE idUsuario = ?;";
        PreparedStatement ps = null;
        try {
            ps = ConnectionFactory.obtemConexao().prepareStatement(sql);
            ps.setString(1, vo.getNomeAudio());
            ps.setBytes(2, vo.getArchivoaudioby());
            ps.setInt(3, vo.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }

    public void AtualizarNomeAudio(AudioVO vo) {
        String sql = "UPDATE gravacoes SET nomeAudio = ? WHERE idUsuario = ?;";
        PreparedStatement ps = null;
        try {
            ps = ConnectionFactory.obtemConexao().prepareStatement(sql);
            ps.setString(1, vo.getNomeAudio());
            ps.setInt(2, vo.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }

    public void ExcluirAudio(AudioVO vo) {
        String sql = "DELETE FROM gravacoes WHERE id = ? AND idUsuario = ?;";
        PreparedStatement ps = null;
        try {
            ps = ConnectionFactory.obtemConexao().prepareStatement(sql);
            ps.setInt(1, vo.getId());
            ps.setInt(2, vo.getIdUsuario());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
            }
        }
    }

    public AudioVO GetAudioById(int idUsuario, int id) {
        AudioVO d = new AudioVO();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM gravacoes WHERE idUsuario = ? AND id = ?;";
        try {
            preparedStatement = ConnectionFactory.obtemConexao().prepareStatement(query);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //d.setCodigoaudio(resultSet.getInt(1));
                //d.setNombreaudio(resultSet.getString(2));
                d.setArchivoaudioby(resultSet.getBytes(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception ex) {
            }
        }
        return d;
    }

    public AudioVO GetAudioByIdIn(int idUsuario, int id) {
        AudioVO d = new AudioVO();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "SELECT * FROM gravacoes WHERE idUsuario = ? AND id = ?;";
        try {
            preparedStatement = ConnectionFactory.obtemConexao().prepareStatement(query);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //d.setCodigoaudio(resultSet.getInt(1));
                //d.setNombreaudio(resultSet.getString(2));
                d.setArchivoaudioin(resultSet.getBinaryStream(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception ex) {
            }
        }
        return d;
    }
}
