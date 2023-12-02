package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Caso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICasoRepository extends CrudRepository<Caso, Long> {
}
