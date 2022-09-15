import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Controller.CandidatoController;
import Controller.PartidoController;
import Controller.PesquisaController;
import Model.Candidato;
import Model.CandidatoXPesquisa;
import Model.Partido;
import Model.Pesquisa;
import util.ConnectionUtil;

public class Principal {
	private static Connection con = ConnectionUtil.getConnection();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partido Esquerda = new Partido(13, "PT", "Partido dos Trabalhadores");
		Partido Direita = new Partido(45, "PL", "Partido Liberal");
		
		Candidato Lula = new Candidato(Esquerda, 13, "Não", "Luiz Inácio");
		Candidato Bolsonaro = new Candidato(Direita, 17, "Sim", "Jair Bolsonaro");
		
		LocalDate dataAgora = LocalDate.now();
		System.out.println(dataAgora);
		Pesquisa pesquisa1IBGE = new Pesquisa(1503, "IBGE", dataAgora, 0, 1, 1, 1, 1);
		
		
		CandidatoXPesquisa cand1 = new CandidatoXPesquisa(71826, pesquisa1IBGE, Lula);
		CandidatoXPesquisa cand2 = new CandidatoXPesquisa(74125, pesquisa1IBGE, Bolsonaro);
		
		//System.out.println(cand1.toString());
		//System.out.println(cand2.toString());
		
		PartidoController partidoController = new PartidoController();
		CandidatoController candidatoController = new CandidatoController();
		PesquisaController pesquisaController = new PesquisaController();
		/*
		try {
			partidoController.salvar(Esquerda);
			partidoController.salvar(Direita);
			candidatoController.salvar(Lula);
			candidatoController.salvar(Bolsonaro);
			pesquisaController.registrarPesquisa(pesquisa1IBGE);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
//		for (Partido p : partidoController.listar()) {
//			System.out.println(p.toString());
//		}
//		for (Candidato c : candidatoController.listar()) {
//			System.out.println(c.toString());
//		}
//		for (Pesquisa p : pesquisaController.listar()) {
//			System.out.println(p.toString());
//		}
		
		List<Candidato> listaCandidatos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM candidato";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Partido p1 = new Partido();
				p1.setIdPartido(rs.getInt("partido_idpartido"));
				
				Candidato c1 = new Candidato();
				c1.setIdCandidato(rs.getInt("idcandidato"));
				c1.setFichaLimpa(rs.getString("fichalimpa"));
				c1.setNome(rs.getString("nome"));
				c1.setPartido(p1);
				
				listaCandidatos.add(c1);
				
			}
			
			String sql2 = "SELECT * FROM partido";
			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				for (Candidato i : listaCandidatos) {
					if (i.getPartido().getIdPartido() == rs2.getInt("idpartido")) {
						i.getPartido().setNomePartido(rs2.getString("nomepartido"));
						i.getPartido().setSigla(rs2.getString("sigla"));
						
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Candidato i : listaCandidatos) {
			System.out.println(i.toString());
		}
		
	}

}
