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
		if (column == COL_NOME) return "Candidato";
		if (column == COL_PARTIDO) return "Partido";
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Candidato candidato = valores.get(row);
		if (column == COL_NOME)
			return candidato.getNome();
			else
				if (column == COL_PARTIDO)
					return candidato.getPartido();
		return "";
	}
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Candidato candidato = valores.get(columnIndex);
		if (columnIndex == COL_PARTIDO)
			candidato.setPartido(aValue.toString());
		else
			if (columnIndex == COL_PARTIDO)
				candidato.setPartido(aValue.toString());
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
