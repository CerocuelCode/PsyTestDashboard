package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Usuario_LogEntity;
import pe.com.psytest.repository.Usuario_LogRepository;
import pe.com.psytest.service.Usuario_LogService;

import java.util.List;

@Service
public class Usuario_LogServiceImpl implements Usuario_LogService {
    @Autowired
    private Usuario_LogRepository usuario_logRepository;

    @Override
    public List<Usuario_LogEntity> findAll() {
        return usuario_logRepository.findAll();
    }

    @Override
    public Usuario_LogEntity findById(Integer id) {
        return usuario_logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario_LogEntity no encontrada con id: " + id));
    }
}
