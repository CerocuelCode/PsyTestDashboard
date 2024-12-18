package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.psytest.entity.Usuario_LogEntity;

public interface Usuario_LogRepository extends JpaRepository<Usuario_LogEntity, Integer> {
}
