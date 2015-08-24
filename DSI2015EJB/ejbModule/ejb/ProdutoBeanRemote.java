package ejb;

import java.util.List;

import javax.ejb.Remote;

import dao.Produto;

@Remote
public interface ProdutoBeanRemote {
	public List<Produto> getTodosProdutos();
	public List<Produto> getProdutosPorDesc(String desc);
}
