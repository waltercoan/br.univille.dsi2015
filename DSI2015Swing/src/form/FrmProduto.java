package form;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ServerConnection;

public class FrmProduto extends JFrame{
	private JScrollPane jpnCentro;
	private JPanel jpnBotoes;
	private JTable tblProduto;
	private JButton btnInc, btnAlt, btnExc, btnSair;
	private ProdutoTableModel model;
	
	public FrmProduto() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		criaJpnCentro(); // não esqueça da minha caloi
		
		setSize(500,400);
		setVisible(true);
	}
	private void criaJpnCentro(){
		model = new ProdutoTableModel(ServerConnection.getInstance().getProdutoBeanRemote().getTodosProdutos());
		tblProduto = new JTable(model);
		jpnCentro = new JScrollPane(tblProduto);
		add(jpnCentro,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		new FrmProduto();
	}
}
