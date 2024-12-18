package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Rol_LogEntity;
import pe.com.psytest.repository.Rol_LogRepository;
import pe.com.psytest.service.Rol_LogService;

import java.util.List;

@Service
public class Rol_LogServiceImpl implements Rol_LogService {
    @Autowired
    private Rol_LogRepository rol_LogRepository;

    @Override
    public List<Rol_LogEntity> findAll() {
        return rol_LogRepository.findAll();
    }

    @Override
    public Rol_LogEntity findById(Integer id) {
        return rol_LogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol_LogEntity no encontrada con id: " + id));
    }

}
