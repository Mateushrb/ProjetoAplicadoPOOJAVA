package Controller;

import java.util.List;

import Dao.PesquisaDao;
import Model.Pesquisa;

public class PesquisaController {
	
	public void registrarPesquisa(Pesquisa pesquisa) throws Exception {
		if (pesquisa.getInstitutoPesquisa() == null) {
			throw new Exception("Nome inválido");
		}
		if (pesquisa.getDateTime() == null) {
			throw new Exception("Data inválida");
		}
		PesquisaDao.getInstance().registrarPesquisa(pesquisa);
	}
	
	public List<Pesquisa> listar() {
		return PesquisaDao.getInstance().listar();
	}
	
}
