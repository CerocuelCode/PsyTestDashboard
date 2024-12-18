package pe.com.psytest.service;

import pe.com.psytest.entity.DetallePsicologoEntity;

import java.util.List;

public interface DetallePsicologoService {
    public List<DetallePsicologoEntity> findAll();
    public List<DetallePsicologoEntity> findAllPsicologoActive();
    public List<DetallePsicologoEntity> findAllPsicologoInactive();
    public DetallePsicologoEntity findById(Integer id);
    public DetallePsicologoEntity add(DetallePsicologoEntity dp);
    public DetallePsicologoEntity update(DetallePsicologoEntity dp);
    public DetallePsicologoEntity delete(DetallePsicologoEntity dp);
}
