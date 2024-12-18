package pe.com.psytest.service;

import pe.com.psytest.entity.DetalleEstudianteEntity;

import java.util.List;

public interface DetalleEstudianteService {
    public List<DetalleEstudianteEntity> findAll();
    public List<DetalleEstudianteEntity> findAllEstudianteActive();
    public List<DetalleEstudianteEntity> findAllEstudianteInactive();
    public DetalleEstudianteEntity findById(Integer id);
    public DetalleEstudianteEntity add(DetalleEstudianteEntity de);
    public DetalleEstudianteEntity update(DetalleEstudianteEntity de);
    public DetalleEstudianteEntity delete(DetalleEstudianteEntity de);
}

