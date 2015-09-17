package form;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.text.MaskFormatter;

import ui.util.layouts.ParagraphLayout;
import dao.Cliente;

public class FrmClienteDetail extends JDialog {
	private JToolBar jpnBotoes;
	private JPanel jpnCentro;
	private JButton btbOK, btbCancelar;
	private JLabel lblCodigo, lblNome, lblNascimento, lblSexo;
	private JTextField txtCodigo, txtNome;
	private JRadioButton jrbMascButton, jrbFemButton;
	private ButtonGroup group = new ButtonGroup();
	private JFormattedTextField txtNascimento;
	private Cliente model;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public void updateForm(){
		txtCodigo.setText(model.getCodigo());
		txtNome.setText(model.getNome());
		jrbMascButton.setSelected(model.isSexo());
		if(model.getDataNascimento() != null)
			txtNascimento.setText(sdf.format(model.getDataNascimento()));
	}
	public void updateModel(){
		model.setNome(txtNome.getText());
		model.setCodigo(txtCodigo.getText());
		model.setSexo(jrbMascButton.isSelected());
		try {
			model.setDataNascimento(sdf.parse(txtNascimento.getText()));
		} catch (ParseException e) {
		}
	}
	public FrmClienteDetail(Cliente cliente) {
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(450,210);
		setTitle("Manter Cliente");
		initLayout();
		model = cliente;
		updateForm();
		setVisible(true);
	}
	private void initLayout(){
		doJpnCentro();
		doJpnBotoes();
	}
	private void doJpnCentro(){
		jpnCentro = new JPanel(new ParagraphLayout());
		lblCodigo = new JLabel("Código");
		txtCodigo = new JTextField(6);

		lblNome = new JLabel("Nome");
		txtNome = new JTextField(20);

		lblSexo = new JLabel("Sexo");
		jrbFemButton = new JRadioButton("Feminino");
		jrbMascButton = new JRadioButton("Masculino");
		group.add(jrbFemButton);
		group.add(jrbMascButton);

		MaskFormatter mascData = null;
		try {
			mascData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		lblNascimento = new JLabel("Data Nascimento:");
		txtNascimento = new JFormattedTextField(mascData);
		txtNascimento.setPreferredSize(new Dimension(120,22));

		jpnCentro.add(lblCodigo, ParagraphLayout.NEW_PARAGRAPH);
		jpnCentro.add(txtCodigo);

		jpnCentro.add(lblNome, ParagraphLayout.NEW_PARAGRAPH);
		jpnCentro.add(txtNome);

		jpnCentro.add(lblSexo, ParagraphLayout.NEW_PARAGRAPH);
		jpnCentro.add(jrbMascButton);
		jpnCentro.add(jrbFemButton);

		jpnCentro.add(lblNascimento, ParagraphLayout.NEW_PARAGRAPH);
		jpnCentro.add(txtNascimento);

		add("Center",jpnCentro);
	}
	private void doJpnBotoes(){
		jpnBotoes = new JToolBar();
		jpnBotoes.setFloatable(false);
		btbOK = new JButton("OK");
		btbOK.setName("btbOK");
		btbCancelar = new JButton("Cancelar");
		btbCancelar.setName("btbCancelar");
		jpnBotoes.add(btbOK);
		jpnBotoes.add(btbCancelar);
		add("South",jpnBotoes);
	}
}