package form;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ModeloTabCliente;
import util.ServerConnection;

public class FrmCliente extends JFrame{
	private JScrollPane jpnTabela;
	private JPanel jpnBotoes;
	private JTable tabela;
	private JButton btbNovo, btbAlterar, btbRemover;
	private ModeloTabCliente modelTab;
	
	public FrmCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setTitle("Manter Clientes");
		criaPainelTabela();
		criaPainelBotoes();
		
		setSize(500,300);
		setVisible(true);
	}
	private void criaPainelTabela(){
		modelTab = new ModeloTabCliente();
		atualizaTabela();
		tabela = new JTable(modelTab);
		jpnTabela = new JScrollPane(tabela);
		add(jpnTabela,BorderLayout.CENTER);
	}
	public void atualizaTabela(){
		modelTab.atualiza(ServerConnection.getInstance().getClienteBeanRemote().getAllClientes());
	}
	private void criaPainelBotoes(){
		btbNovo = new JButton("Novo");
		btbAlterar = new JButton("Alterar");
		btbRemover = new JButton("Remover");
		jpnBotoes = new JPanel();
		jpnBotoes.add(btbNovo);
		jpnBotoes.add(btbAlterar);
		jpnBotoes.add(btbRemover);
		add(jpnBotoes,BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		new FrmCliente();
	}
}