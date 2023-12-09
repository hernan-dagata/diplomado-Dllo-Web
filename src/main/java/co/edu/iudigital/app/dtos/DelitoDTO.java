package co.edu.iudigital.app.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DelitoDTO {

    Long id;
    String nombre;
    String descripcion;

}
