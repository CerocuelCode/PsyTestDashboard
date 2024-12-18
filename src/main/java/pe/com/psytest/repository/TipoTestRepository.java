package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.TipoTestEntity;

import java.util.List;

public interface TipoTestRepository extends JpaRepository<TipoTestEntity, Integer> {
    @Query("select tt from TipoTestEntity tt where tt.estado=true")
    List<TipoTestEntity> findAllTipoTestActive();
    @Query("select tt from TipoTestEntity tt where tt.estado=false")
    List<TipoTestEntity> findAllTipoTestInactive();
}
