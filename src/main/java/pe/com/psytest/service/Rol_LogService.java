package pe.com.psytest.service;

import pe.com.psytest.entity.Rol_LogEntity;

import java.util.List;

public interface Rol_LogService {
    public List<Rol_LogEntity> findAll();
    public Rol_LogEntity findById(Integer id);
}
