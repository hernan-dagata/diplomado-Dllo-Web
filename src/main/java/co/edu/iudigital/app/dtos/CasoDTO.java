package co.edu.iudigital.app.dtos;

import co.edu.iudigital.app.models.Delito;
import co.edu.iudigital.app.models.Usuario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CasoDTO {

    Long id;

    LocalDateTime fechaHora;

    Float latitud;

    Float longitud;

    Float altitud;

    Boolean esVisible;

    String detalle;

    String urlMapa;

    String rmiUrl;

}
