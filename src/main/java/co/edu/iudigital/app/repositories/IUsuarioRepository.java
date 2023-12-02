package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByNombreUsuario(String nombreUsuario);
}
