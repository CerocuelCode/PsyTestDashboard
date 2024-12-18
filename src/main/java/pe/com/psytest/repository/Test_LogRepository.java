package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.psytest.entity.Test_LogEntity;

public interface Test_LogRepository extends JpaRepository<Test_LogEntity, Integer> {
}
