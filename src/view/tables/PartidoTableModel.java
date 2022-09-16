package view.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Partido;

public class PartidoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_PARTIDO = 0;
	private static final int COL_SIGLA = 1;
	
	private List<Partido> valores;
	
	public PartidoTableModel(List<Partido> valores) {
		this.valores = new ArrayList<Partido>(valores);
	}
	
	public int getRowCount() {
		return valores.size();
	}
	
	public int getColumnCount() {
		return 2;
	}
	
	public String getColumnName(int column) {
		if (column == COL_PARTIDO) return "Nome do Partido";
		if (column == COL_SIGLA) return "Sigla do Partido";
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Partido partido = valores.get(row);
		if (column == COL_PARTIDO) 
			return partido.getNomePartido();
		else
			if (column == COL_SIGLA) 
				return partido.getSigla();
		return "";
	}
	
	public void setValueAt(Partido aValue, int rowIndex, int columnIndex) {
		Partido partido = valores.get(rowIndex);
		if (columnIndex == COL_PARTIDO)
			partido.setNomePartido(aValue.getNomePartido());
		else
			if (columnIndex == COL_SIGLA)
				partido.setSigla(aValue.getSigla());
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	public Partido get(int row) {
		return valores.get(row);
	}
}
