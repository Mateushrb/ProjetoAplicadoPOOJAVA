package Model;

import java.time.LocalDate;

public class Pesquisa {
	private int idPesquisa;
	private String institutoPesquisa;
	private LocalDate dateTime;
	private int mediaIdade;
	private int uf;
	private int tipopesquisa;
	private int tipo;
	private int formato;
	
	public Pesquisa(int idPesquisa, String institutoPesquisa, LocalDate dateTime, int mediaIdade, int uf, int tipopesquisa, int tipo, int formato) {
		this.idPesquisa = idPesquisa;
		this.institutoPesquisa = institutoPesquisa;
		this.dateTime = dateTime;
		this.mediaIdade = mediaIdade;
		this.uf = uf;
		this.tipopesquisa = tipopesquisa;
		this.tipo = tipo;
		this.formato = formato;
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
	public void setDatetime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}
	
	public int getMediaIdade() {
		return mediaIdade;
	}
	public void setMediaIdade(int mediaIdade) {
		this.mediaIdade = mediaIdade;
	}

	public int getUf() {
		return uf;
	}
	public void setUf(int uf) {
		this.uf = uf;
	}

	public int getTipopesquisa() {
		return tipopesquisa;
	}
	public void setTipopesquisa(int tipopesquisa) {
		this.tipopesquisa = tipopesquisa;
	}

	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getFormato() {
		return formato;
	}
	public void setFormato(int formato) {
		this.formato = formato;
	}

	@Override
	public String toString() {
		return "Pesquisa do " + institutoPesquisa + " feita em " + dateTime;
	}
}
