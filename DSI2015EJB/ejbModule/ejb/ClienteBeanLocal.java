package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Cliente;
import dao.Produto;

@Local
public interface ClienteBeanLocal {
	public List<Cliente> getAllClientes();
	public void save(Cliente cliente);
}
