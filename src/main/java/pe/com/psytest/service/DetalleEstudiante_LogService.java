package pe.com.psytest.service;

import pe.com.psytest.entity.DetalleEstudiante_LogEntity;

import java.util.List;

public interface DetalleEstudiante_LogService {
    public List<DetalleEstudiante_LogEntity> findAll();
    public DetalleEstudiante_LogEntity findById(Integer id);
}
