package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Partido;
import util.ConnectionUtil;

public class PartidoDao {
	
	private static PartidoDao instance;
	private List<Partido> listaPartido = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
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
		try {
			String sql = "INSERT INTO partido (sigla, nomepartido) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, partido.getSigla());
			pstmt.setString(2, partido.getNomePartido());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Partido partido) {
		try {
			String sql = "UPDATE partido SET sigla = ?, nomepartido = ? WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, partido.getSigla());
			pstmt.setString(2, partido.getNomePartido());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int idPartido) {
		try {
			String sql = "DELETE FROM partido WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idPartido);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Partido> listar() {
		List<Partido> listaPartidos = new ArrayList<>();
		try {
			String sql = "SELECT * FROM partido";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Partido p1 = new Partido();
				p1.setIdPartido(rs.getInt("idpartido"));
				p1.setSigla(rs.getString("sigla"));
				p1.setNomePartido(rs.getString("nomepartido"));
				listaPartidos.add(p1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaPartido;
	}
}


