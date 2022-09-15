package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Candidato;

public class CandidatoTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME = 0;
	private static final int COL_PARTIDO = 1;
	
	private List<Candidato> valores;
	
	public CandidatoTableModel(List<Candidato> valores) {
		this.valores = new ArrayList<Candidato>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
	}
	
	public int getColumnCount() {
		return 2;
	}
	
	public String getColumnName(int column) {
		if (column == COL_NOME) return "Nome do Candidato";
		if (column == COL_PARTIDO) return "Nome do Partido";
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Candidato candidato = valores.get(row);
		if (column == COL_NOME) 
			return candidato.getNome();
		else
			if (column == COL_PARTIDO) 
				return candidato.getPartido().getNomePartido();
		return "";
	}
	
	public void setValueAt(Candidato aValue, int rowIndex, int columnIndex) {
		Candidato candidato = valores.get(rowIndex);
		if (columnIndex == COL_NOME)
			candidato.setNome(aValue.getNome());
		else
			if (columnIndex == COL_PARTIDO)
				candidato.setPartido(aValue.getPartido());
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	public Candidato get(int row) {
		return valores.get(row);
	}
}
