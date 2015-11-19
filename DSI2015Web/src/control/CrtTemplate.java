package control;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import dao.Usuario;
import ejb.UsuarioBeanLocal;

@ManagedBean(name="crtTemplate")
@ViewScoped
public class CrtTemplate {
	@EJB
	private UsuarioBeanLocal usuarioBean;
	private Usuario model = new Usuario();


	public boolean valida(){
		Usuario user = null;
		
		user = usuarioBean.validaUsuario(model.getLogin(), model.getSenha());
		
		if(user != null){
			RequestContext.getCurrentInstance().execute("PF('dlgLogin').hide()");
			
			FacesContext fc = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			session.setAttribute("USUARIO_LOGADO", user);
			
		}
		return true;
	}

	public void abrirLogin(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		if(session.getAttribute("USUARIO_LOGADO") == null){
			RequestContext.getCurrentInstance().execute("PF('dlgLogin').show()");
		}
	}
	public void dologoff(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.removeAttribute("USUARIO_LOGADO");
		ExternalContext ec = fc.getExternalContext();
		try {
		        ec.redirect("index.xhtml");
		} catch (IOException ex) {
		}
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
