import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import dao.Produto;
import ejb.ProdutoBeanLocal;


@Path("/produto")
@javax.enterprise.context.RequestScoped
public class ProdutoREST {

	@Inject
	private ProdutoBeanLocal produtoBean;
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Produto> getAllProdutos(){
		return produtoBean.getTodosProdutos();
	}
	
	
}
