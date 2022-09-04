package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Pesquisa;

public class PesquisaDao {
	
	private static PesquisaDao instance;
	private List<Pesquisa> listaPesquisa = new ArrayList<>();
	
	/*
	 * Singleton
	 */
	public static PesquisaDao getInstance() {
		if (instance == null) {
			instance = new PesquisaDao();
		}
		return instance;
	}
	
	public void registrarPesquisa(Pesquisa pesquisa) {
		listaPesquisa.add(pesquisa);
	}
	
	public List<Pesquisa> listar() {
		return listaPesquisa;
	}
}
