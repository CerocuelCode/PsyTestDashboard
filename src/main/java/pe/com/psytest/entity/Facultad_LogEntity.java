package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity(name="Facultad_LogEntity")
@Table(name="Facultad_Log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facultad_LogEntity implements Serializable {
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

    @Column(name = "accion", nullable = false, length = 3)
    private String accion;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private FacultadEntity facultad;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
