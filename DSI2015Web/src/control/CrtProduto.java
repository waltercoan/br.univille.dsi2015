package control;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ProdutoBeanLocal;

@ManagedBean(name="crtProduto")
@ViewScoped
public class CrtProduto {

	@EJB
	public ProdutoBeanLocal produtoBean;

	public ProdutoBeanLocal getProdutoBean() {
		return produtoBean;
	}

	public void setProdutoBean(ProdutoBeanLocal produtoBean) {
		this.produtoBean = produtoBean;
	}
	
}
