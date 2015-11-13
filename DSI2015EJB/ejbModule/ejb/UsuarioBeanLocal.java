package ejb;

import javax.ejb.Local;

@Local
public interface UsuarioBeanLocal {
	public boolean validaUsuario(String login, String senha);
}
