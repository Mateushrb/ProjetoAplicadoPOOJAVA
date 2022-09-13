package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Candidato;
import Model.Partido;
import util.ConnectionUtil;

public class CandidatoDao {
	
	private static CandidatoDao instance;
	//private List<Candidato> listaCandidato = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
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
		try {
			String sql = "INSERT INTO cliente (fichalimpa, nome) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, candidato.getFichaLimpa());
			pstmt.setString(2, candidato.getNome());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Candidato candidato) {
		try {
			String sql = "UPDATE candidato SET fichalimpa = ?, nome = ? WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, candidato.getFichaLimpa());
			pstmt.setString(2, candidato.getNome());
			pstmt.setInt(3, candidato.getIdCandidato());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idCandidato) {
		try {
			String sql = "DELETE FROM candidato WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idCandidato);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Candidato> listar() {
		List<Candidato> listaCandidatos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM candidato";
			String sql2 = "SELECT * FROM partido";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			while (rs.next()) {
				Partido p1 = new Partido();
				p1.setIdPartido(rs2.getInt("idpartido"));
				p1.setSigla(rs2.getString("sigla"));
				p1.setNomePartido(rs2.getString("nomepartido"));
				
				Candidato c1 = new Candidato();
				c1.setIdCandidato(rs.getInt("idcandidato"));
				c1.setFichaLimpa(rs.getString("fichalimpa"));
				c1.setNome(rs.getString("nome"));
				c1.setPartido(p1);
				
				listaCandidatos.add(c1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCandidatos;
	}
}
