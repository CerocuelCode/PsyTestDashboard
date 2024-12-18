package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.psytest.entity.TipoTest_LogEntity;

public interface TipoTest_LogRepository extends JpaRepository<TipoTest_LogEntity, Integer> {
}
