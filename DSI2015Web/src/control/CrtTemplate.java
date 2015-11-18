package control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import dao.Usuario;
import ejb.ProdutoBeanLocal;
import ejb.UsuarioBeanLocal;

@ManagedBean(name="crtTemplate")
@ViewScoped
public class CrtTemplate {
	@EJB
	private UsuarioBeanLocal usuarioBean;
	private Usuario model = new Usuario();


	public boolean valida(){
		boolean result = usuarioBean.validaUsuario(model.getLogin(), model.getSenha());
		if(result){
			RequestContext.getCurrentInstance().execute("PF('dlgLogin').hide()");
		}
		return true;
	}

	@PostConstruct
	public void verificaAdmin(){
		usuarioBean.criarAdmin();
	}


	public Usuario getModel() {
		return model;
	}
	public void setModel(Usuario model) {
		this.model = model;
	}


}
