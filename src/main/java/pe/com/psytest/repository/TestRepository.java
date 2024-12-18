package pe.com.psytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.psytest.entity.TestEntity;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {
    @Query("select t from TestEntity t where t.estado=true")
    List<TestEntity> findAllTestActive();
    @Query("select t from TestEntity t where t.estado=false")
    List<TestEntity> findAllTestInactive();
}
