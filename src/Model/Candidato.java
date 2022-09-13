package Model;

public class Candidato {
	private int idCandidato;
	private String fichaLimpa;
	private String nome;
	private Partido partido;
	
	public Candidato(Partido partido, int idCandidato, String fichaLimpa, String nome) {
		this.partido = partido;
		this.idCandidato = idCandidato;
		this.fichaLimpa = fichaLimpa;
		this.nome = nome;
	}
	
	public Candidato() {}
	
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	public String getFichaLimpa() {
		return fichaLimpa;
	}
	public void setFichaLimpa(String fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido string) {
		this.partido = string;
	}
	
	@Override
	public String toString() {
		return nome + " - " + partido.getSigla();
	}

	public void setPartido(String string) {
		// TODO Auto-generated method stub
		
	}
}
