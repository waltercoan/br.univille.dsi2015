package form;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.Produto;

public class ProdutoTableModel extends AbstractTableModel{
	private List<Produto> colProd = new ArrayList<Produto>();
	private String titles[] = {"Código", "Descrição", "Valor"};
 	
	public String getColumnName(int column) {
		return titles[column];
	}
	public ProdutoTableModel(List<Produto> colProd) {
		this.colProd = colProd;
		System.out.println(colProd.size());
		fireTableDataChanged();
	}
	
	public int getRowCount() {
		return colProd.size();
	}

	public int getColumnCount() {
		return 3;
	}

	public Object getValueAt(int linha, int col) {
		Object value = null;
		switch (col) {
			case 0:
				value = colProd.get(linha).getCodigo();
			break;
			case 1:
				value = colProd.get(linha).getDescricao();
			break;
			case 2:
				value = colProd.get(linha).getValor();
			break;
		default:
			break;
		}
		return value;
	}

}







