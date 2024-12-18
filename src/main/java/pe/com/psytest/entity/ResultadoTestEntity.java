package pe.com.psytest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="ResultadoTestEntity")
@Table(name="ResultadoTest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoTestEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioId", nullable = false)
    private UsuarioEntity usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "testId", nullable = false)
    private TestEntity test;

    @Column(name = "puntaje", nullable = false)
    private Integer puntaje;

    @Column(name = "fechaRegistro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "horaModificacion", nullable = false)
    private LocalTime horaModificacion;

    @Column(name = "fechaModificacion", nullable = false)
    private LocalDate fechaModificacion;

    @Column(name = "estado", nullable = false)
    private Boolean estado;
}
