package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.TestEntity;
import pe.com.psytest.repository.TestRepository;
import pe.com.psytest.service.TestService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<TestEntity> findAll() {
        return testRepository.findAll();
    }

    @Override
    public List<TestEntity> findAllTestActive() {
        return testRepository.findAllTestActive();
    }

    @Override
    public List<TestEntity> findAllTestInactive() {
        return testRepository.findAllTestInactive();
    }


    @Override
    public TestEntity findById(Integer id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test no encontrado con id: " + id));
    }

    @Override
    public TestEntity add(TestEntity t) {
        t.setFechaRegistro(LocalDate.now());
        t.setHoraModificacion(LocalTime.now());
        t.setFechaModificacion(LocalDate.now());
        return testRepository.save(t);
    }

    @Override
    public TestEntity update(TestEntity t) {
        TestEntity objtest = new TestEntity();
        BeanUtils.copyProperties(t, objtest);
        objtest.setHoraModificacion(LocalTime.now());
        objtest.setFechaModificacion(LocalDate.now());
        return testRepository.save(objtest);
    }

    @Override
    public TestEntity delete(TestEntity t) {
        TestEntity objtest = testRepository.findById(t.getId())
                .orElseThrow(() -> new RuntimeException("Test no encontrado con id: " + t.getId()));
        objtest.setEstado(false);
        return testRepository.save(objtest);
    }
}
