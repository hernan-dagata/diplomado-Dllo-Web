package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private IDelitoService delitoService;

    @GetMapping()
    public ResponseEntity<List<DelitoDTO>> index() {
        return ResponseEntity.ok()
                .body(delitoService.getAll());
    }

    @PostMapping
    public ResponseEntity<DelitoDTO> save(@Validated @RequestBody DelitoDTORequest delitoDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(delitoService.save(delitoDTORequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            delitoService.deleteById(id);
            return new ResponseEntity<>("Delito eliminado correctamente", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al eliminar el delito: " + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDelitoById(@PathVariable Long id) {
        try {
            DelitoDTO delitoDTO = delitoService.getById(id);
            return new ResponseEntity<>(delitoDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Delito no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener el delito: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDelito(@PathVariable Long id, @RequestBody DelitoDTORequest delitoDTORequest) {
        try {
            DelitoDTO updatedDelitoDTO = delitoService.update(id, delitoDTORequest);
            return new ResponseEntity<>(updatedDelitoDTO, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Delito no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar el delito: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
