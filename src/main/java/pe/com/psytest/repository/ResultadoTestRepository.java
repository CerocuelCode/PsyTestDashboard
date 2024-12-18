package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.entity.ResultadoTestEntity;

import java.util.List;

public interface ResultadoTestRepository extends JpaRepository<ResultadoTestEntity, Integer> {
    @Query("select rt from ResultadoTestEntity rt where rt.estado=true")
    List<ResultadoTestEntity> findAllResultadoTestActive();
    @Query("select rt from ResultadoTestEntity rt where rt.estado=false")
    List<ResultadoTestEntity> findAllResultadoTestInactive();
}
