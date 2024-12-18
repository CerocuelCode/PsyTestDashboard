package pe.com.psytest.service;

import pe.com.psytest.entity.DetallePsicologo_LogEntity;

import java.util.List;

public interface DetallePsicologo_LogService {
    public List<DetallePsicologo_LogEntity> findAll();
    public DetallePsicologo_LogEntity findById(Integer id);
}
