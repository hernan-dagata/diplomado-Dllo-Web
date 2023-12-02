package co.edu.iudigital.app.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "nombre", nullable = false,
            unique = true, length = 50)
    String nombre;
    @Column(nullable = true, length = 120)
    String descripcion;

}
