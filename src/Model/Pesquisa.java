package Model;

import java.time.LocalDate;

public class Pesquisa {
	private int idPesquisa;
	private String institutoPesquisa;
	private LocalDate datetime;
	
	public Pesquisa(int idPesquisa, String institutoPesquisa, LocalDate datetime) {
		this.idPesquisa = idPesquisa;
		this.institutoPesquisa = institutoPesquisa;
		this.datetime = datetime;
	}

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

	public LocalDate getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDate datetime) {
		this.datetime = datetime;
	}
	
	
}
