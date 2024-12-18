package pe.com.psytest.service;

import pe.com.psytest.entity.Usuario_LogEntity;

import java.util.List;

public interface Usuario_LogService {
    public List<Usuario_LogEntity> findAll();
    public Usuario_LogEntity findById(Integer id);
}
