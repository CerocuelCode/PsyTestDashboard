package pe.com.psytest.service;

import pe.com.psytest.entity.Test_LogEntity;

import java.util.List;

public interface Test_LogService {
    public List<Test_LogEntity> findAll();
    public Test_LogEntity findById(Integer id);
}
