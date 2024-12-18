package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="DetallePsicologoEntity")
@Table(name = "DetallePsicologo",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"numeroDocumento"}),
                @UniqueConstraint(columnNames = {"correoInstitucional"}),
                @UniqueConstraint(columnNames = {"correoPersonal"}),
                @UniqueConstraint(columnNames = {"usuarioId"})
        })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePsicologoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidoPaterno", nullable = false, length = 70)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 70)
    private String apellidoMaterno;

    @Column(name = "foto", nullable = false, length = 255)
    private String foto;

    @Column(name = "documentoIdentidad", nullable = false, length = 3)
    private String documentoIdentidad;

    @Column(name = "numeroDocumento", nullable = false, length = 20, unique = true)
    private String numeroDocumento;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "celular", nullable = false, length = 15)
    private String celular;

    @Column(name = "correoInstitucional", length = 100, unique = true)
    private String correoInstitucional;

    @Column(name = "correoPersonal", length = 100, unique = true)
    private String correoPersonal;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne(optional = false) // Relación con Usuario
    @JoinColumn(name = "usuarioId", nullable = false, unique = true)
    private UsuarioEntity usuario;
}
