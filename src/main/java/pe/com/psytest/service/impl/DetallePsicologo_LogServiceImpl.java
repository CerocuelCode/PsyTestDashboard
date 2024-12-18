package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.DetallePsicologo_LogEntity;
import pe.com.psytest.repository.DetallePsicologo_LogRepository;
import pe.com.psytest.service.DetallePsicologo_LogService;

import java.util.List;

@Service
public class DetallePsicologo_LogServiceImpl implements DetallePsicologo_LogService {
    @Autowired
    private DetallePsicologo_LogRepository detallePsicologo_LogRepository;


    @Override
    public List<DetallePsicologo_LogEntity> findAll() {
        return detallePsicologo_LogRepository.findAll();
    }

    @Override
    public DetallePsicologo_LogEntity findById(Integer id) {
        return detallePsicologo_LogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetallePsicologo_LogEntity no encontrada con id: " + id));
    }
}
