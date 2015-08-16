package ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Produto;

/**
 * Session Bean implementation class ProdutoBean
 */
@Stateless
@LocalBean
public class ProdutoBean implements ProdutoBeanRemote, ProdutoBeanLocal {

	@PersistenceContext(name="dsi2015context")
	private EntityManager em;
	
	public List<Produto> getTodosProdutos(){
		Query q = em.createNamedQuery("todosProdutos");
		return q.getResultList();
	}
	
	public List<Produto> getProdutosPorDesc(String desc){
		Query q = em.createNamedQuery("produtosPorDesc");
		q.setParameter("descricao", "%"+desc+"%");
		//q.setParameter("descricao", String.format("\\%%s\\%", desc));
		//q.setMaxResults(10);
		//q.setFirstResult(prox);
		return q.getResultList();
	}
	
	
    public ProdutoBean() {
        // TODO Auto-generated constructor stub
    }

}
