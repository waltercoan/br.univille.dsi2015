package ejb;

import javax.ejb.Local;

import dao.Usuario;

@Local
public interface UsuarioBeanLocal {
	public Usuario validaUsuario(String login, String senha);
	public void criarAdmin();
}
