package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.repository.FacultadRepository;
import pe.com.psytest.service.FacultadService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    @Override
    public List<FacultadEntity> findAll() {
        return facultadRepository.findAll();
    }

    @Override
    public List<FacultadEntity> findAllFacultadActive() {
        return facultadRepository.findAllFacultadActive();
    }

    @Override
    public List<FacultadEntity> findAllFacultadInactive() {
        return facultadRepository.findAllFacultadInactive();
    }


    @Override
    public FacultadEntity findById(Integer id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada con id: " + id));
    }

    @Override
    public FacultadEntity add(FacultadEntity f) {
        f.setFechaRegistro(LocalDate.now());
        f.setHoraModificacion(LocalTime.now());
        f.setFechaModificacion(LocalDate.now());
        return facultadRepository.save(f);
    }

    @Override
    public FacultadEntity update(FacultadEntity f) {
        FacultadEntity objfacultad = new FacultadEntity();
        BeanUtils.copyProperties(f, objfacultad);
        objfacultad.setHoraModificacion(LocalTime.now());
        objfacultad.setFechaModificacion(LocalDate.now());
        return facultadRepository.save(objfacultad);
    }

    @Override
    public FacultadEntity delete(FacultadEntity f) {
        FacultadEntity objfacultad = facultadRepository.findById(f.getId())
                .orElseThrow(() -> new RuntimeException("No se encontro una facultad con el ID: " + f.getId()));
        objfacultad.setEstado(false);
        return facultadRepository.save(objfacultad);
    }
}
