package co.edu.iudigital.app.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "delitos")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "nombre", nullable = false,
            unique = true, length = 120)
    String nombre;

    @Column(nullable = true, length = 255)
    String descripcion;

}
