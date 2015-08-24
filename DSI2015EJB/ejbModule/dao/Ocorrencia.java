package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Ocorrencia {
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ocorrenciadepend_oid")
	private List<Ocorrencia> colOcorrenciasDenp = new ArrayList<Ocorrencia>();
}
