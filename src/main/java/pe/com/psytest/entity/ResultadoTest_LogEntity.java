package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity(name="ResultadoTest_LogEntity")
@Table(name="ResultadoTest_Log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoTest_LogEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log", nullable = false)
    private Integer idLog;

    // Campos de auditoría
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

    // Campos relacionados con la tabla principal
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ResultadoTestEntity resultadoTest;

    @Column(name = "usuarioId", nullable = false)
    private Integer usuarioId;

    @Column(name = "testId", nullable = false)
    private Integer testId;

    @Column(name = "puntaje", nullable = false)
    private Short puntaje;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
