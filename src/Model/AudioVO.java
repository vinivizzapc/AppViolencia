package Model;

import java.io.InputStream;

public class AudioVO {

    int id;
    String nomeAudio;
    int idUsuario;
    private byte[] archivoaudioby;
    private InputStream archivoaudioin;
    private String base64;
    String data;

    public AudioVO() {
    	
    }
    
    public int getId() {
        return id;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNomeAudio() {
        return nomeAudio;
    }
    
    public String getData() {
        return data;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void setNomeAudio(String nomeAudio) {
        this.nomeAudio = nomeAudio;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public InputStream getArchivoaudioin() {
        return archivoaudioin;
    }

    public void setArchivoaudioin(InputStream archivoaudio2) {
        this.archivoaudioin = archivoaudio2;
    }

    public byte[] getArchivoaudioby() {
        return archivoaudioby;
    }

    public void setArchivoaudioby(byte[] archivoaudio) {
        this.archivoaudioby = archivoaudio;
    }
    
    public String getBase64() {
		return base64;
	}
    
	public void setBase64(String archivoaudioby) {
		this.base64 = archivoaudioby;
	}
}
