package quixada.npi.springproject.service;
import java.util.List;
import quixada.npi.springproject.model.Usuario;


public interface UsuarioService {

    Usuario findByEmail(String email);

    List<Usuario> findAll();

	void deleteUser(Integer id);

	Usuario save(Usuario usuario);

	Usuario update(Usuario usuario);

}
