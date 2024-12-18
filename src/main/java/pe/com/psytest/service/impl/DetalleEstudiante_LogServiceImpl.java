package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.DetalleEstudiante_LogEntity;
import pe.com.psytest.repository.DetalleEstudiante_LogRepository;
import pe.com.psytest.service.DetalleEstudiante_LogService;

import java.util.List;

@Service
public class DetalleEstudiante_LogServiceImpl implements DetalleEstudiante_LogService {
    @Autowired
    private DetalleEstudiante_LogRepository detalleEstudiante_LogRepository;

    @Override
    public List<DetalleEstudiante_LogEntity> findAll() {
        return detalleEstudiante_LogRepository.findAll();
    }

    @Override
    public DetalleEstudiante_LogEntity findById(Integer id) {
        return detalleEstudiante_LogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetalleEstudiante_LogEntity no encontrada con id: " + id));
    }
}
