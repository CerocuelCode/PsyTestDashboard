package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.TipoTestEntity;
import pe.com.psytest.repository.TipoTestRepository;
import pe.com.psytest.service.TipotestService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TipoTestServiceImpl implements TipotestService {
    @Autowired
    private TipoTestRepository tipoTestRepository;

    @Override
    public List<TipoTestEntity> findAll() {
        return tipoTestRepository.findAll();
    }

    @Override
    public List<TipoTestEntity> findAllTipoTestActive() {
        return tipoTestRepository.findAllTipoTestActive();
    }

    @Override
    public List<TipoTestEntity> findAllTipoTestInactive() {
        return tipoTestRepository.findAllTipoTestInactive();
    }

    @Override
    public TipoTestEntity findById(Integer id) {
        return tipoTestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TipoTestEntity no encontrada con id: " + id));
    }

    @Override
    public TipoTestEntity add(TipoTestEntity tt) {
        tt.setFechaRegistro(LocalDate.now());
        tt.setHoraModificacion(LocalTime.now());
        tt.setFechaModificacion(LocalDate.now());
        return tipoTestRepository.save(tt);
    }

    @Override
    public TipoTestEntity update(TipoTestEntity tt) {
        TipoTestEntity objTipoTest = new TipoTestEntity();
        BeanUtils.copyProperties(tt, objTipoTest);
        objTipoTest.setHoraModificacion(LocalTime.now());
        objTipoTest.setFechaModificacion(LocalDate.now());
        return tipoTestRepository.save(tt);
    }

    @Override
    public TipoTestEntity delete(TipoTestEntity tt) {
        TipoTestEntity objTipoTest = tipoTestRepository.findById(tt.getId())
                .orElseThrow(() -> new RuntimeException("TipoTestEntity no encontrada con id: " + tt.getId()));
        objTipoTest.setEstado(false);
        return tipoTestRepository.save(objTipoTest);
    }
}
