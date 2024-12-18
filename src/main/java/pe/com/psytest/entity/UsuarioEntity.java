package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="UsuarioEntity")
@Table(name = "Usuario", uniqueConstraints = {@UniqueConstraint(columnNames = "usuario")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario", nullable = false, length = 100, unique = true)
    private String usuario;

    @Column(name = "contraseina", nullable = false, length = 20)
    private String contraseina;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rolId", nullable = false)
    private RolEntity rol;
}
