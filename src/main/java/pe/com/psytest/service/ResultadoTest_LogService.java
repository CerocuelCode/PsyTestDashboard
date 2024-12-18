package pe.com.psytest.service;

import pe.com.psytest.entity.ResultadoTest_LogEntity;

import java.util.List;

public interface ResultadoTest_LogService {
    public List<ResultadoTest_LogEntity> findAll();
    public ResultadoTest_LogEntity findById(Integer id);
}
