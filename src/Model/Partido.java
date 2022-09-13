package Model;

public class Partido {
	private int idPartido;
	private String sigla;
	private String nomePartido;
	
	public Partido(int idPartido, String sigla, String nomePartido) {
		this.idPartido = idPartido;
		this.sigla = sigla;
		this.nomePartido = nomePartido;
	}
	
	public Partido() {}

	public int getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNomePartido() {
		return nomePartido;
	}
	public void setNomePartido(String nomePartido) {
		this.nomePartido = nomePartido;
	}
	
	@Override
	public String toString() {
		return sigla + ": " + nomePartido;
	}
	
}
