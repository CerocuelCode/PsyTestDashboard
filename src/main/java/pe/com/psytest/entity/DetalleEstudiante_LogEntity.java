package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity(name="DetalleEstudiante_LogEntity")
@Table(name="DetalleEstudiante_Log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetalleEstudiante_LogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log", nullable = false)
    private Integer idLog;

    @Column(name = "fechaOcurrencia", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOcurrencia;

    @Column(name = "aplicacion", length = 128)
    private String aplicacion;

    @Column(name = "servidor", length = 128)
    private String servidor;

    @Column(name = "sesionId", length = 32)
    private String sesionId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "userDescripcion", length = 128)
    private String userDescripcion;

    @Column(name = "accion", length = 3, nullable = false)
    private String accion;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private DetalleEstudianteEntity detalleEstudiante;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellidoPaterno", length = 70, nullable = false)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", length = 70, nullable = false)
    private String apellidoMaterno;

    @Column(name = "foto", length = 255, nullable = false)
    private String foto;

    @Column(name = "documentoIdentidad", length = 3, nullable = false)
    private String documentoIdentidad;

    @Column(name = "numeroDocumento", length = 20, nullable = false)
    private String numeroDocumento;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "genero", length = 10, nullable = false)
    private String genero;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "celular", length = 15, nullable = false)
    private String celular;

    @Column(name = "correoInstitucional", length = 100, nullable = false)
    private String correoInstitucional;

    @Column(name = "correoPersonal", length = 100, nullable = false)
    private String correoPersonal;

    @Column(name = "carreraId", nullable = false)
    private Integer carreraId;

    @Column(name = "usuarioId", nullable = false)
    private Integer usuarioId;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
