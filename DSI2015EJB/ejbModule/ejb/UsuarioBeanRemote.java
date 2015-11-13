package ejb;

import javax.ejb.Remote;

@Remote
public interface UsuarioBeanRemote {
	public boolean validaUsuario(String login, String senha);
}
