package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.IDelitoRepository;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DelitoServiceImpl implements IDelitoService {

    @Autowired
    private IDelitoRepository delitoRepository;

    @Override
    public List<DelitoDTO> getAll() {
        List<Delito> delitos = (List<Delito>) delitoRepository.findAll();
        List<DelitoDTO> respDelitos =
                delitos.stream().map(delito -> DelitoDTO.builder()
                                .id(delito.getId())
                                .nombre(delito.getNombre())
                                .descripcion(delito.getDescripcion())
                                .build())
                        .collect(Collectors.toList()); // Convertir Stream a List
        return respDelitos;
    }

    @Override
    public DelitoDTO save(DelitoDTORequest delitoDTORequest) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTORequest.getNombre());
        delito.setDescripcion(delitoDTORequest.getDescripcion());

        delito = delitoRepository.save(delito);

        return DelitoDTO.builder()
                .id(delito.getId())
                .nombre(delito.getNombre())
                .descripcion(delito.getDescripcion())
                .build();
    }

    public DelitoDTO getById(Long id) {
        Optional<Delito> delitoOptional = delitoRepository.findById(id);
        if (delitoOptional.isPresent()) {
            Delito delito = delitoOptional.get();
            return DelitoDTO.builder()
                    .id(delito.getId())
                    .nombre(delito.getNombre())
                    .descripcion(delito.getDescripcion())
                    .build();
        } else {
            throw new EntityNotFoundException("Delito con ID " + id + " no encontrado");
        }
    }

    @Override
    public void deleteById(Long id) {
        delitoRepository.deleteById(id);
    }

    @Override
    public DelitoDTO update(Long id, DelitoDTORequest delitoDTORequest) {
        Delito delito = delitoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Delito con ID " + id + " no encontrado"));

        delito.setNombre(delitoDTORequest.getNombre());
        delito.setDescripcion(delitoDTORequest.getDescripcion());
        delitoRepository.save(delito);
        return DelitoDTO.builder()
                .id(delito.getId())
                .nombre(delito.getNombre())
                .descripcion(delito.getDescripcion())
                .build();
    }
}
