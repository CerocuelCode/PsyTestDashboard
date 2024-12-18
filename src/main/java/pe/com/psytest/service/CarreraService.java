package pe.com.psytest.service;

import pe.com.psytest.entity.CarreraEntity;

import java.util.List;

public interface CarreraService {
    public List<CarreraEntity> findAll();
    public List<CarreraEntity> findAllCarreraActive();
    public List<CarreraEntity> findAllCarreraInactive();
    public CarreraEntity findById(Integer id);
    public CarreraEntity add(CarreraEntity c);
    public CarreraEntity update(CarreraEntity c);
    public CarreraEntity delete(CarreraEntity c);
}
