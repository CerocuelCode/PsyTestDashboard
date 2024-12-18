package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="CitaEntity")
@Table(name="Cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class
CitaEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudianteId", referencedColumnName = "id", nullable = true)
    private DetalleEstudianteEntity estudiante; // Relación opcional con estudiante

    @ManyToOne(optional = false)
    @JoinColumn(name = "psicologoId", referencedColumnName = "id", nullable = false)
    private DetallePsicologoEntity psicologo; // Relación obligatoria con psicólogo

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "situacion", nullable = false, length = 20)
    private String situacion = "Disponible"; // Situación predeterminada

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
