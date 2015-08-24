package dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	private int quantidade;
	private float valorItem;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Produto produtoItem;
	
	
	//Segue abaixo código dos métodos GETs e SETs
	
	public Produto getProdutoItem() {
		return produtoItem;
	}
	public void setProdutoItem(Produto produtoItem) {
		this.produtoItem = produtoItem;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValorItem() {
		return valorItem;
	}
	public void setValorItem(float valorItem) {
		this.valorItem = valorItem;
	}
	
}
