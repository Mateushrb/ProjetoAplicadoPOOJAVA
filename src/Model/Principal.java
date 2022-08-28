package Model;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partido Esquerda = new Partido(13, "PT", "Partido dos Trabalhadores");
		Partido Direita = new Partido(45, "PSDB", "Partido da social democracia brasileira");
		
		Candidato Lula = new Candidato(Esquerda, 13, "Não", "Luiz Inácio");
		Candidato Bolsonaro = new Candidato(Direita, 17, "Sim", "Jair Bolsonaro");
		System.out.println(Lula.getPartido().getSigla());
		System.out.println(Bolsonaro.getPartido().getSigla());
		
	}

}
