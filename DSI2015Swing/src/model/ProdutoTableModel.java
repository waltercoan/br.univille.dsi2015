package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.Produto;

public class ProdutoTableModel extends AbstractTableModel{

	
	private List<Produto> colProdutos = new ArrayList<Produto>();
	
	public ProdutoTableModel(List<Produto> colProdutos) {
		this.colProdutos = colProdutos;
		fireTableDataChanged();
	}
	
	public void atualiza(List<Produto> colProdutos){
		this.colProdutos = colProdutos;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return colProdutos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int linha, int col) {
		Object value = null;
		switch (col) {
			case 0:
				value = colProdutos.get(linha).getCodigo();
			break;
			case 1:
				value = colProdutos.get(linha).getDescricao();
			break;
			case 2:
				value = colProdutos.get(linha).getValor();
			break;
		}
		return value;
	}

}
