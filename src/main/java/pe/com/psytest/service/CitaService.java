package pe.com.psytest.service;

import pe.com.psytest.entity.CitaEntity;

import java.util.List;

public interface CitaService {
    public List<CitaEntity> findAll();
    public List<CitaEntity> findAllCitaActive();
    public List<CitaEntity> findAllCitaInactive();
    public List<CitaEntity> findAllCitaReservada();
    public CitaEntity findById(Integer id);
    public CitaEntity add(CitaEntity c);
    public CitaEntity update(CitaEntity c);
    public CitaEntity delete(CitaEntity c);

}
