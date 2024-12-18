package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Carrera_LogEntity;
import pe.com.psytest.repository.Carrera_LogRepository;
import pe.com.psytest.service.Carrera_LogService;

import java.util.List;

@Service
public class Carrera_LogServiceImpl implements Carrera_LogService {
    @Autowired
    private Carrera_LogRepository carrera_logRepository;

    @Override
    public List<Carrera_LogEntity> findAll() {
        return carrera_logRepository.findAll();
    }

    @Override
    public Carrera_LogEntity findById(Integer id) {
        return carrera_logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera_LogEntity no encontrada con id: " + id));
    }
}
