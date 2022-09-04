package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Partido;

public class PartidoDao {
	
	private static PartidoDao instance;
	private List<Partido> listaPartido = new ArrayList<>();
	
	/*
	 * Singleton
	 */
	
	public static PartidoDao getInstance() {
		if (instance == null) {
			instance = new PartidoDao();
		}
		return instance;
	}
	
	public void salvar(Partido partido) {
		listaPartido.add(partido);
	}
	
	public void atualizar(Partido partido) {
		listaPartido.set(partido.getIdPartido(), partido);
	}
	
	public void excluir(int idPartido) {
		listaPartido.remove(idPartido);
	}
	
	public List<Partido> listar() {
		return listaPartido;
	}
}
