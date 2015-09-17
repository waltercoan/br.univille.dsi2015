package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Cliente;

/**
 * Session Bean implementation class ClienteBean
 */
@Stateless
@LocalBean
public class ClienteBean implements ClienteBeanRemote, ClienteBeanLocal {

	@PersistenceContext(name="dsi2015context")
	private EntityManager em;
	
	
    public ClienteBean() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Cliente> getAllClientes(){
    	Query q = em.createNamedQuery("getAll");
    	return q.getResultList();
    }
	public void save(Cliente cliente) {
		if(em.find(Cliente.class, cliente.getOid())!=null){
			em.merge(cliente);
		}else{
			em.persist(cliente);
		}
		
	}
    
    
    
}
