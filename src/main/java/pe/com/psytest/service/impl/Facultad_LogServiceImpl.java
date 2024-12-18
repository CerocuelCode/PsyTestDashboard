package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Facultad_LogEntity;
import pe.com.psytest.repository.Facultad_LogRepository;
import pe.com.psytest.service.Facultad_LogService;

import java.util.List;

@Service
public class Facultad_LogServiceImpl implements Facultad_LogService {
    @Autowired
    private Facultad_LogRepository facultad_logRepository;

    @Override
    public List<Facultad_LogEntity> findAll() {
        return facultad_logRepository.findAll();
    }

    @Override
    public Facultad_LogEntity findById(Integer id) {
        return facultad_logRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Facultad_LogEntity no encontrada con id: "+id));
    }
}
