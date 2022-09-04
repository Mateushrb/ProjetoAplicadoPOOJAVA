package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Candidato;

public class CandidatoDao {
	
	private static CandidatoDao instance;
	private List<Candidato> listaCandidato = new ArrayList<>();
	
	/*
	 * Singleton
	 */
	
	public static CandidatoDao getInstance() {
		if (instance == null) {
			instance = new CandidatoDao();
		}
		return instance;
	}
	
	public void salvar(Candidato candidato) {
		listaCandidato.add(candidato);
	}
	
	public void atualizar(Candidato candidato) {
		listaCandidato.set(candidato.getIdCandidato(), candidato);
	}
	
	public void excluir(int idCandidato) {
		listaCandidato.remove(idCandidato);
	}
	
	public List<Candidato> listar() {
		return listaCandidato;
	}
}
