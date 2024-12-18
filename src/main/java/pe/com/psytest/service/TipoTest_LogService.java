package pe.com.psytest.service;

import pe.com.psytest.entity.TipoTest_LogEntity;

import java.util.List;

public interface TipoTest_LogService {
    public List<TipoTest_LogEntity> findAll();
    public TipoTest_LogEntity findById(Integer id);

}
