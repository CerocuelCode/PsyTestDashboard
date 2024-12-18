package pe.com.psytest.service;

import pe.com.psytest.entity.Cita_LogEntity;

import java.util.List;

public interface Cita_LogService {
    public List<Cita_LogEntity> findAll();
    public Cita_LogEntity findById(Integer id);
}
