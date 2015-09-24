package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Produto;
import ejb.ProdutoBeanLocal;

@ManagedBean(name="crtProduto")
@ViewScoped
public class CrtProduto {
	@EJB
	private ProdutoBeanLocal produtoBean;
	
	private Produto model = new Produto();
	
	public void createNewProduto(){
		model = new Produto();
	}
	public void save(){
		produtoBean.save(model);
	}
	
	public Produto getModel() {
		return model;
	}


	public void setModel(Produto model) {
		this.model = model;
	}


	public List<Produto> getAllProdutos(){
		return produtoBean.getTodosProdutos();
	}
	
	
	public ProdutoBeanLocal getProdutoBean() {
		return produtoBean;
	}

	public void setProdutoBean(ProdutoBeanLocal produtoBean) {
		this.produtoBean = produtoBean;
	}





	public void novoProduto(){
		Produto novinho = new Produto();
		novinho.setDescricao("Meu deus como e novo");
		produtoBean.save(novinho);
	}
	
	
	
}
