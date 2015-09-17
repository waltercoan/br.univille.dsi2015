package ejb;

import java.util.List;

import javax.ejb.Remote;

import dao.Cliente;

@Remote
public interface ClienteBeanRemote {
	public List<Cliente> getAllClientes();
	public void save(Cliente cliente);
}
