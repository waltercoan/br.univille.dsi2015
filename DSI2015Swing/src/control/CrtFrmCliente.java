package control;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.ModeloTabCliente;
import util.ServerConnection;
import dao.Cliente;
import form.FrmCliente;

public class CrtFrmCliente implements ActionListener{

    private FrmCliente frame;
    private ModeloTabCliente tableModel;
    public CrtFrmCliente(FrmCliente frmCliente, ModeloTabCliente tableModel) {
        this.frame = frmCliente;
        this.tableModel = tableModel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Component comp = (Component)e.getSource();
        //aqui vai a logica dos botoes
    }

    private void updateJTable(){
        List<Cliente> listaClientes = ServerConnection.getInstance().
                                      getClienteBeanRemote().getAllClientes();
        tableModel.atualiza(listaClientes);
    }
}