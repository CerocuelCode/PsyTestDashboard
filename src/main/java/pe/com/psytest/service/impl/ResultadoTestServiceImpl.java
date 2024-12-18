package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.ResultadoTestEntity;
import pe.com.psytest.repository.ResultadoTestRepository;
import pe.com.psytest.service.ResultadoTestService;

import java.util.List;

@Service
public class ResultadoTestServiceImpl implements ResultadoTestService {
    @Autowired
    private ResultadoTestRepository resultadoTestRepository;

    @Override
    public List<ResultadoTestEntity> findAll() {
        return resultadoTestRepository.findAll();
    }

    @Override
    public ResultadoTestEntity findById(int id) {
        return resultadoTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResultadoTestEntity no encontrado con id: " + id));
    }
}
