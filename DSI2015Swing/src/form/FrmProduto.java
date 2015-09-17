package form;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ServerConnection;
import model.ProdutoTableModel;

public class FrmProduto extends JFrame{
	private JScrollPane jpnCentro;
	private JPanel jpnBotoes;
	private JTable tabela;
	private ProdutoTableModel model;
	
	public FrmProduto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,300);
		criaTabela();
		setVisible(true);
	}
	private void criaTabela(){
	
		model = new ProdutoTableModel(ServerConnection.getInstance().getProdutoBeanRemote().getTodosProdutos());
		tabela = new JTable(model);
		jpnCentro = new JScrollPane(tabela);
		add(jpnCentro,BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		new FrmProduto();
	}

}
