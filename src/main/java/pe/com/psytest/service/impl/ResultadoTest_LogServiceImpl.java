package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.ResultadoTest_LogEntity;
import pe.com.psytest.repository.ResultadoTest_LogRepository;
import pe.com.psytest.service.ResultadoTest_LogService;

import java.util.List;

@Service
public class ResultadoTest_LogServiceImpl implements ResultadoTest_LogService {
    @Autowired
    private ResultadoTest_LogRepository resultadoTest_LogRepository;

    @Override
    public List<ResultadoTest_LogEntity> findAll() {
        return resultadoTest_LogRepository.findAll();
    }

    @Override
    public ResultadoTest_LogEntity findById(Integer id) {
        return resultadoTest_LogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ResultadoTest_LogEntity no encontrado con id: " + id));
    }
}
