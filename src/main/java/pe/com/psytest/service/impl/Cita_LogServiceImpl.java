package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Cita_LogEntity;
import pe.com.psytest.repository.Cita_LogRepository;
import pe.com.psytest.service.Cita_LogService;

import java.util.List;

@Service
public class Cita_LogServiceImpl implements Cita_LogService {
    @Autowired
    private Cita_LogRepository cita_logRepository;

    @Override
    public List<Cita_LogEntity> findAll() {
        return cita_logRepository.findAll();
    }

    @Override
    public Cita_LogEntity findById(Integer id) {
        return cita_logRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Cita_LogEntity no encontrada con id: "+id));
    }
}
