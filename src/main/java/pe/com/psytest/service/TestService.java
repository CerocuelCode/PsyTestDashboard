package pe.com.psytest.service;

import pe.com.psytest.entity.TestEntity;

import java.util.List;

public interface TestService {
    public List<TestEntity> findAll();
    public List<TestEntity> findAllTestActive();
    public List<TestEntity> findAllTestInactive();
    public TestEntity findById(Integer id);
    public TestEntity add(TestEntity t);
    public TestEntity update(TestEntity t);
    public TestEntity delete(TestEntity t);
}
