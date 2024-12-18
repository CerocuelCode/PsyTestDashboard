package pe.com.psytest.service;

import pe.com.psytest.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioEntity> findAll();
    public List<UsuarioEntity> findAllUsuarioActive();
    public List<UsuarioEntity> findAllUsuarioInactive();
    public List<UsuarioEntity> findEstudiantesLibres();
    public List<UsuarioEntity> findPsicologosLibres();
    public UsuarioEntity findById(Integer id);
    public UsuarioEntity add(UsuarioEntity u);
    public UsuarioEntity update(UsuarioEntity u);
    public UsuarioEntity delete(UsuarioEntity u);

}
