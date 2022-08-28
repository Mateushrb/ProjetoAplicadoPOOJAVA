package Model;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partido Esquerda = new Partido(13, "PT", "Partido dos Trabalhadores");
		Partido Direita = new Partido(45, "PSDB", "Partido da Social Democracia Brasileira");
		
		Candidato Lula = new Candidato(Esquerda, 13, "Não", "Luiz Inácio");
		Candidato Bolsonaro = new Candidato(Direita, 17, "Sim", "Jair Bolsonaro");
		
		LocalDate dataAgora = LocalDate.now();
		
		Pesquisa pesquisa1IBGE = new Pesquisa(1503, "IBGE", dataAgora);
		
		
		CandidatoXPesquisa cand1 = new CandidatoXPesquisa(71826, pesquisa1IBGE, Lula);
		CandidatoXPesquisa cand2 = new CandidatoXPesquisa(74125, pesquisa1IBGE, Bolsonaro);
		
		System.out.println(cand1.toString());
		System.out.println(cand2.toString());
		
	}

}
