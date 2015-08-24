package dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cardapio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int oid;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private Restaurante meuRestaurante;	
}
