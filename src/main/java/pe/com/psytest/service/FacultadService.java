package pe.com.psytest.service;

import pe.com.psytest.entity.FacultadEntity;

import java.util.List;

public interface FacultadService {
    public List<FacultadEntity> findAll();
    public List<FacultadEntity> findAllFacultadActive();
    public List<FacultadEntity> findAllFacultadInactive();
    public FacultadEntity findById(Integer id);
    public FacultadEntity add(FacultadEntity f);
    public FacultadEntity update(FacultadEntity f);
    public FacultadEntity delete(FacultadEntity f);
}
