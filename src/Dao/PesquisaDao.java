package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Pesquisa;
import util.ConnectionUtil;

public class PesquisaDao {
	
	private static PesquisaDao instance;
	private List<Pesquisa> listaPesquisa = new ArrayList<>();
	private Connection con = ConnectionUtil.getConnection();
	
	/*
	 * Singleton
	 */
	public static PesquisaDao getInstance() {
		if (instance == null) {
			instance = new PesquisaDao();
		}
		return instance;
	}
	
	public void registrarPesquisa(Pesquisa pesquisa) {
		
		try {
			String sql = "INSERT INTO pesquisa (idpesquisa, institutopesquisa, datapesquisa, mediaidade, uf_iduf, tipopesquisa_idtipopesquisa, tipo_idtipo, formato_idformato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, pesquisa.getIdPesquisa());
			pstmt.setString(2, pesquisa.getInstitutoPesquisa());
			pstmt.setDate(3, java.sql.Date.valueOf(pesquisa.getDateTime()));
			pstmt.setInt(4,  pesquisa.getMediaIdade());
			pstmt.setInt(5, pesquisa.getUf());
			pstmt.setInt(6, pesquisa.getTipopesquisa());
			pstmt.setInt(7, pesquisa.getTipo());
			pstmt.setInt(8, pesquisa.getFormato());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Pesquisa> listar() {
		return listaPesquisa;
	}
}
