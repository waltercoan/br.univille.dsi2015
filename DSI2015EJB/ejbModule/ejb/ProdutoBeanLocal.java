package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Produto;

@Local
public interface ProdutoBeanLocal {
	public List<Produto> getTodosProdutos();
	public List<Produto> getProdutosPorDesc(String desc);
}
