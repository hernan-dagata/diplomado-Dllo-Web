package co.edu.iudigital.app.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "nombre_usuario", nullable = false,
            unique = true, length = 120)
    String nombreUsuario;

    @Column(nullable = false, length = 120)
    String nombre;

    @Column(nullable = false, length = 120)
    String apellido;

    @Column(length = 25)
    String contrasena;

    @Column(name = "fecha_nacimiento", length = 120)
    LocalDate fechaNacimiento;

    @Column
    Boolean habilitado;

    @Column
    String imagen;

    @Column(name = "red_social")
    Boolean redSocial;

    @ManyToMany
    @JoinTable(name = "roles_usuarios",
            joinColumns = {@JoinColumn(name = "usuarios_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    List<Role> roles;


}
