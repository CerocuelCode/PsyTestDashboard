package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.TipoTest_LogEntity;
import pe.com.psytest.repository.TipoTest_LogRepository;
import pe.com.psytest.service.TipoTest_LogService;

import java.util.List;

@Service
public class TipoTest_LogServiceImpl implements TipoTest_LogService {
    @Autowired
    private TipoTest_LogRepository tipoTest_LogRepository;

    @Override
    public List<TipoTest_LogEntity> findAll() {
        return tipoTest_LogRepository.findAll();
    }

    @Override
    public TipoTest_LogEntity findById(Integer id) {
        return tipoTest_LogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoTest_LogEntity no encontrada con id: " + id));
    }
}
