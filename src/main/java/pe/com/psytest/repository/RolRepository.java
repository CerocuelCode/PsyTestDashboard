package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.RolEntity;

import java.util.List;

public interface RolRepository extends JpaRepository<RolEntity, Integer> {
    @Query("select r from RolEntity r where r.estado=true")
    List<RolEntity> findAllRolActive();

    @Query("select r from RolEntity r where r.estado=false")
    List<RolEntity> findAllRolInactive();
}
