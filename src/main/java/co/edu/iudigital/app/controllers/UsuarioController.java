package co.edu.iudigital.app.controllers;

import co.edu.iudigital.app.dtos.DelitoDTO;
import co.edu.iudigital.app.dtos.DelitoDTORequest;
import co.edu.iudigital.app.services.ifaces.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class UsuarioController {

    @Autowired
    private IDelitoService delitoService;

//    @GetMapping("/all")
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



}
