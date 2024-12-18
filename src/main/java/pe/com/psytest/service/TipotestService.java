package pe.com.psytest.service;

import pe.com.psytest.entity.TipoTestEntity;

import java.util.List;

public interface TipotestService {
    public List<TipoTestEntity> findAll();
    public List<TipoTestEntity> findAllTipoTestActive();
    public List<TipoTestEntity> findAllTipoTestInactive();
    public TipoTestEntity findById(Integer id);
    public TipoTestEntity add(TipoTestEntity tt);
    public TipoTestEntity update(TipoTestEntity tt);
    public TipoTestEntity delete(TipoTestEntity tt);
}
