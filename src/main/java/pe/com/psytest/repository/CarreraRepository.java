package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.CarreraEntity;

import java.util.List;

public interface CarreraRepository extends JpaRepository<CarreraEntity, Integer> {
    @Query("select c from CarreraEntity c where c.estado=true")
    List<CarreraEntity> findAllCarreraActive();
    @Query("select c from CarreraEntity c where c.estado=false")
    List<CarreraEntity> findAllCarreraInactive();
}
