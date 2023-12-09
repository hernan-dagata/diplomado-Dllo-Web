package co.edu.iudigital.app.services.impl;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.repositories.IDelitoRepository;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public DelitoDTO save(DelitoDTORequest delitoDTO) {
        Delito delito = new Delito();
        delito.setNombre(delitoDTO.getNombre());
        delito.setDescripcion(delitoDTO.getDescripcion());

        return DelitoDTO.builder()
                .id(delito.getId())
                .nombre(delito.getNombre())
                .descripcion(delito.getDescripcion())
                .build();
    }

    @Override
    public DelitoDTO getById(Long id) {
        Optional<Delito> delitoOptional = delitoRepository.findById(id);
        if (delitoOptional.isPresent()){
            Delito delito = delitoOptional.get();
            return DelitoDTO.builder()
                    .id(delito.getId())
                    .nombre(delito.getNombre())
                    .descripcion(delito.getDescripcion())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        delitoRepository.deleteById(id);
    }
}
