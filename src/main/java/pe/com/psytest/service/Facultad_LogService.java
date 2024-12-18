package pe.com.psytest.service;

import pe.com.psytest.entity.Facultad_LogEntity;

import java.util.List;

public interface Facultad_LogService {
    public List<Facultad_LogEntity> findAll();
    public Facultad_LogEntity findById(Integer id);
}
