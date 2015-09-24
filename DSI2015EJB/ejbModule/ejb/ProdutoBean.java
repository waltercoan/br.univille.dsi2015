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
		Query consulta = em.createNamedQuery("todosProdutos");
		return consulta.getResultList();
	}
	public List<Produto> getProdutosPorDesc(String desc){
		Query consulta = em.createNamedQuery("produtosPorDesc");
		consulta.setParameter("descricao", desc);
		return consulta.getResultList();
	}

	public void save(Produto produto){
		if(em.find(Produto.class, produto.getOid()) == null){
			//insert
			em.persist(produto);
		}else{
			//update 
			em.merge(produto);
		}
	}
	public void delete(Produto produto){
		produto = em.find(Produto.class, produto.getOid());
		if(produto != null){
			em.remove(produto);
		}
	}



	


	public ProdutoBean() {
		// TODO Auto-generated constructor stub
	}

}
