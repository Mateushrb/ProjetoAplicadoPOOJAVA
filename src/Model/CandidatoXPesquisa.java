package Model;

public class CandidatoXPesquisa {
	private int votos;
	private Pesquisa pesquisa;
	private Candidato candidato;
	
	public CandidatoXPesquisa(int votos, Pesquisa pesquisa, Candidato candidato) {
		this.votos = votos;
		this.pesquisa = pesquisa;
		this.candidato = candidato;
	}
	
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	
	public Pesquisa getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	public String toString() {
		return "Pesquisa " + pesquisa.getIdPesquisa() + " do Instituto " + pesquisa.getInstitutoPesquisa() + ", concluiu que o candidato " + candidato.getNome() + ", do partido " + candidato.getPartido().getNomePartido() + ", fez " + votos + " votos.";
	}
	
}
