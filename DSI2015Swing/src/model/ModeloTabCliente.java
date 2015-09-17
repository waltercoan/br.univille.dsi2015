package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import dao.Cliente;

public class ModeloTabCliente extends AbstractTableModel{

	private List<Cliente> colDados = new ArrayList<Cliente>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String[] titulos = {"Código", "Nome", "Data Nascimento"};
	
	
	@Override
	public String getColumnName(int column) {
		return titulos[column];
	}

	public void atualiza(List<Cliente> colDados){
		this.colDados = colDados;
		fireTableDataChanged();
	}
	
	@Override
	public int getRowCount() {
		return colDados.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Object valor = null;
		Cliente umCliente = colDados.get(linha);
		switch (coluna) {
			case 0:
				valor = umCliente.getCodigo();
			break;
			case 1:
				valor = umCliente.getNome();
			break;
			case 2:
				valor = sdf.format(umCliente.getDataNascimento());
			break;
		default:
			break;
		}
		return valor;
	}
}