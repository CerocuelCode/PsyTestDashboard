package pe.com.psytest.service;

import pe.com.psytest.entity.Carrera_LogEntity;

import java.util.List;

public interface Carrera_LogService {
    public List<Carrera_LogEntity> findAll();
    public Carrera_LogEntity findById(Integer id);
}
