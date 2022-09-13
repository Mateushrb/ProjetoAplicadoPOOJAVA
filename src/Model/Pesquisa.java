package Model;

import java.time.LocalDate;

public class Pesquisa {
	private int idPesquisa;
	private String institutoPesquisa;
	private LocalDate dateTime;
	private int mediaIdade;
	
	public Pesquisa(int idPesquisa, String institutoPesquisa, LocalDate dateTime) {
		this.idPesquisa = idPesquisa;
		this.institutoPesquisa = institutoPesquisa;
		this.dateTime = dateTime;
	}
	
	public Pesquisa() {}

	public int getIdPesquisa() {
		return idPesquisa;
	}
	public void setIdPesquisa(int idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public String getInstitutoPesquisa() {
		return institutoPesquisa;
	}
	public void setInstitutoPesquisa(String institutoPesquisa) {
		this.institutoPesquisa = institutoPesquisa;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}
	public void setDatetime(LocalDate datetime) {
		this.dateTime = datetime;
	}
	
	public int getMediaIdade() {
		return mediaIdade;
	}
	public void setMediaIdade(int mediaIdade) {
		this.mediaIdade = mediaIdade;
	}

	@Override
	public String toString() {
		return "Pesquisa do " + institutoPesquisa + " feita em " + dateTime;
	}
}
