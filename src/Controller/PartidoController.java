package Controller;

import java.util.List;

import Dao.PartidoDao;
import Model.Partido;

public class PartidoController {
	
	public void salvar(Partido partido) throws Exception {
		if (partido.getNomePartido() == null) {
			throw new Exception("Nome inválido");
		}
		PartidoDao.getInstance().salvar(partido);
	}
	
	public void atualizar(Partido partido) throws Exception {
		if (partido.getNomePartido() == null) {
			throw new Exception("Nome inválido");
		}
		PartidoDao.getInstance().atualizar(partido);
	}
	
	public void excluir(int idPartido) throws Exception {
		if (idPartido == 0) {
			throw new Exception("Nenhum partido selecionado");
		}
		PartidoDao.getInstance().excluir(idPartido);
	}
	
	public List<Partido> listar() {
		return PartidoDao.getInstance().listar();
	}
	
}
