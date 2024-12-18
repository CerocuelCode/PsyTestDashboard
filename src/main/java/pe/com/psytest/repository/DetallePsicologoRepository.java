package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.DetallePsicologoEntity;

import java.util.List;

public interface DetallePsicologoRepository extends JpaRepository<DetallePsicologoEntity, Integer> {
    @Query("select dp from DetallePsicologoEntity dp where dp.estado=true")
    List<DetallePsicologoEntity> findAllPsicologoActive();
    @Query("select dp from DetallePsicologoEntity dp where dp.estado=false")
    List<DetallePsicologoEntity> findAllPsicologoInactive();
}
