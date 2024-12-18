package pe.com.psytest.service;

import pe.com.psytest.entity.RolEntity;

import java.util.List;

public interface RolService {
    public List<RolEntity> findAll();
    public List<RolEntity> findAllRolActive();
    public List<RolEntity> findAllRolInactive();
    public RolEntity findById(Integer id);
    public RolEntity add(RolEntity r);
    public RolEntity update(RolEntity r);
    public RolEntity delete(RolEntity r);
}
