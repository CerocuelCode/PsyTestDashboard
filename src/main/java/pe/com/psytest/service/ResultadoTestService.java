package pe.com.psytest.service;

import pe.com.psytest.entity.ResultadoTestEntity;

import java.util.List;

public interface ResultadoTestService {
    public List<ResultadoTestEntity> findAll();
    public ResultadoTestEntity findById(int id);
}
