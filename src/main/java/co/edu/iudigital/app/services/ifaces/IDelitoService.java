package co.edu.iudigital.app.services.ifaces;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;

import java.util.List;

public interface IDelitoService {

    //TODO: Agregar excepciones personalizadas.

    List<DelitoDTO> getAll();

    DelitoDTO save(DelitoDTORequest delito);

    DelitoDTO getById(Long id);

    void deleteById(Long Id);
}
