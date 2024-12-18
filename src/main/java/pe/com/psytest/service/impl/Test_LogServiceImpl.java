package pe.com.psytest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.Test_LogEntity;
import pe.com.psytest.repository.Test_LogRepository;
import pe.com.psytest.service.Test_LogService;

import java.util.List;

@Service
public class Test_LogServiceImpl implements Test_LogService {
    @Autowired
    private Test_LogRepository test_logRepository;

    @Override
    public List<Test_LogEntity> findAll() {
        return test_logRepository.findAll();
    }

    @Override
    public Test_LogEntity findById(Integer id) {
        return test_logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test_LogEntity no encontrada con id: " + id));
    }
}
