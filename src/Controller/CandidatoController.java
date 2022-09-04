package Controller;

import java.util.List;

import Dao.CandidatoDao;
import Model.Candidato;

public class CandidatoController {
	
	public void salvar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3) {
			throw new Exception("Nome inválido");
		}
		CandidatoDao.getInstance().salvar(candidato);
	}
	
	public void atualizar(Candidato candidato) throws Exception {
		if (candidato.getNome() == null || candidato.getNome().length() < 3) {
			throw new Exception("Nome inválido");
		}
		CandidatoDao.getInstance().atualizar(candidato);
	}
	
	public void excluir(int idCandidato) throws Exception {
		if (idCandidato == 0) {
			throw new Exception("Nenhum candidato selecionado");
		}
		CandidatoDao.getInstance().excluir(idCandidato);
	}
	
	public List<Candidato> listar() {
		return CandidatoDao.getInstance().listar();
	}
	
}
