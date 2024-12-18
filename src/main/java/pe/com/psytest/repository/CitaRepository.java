package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.CitaEntity;

import java.util.List;

public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {
    @Query("select c from CitaEntity c where c.estado=true")
    List<CitaEntity> findAllCitaActive();
    @Query("select c from CitaEntity c where c.estado=false")
    List<CitaEntity> findAllCitaInactive();

    @Query("SELECT c FROM CitaEntity c WHERE c.estudiante IS NOT NULL")
    List<CitaEntity> findAllCitaReservada();
}
