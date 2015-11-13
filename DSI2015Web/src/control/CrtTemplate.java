package control;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		return usuarioBean.validaUsuario(model.getLogin(), model.getSenha());
	}
	
	
	public Usuario getModel() {
		return model;
	}
	public void setModel(Usuario model) {
		this.model = model;
	}
	
}
