package co.edu.iudigital.app.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "casos")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "fecha_hora")
    LocalDateTime fechaHora;

    @Column(nullable = false)
    Float latitud;

    @Column(nullable = false)
    Float longitud;

    @Column(nullable = false)
    Float altitud;

    @Column(name = "is_visible", nullable = false)
    Boolean esVisible;

    @Column(nullable = false, length = 250)
    String detalle;

    @Column(name = "url_map", nullable = false)
    String urlMapa;

    @Column(name = "rmi_url", nullable = false)
    String rmiUrl;

    @ManyToOne
    @JoinColumn(name = "delitos_id")
    Delito delito;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    Usuario usuario;

}
