package co.edu.iudigital.app.repositories;

import co.edu.iudigital.app.models.Delito;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDelitoRepository extends CrudRepository<Delito, Long> {
}
