package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.DetalleEstudianteEntity;

import java.util.List;

public interface DetalleEstudianteRepository extends JpaRepository<DetalleEstudianteEntity, Integer> {
    @Query("select de from DetalleEstudianteEntity de where de.estado=true")
    List<DetalleEstudianteEntity> findAllEstudianteActive();
    @Query("select de from DetalleEstudianteEntity de where de.estado=false")
    List<DetalleEstudianteEntity> findAllEstudianteInactive();
}
