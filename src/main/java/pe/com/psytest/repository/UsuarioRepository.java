package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    @Query("Select u from UsuarioEntity u where u.estado=true")
    List<UsuarioEntity> findAllUsuarioActive();
    @Query("Select u from UsuarioEntity u where u.estado=false")
    List<UsuarioEntity> findAllUsuarioInactive();
    @Query("SELECT u FROM UsuarioEntity u " +
            "JOIN u.rol r " +
            "WHERE r.nombre = 'ESTUDIANTE' " +
            "AND u.estado = true " +
            "AND NOT EXISTS (SELECT 1 FROM DetalleEstudianteEntity e WHERE e.usuario = u)")
    List<UsuarioEntity> findEstudiantesLibres();

    @Query("SELECT u FROM UsuarioEntity u " +
            "JOIN u.rol r " +
            "WHERE r.nombre = 'PSICÓLOGO' " +
            "AND u.estado = true " +
            "AND NOT EXISTS (SELECT 1 FROM DetallePsicologoEntity p WHERE p.usuario = u)")
    List<UsuarioEntity> findPsicologosLibres();

    @Query("Select u from UsuarioEntity u where u.rol.nombre='ADMINISTRADOR' and u.estado=true")
    List<UsuarioEntity> findAllAdministrators();

    @Query("Select u from UsuarioEntity u where u.rol.nombre='ESTUDIANTE' and u.estado=true")
    List<UsuarioEntity> findAllStudents();

    @Query("Select u from UsuarioEntity u where u.rol.nombre='PSICÓLOGO' and u.estado=true")
    List<UsuarioEntity> findAllPsychologists();
}
