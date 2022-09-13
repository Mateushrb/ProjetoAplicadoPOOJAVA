package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CandidatoXPesquisa;
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
		System.out.println("O metodo registrar pesquisa ainda não foi implementado");
		/*
		try {
			String sql = "INSERT INTO pesquisa (institutopesquisa, datapesquisa, mediaidade) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, pesquisa.getInstitutoPesquisa());
			pstmt.setDate(2, java.sql.Date.valueOf(pesquisa.getDateTime()));
			pstmt.setInt(3,  pesquisa.getMediaIdade());
			int key = pstmt.executeUpdate();
			if (key > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				int idPesquisa = rs.getInt(1);
				String sqlCandidatoXPesquisa = "INSERT INTO candidatoxpesquisa (votos) VALUES (?)";
				PreparedStatement pstmtCandidatoXPesquisa = con.prepareStatement(sqlCandidatoXPesquisa);
				// Não faz sentido fazer o for pois não temos uma lista
				for (CandidatoXPesquisa item : pesquisa.g) {
					pstmtItemVenda.setInt(1, item.getQtde());
					pstmtItemVenda.setDouble(2,  item.getValorTotal());
					pstmtItemVenda.setInt(3,  item.getProduto().getId());
					pstmtItemVenda.setInt(4, idVenda);
					pstmtItemVenda.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public List<Pesquisa> listar() {
		return listaPesquisa;
	}
}
