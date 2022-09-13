import java.time.LocalDate;

import Controller.CandidatoController;
import Controller.PartidoController;
import Controller.PesquisaController;
import Model.Candidato;
import Model.CandidatoXPesquisa;
import Model.Partido;
import Model.Pesquisa;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partido Esquerda = new Partido(13, "PT", "Partido dos Trabalhadores");
		Partido Direita = new Partido(45, "PL", "Partido Liberal");
		
		Candidato Lula = new Candidato(Esquerda, 13, "Não", "Luiz Inácio");
		Candidato Bolsonaro = new Candidato(Direita, 17, "Sim", "Jair Bolsonaro");
		
		LocalDate dataAgora = LocalDate.now();
		
		Pesquisa pesquisa1IBGE = new Pesquisa(1503, "IBGE", dataAgora);
		
		
		CandidatoXPesquisa cand1 = new CandidatoXPesquisa(71826, pesquisa1IBGE, Lula);
		CandidatoXPesquisa cand2 = new CandidatoXPesquisa(74125, pesquisa1IBGE, Bolsonaro);
		
		System.out.println(cand1.toString());
		System.out.println(cand2.toString());
		
		PartidoController partidoController = new PartidoController();
		CandidatoController candidatoController = new CandidatoController();
		PesquisaController pesquisaController = new PesquisaController();
		try {
			partidoController.salvar(Esquerda);
			partidoController.salvar(Direita);
			candidatoController.salvar(Lula);
			candidatoController.salvar(Bolsonaro);
			pesquisaController.registrarPesquisa(pesquisa1IBGE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Partido p : partidoController.listar()) {
			System.out.println(p.toString());
		}
		for (Candidato c : candidatoController.listar()) {
			System.out.println(c.toString());
		}
		for (Pesquisa p : pesquisaController.listar()) {
			System.out.println(p.toString());
		}
		
	}

}
