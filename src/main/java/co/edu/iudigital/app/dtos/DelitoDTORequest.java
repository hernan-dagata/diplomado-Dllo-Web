package co.edu.iudigital.app.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DelitoDTORequest implements Serializable {
    @NotNull(message = "El nombre es obligatorio.")
    @JsonProperty("nombre")
    String nombre;

    @JsonProperty("descripcion")
    String descripcion;

}
