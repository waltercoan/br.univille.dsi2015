package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="todosProdutos", 
			query="Select p from Produto p"),
	
	@NamedQuery(name="produtosPorDesc",
		query = "Select p from Produto p where p.descricao like :descricao")
})


@Entity
public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	@Column(unique=true)
	private int codigo;
	@Column(length=10000)
	private String descricao;
	private float valor;
	
	//Segue abaixo código dos métodos GETs e SETs...
	
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
