package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dataEmissao;
	private boolean concluido;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Cliente clientePedido;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Pedido_oid")
	private List<ItemPedido> colItensPedido = new ArrayList<ItemPedido>();
		
	//Segue abaixo código dos métodos GETs e SETs...
	
	public Cliente getClientePedido() {
		return clientePedido;
	}
	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}
	public List<ItemPedido> getColItensPedido() {
		return colItensPedido;
	}
	public void setColItensPedido(List<ItemPedido> colItensPedido) {
		this.colItensPedido = colItensPedido;
	}
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public boolean isConcluido() {
		return concluido;
	}
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}
	
	
}
