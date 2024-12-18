package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.FacultadEntity;

import java.util.List;

public interface FacultadRepository extends JpaRepository<FacultadEntity, Integer> {
    @Query("select f from FacultadEntity f where f.estado=true")
    List<FacultadEntity> findAllFacultadActive();
    @Query("select f from FacultadEntity f where f.estado=false")
    List<FacultadEntity> findAllFacultadInactive();
}
