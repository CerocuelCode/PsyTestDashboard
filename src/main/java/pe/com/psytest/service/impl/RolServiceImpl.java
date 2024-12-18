package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.RolEntity;
import pe.com.psytest.repository.RolRepository;
import pe.com.psytest.service.RolService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<RolEntity> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public List<RolEntity> findAllRolActive() {
        return rolRepository.findAllRolActive();
    }

    @Override
    public List<RolEntity> findAllRolInactive() {
        return rolRepository.findAllRolInactive();
    }

    @Override
    public RolEntity findById(Integer id) {
        return rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + id));
    }

    @Override
    public RolEntity add(RolEntity r) {
        r.setFechaRegistro(LocalDate.now());
        r.setHoraModificacion(LocalTime.now());
        r.setFechaModificacion(LocalDate.now());
        return rolRepository.save(r);
    }

    @Override
    public RolEntity update(RolEntity r) {
        RolEntity objrol = new RolEntity();
        BeanUtils.copyProperties(r, objrol);
        objrol.setHoraModificacion(LocalTime.now());
        objrol.setFechaModificacion(LocalDate.now());
        return rolRepository.save(objrol);
    }

    @Override
    public RolEntity delete(RolEntity r) {
        RolEntity objrol = rolRepository.findById(r.getId())
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado con id: " + r.getId()));
        objrol.setEstado(false);
        return rolRepository.save(objrol);
    }
}
