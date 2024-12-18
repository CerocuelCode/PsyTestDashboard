package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.CarreraEntity;
import pe.com.psytest.entity.RolEntity;
import pe.com.psytest.repository.CarreraRepository;
import pe.com.psytest.service.CarreraService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CarreraServiceImpl implements CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Override
    public List<CarreraEntity> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    public List<CarreraEntity> findAllCarreraActive() {
        return carreraRepository.findAllCarreraActive();
    }

    @Override
    public List<CarreraEntity> findAllCarreraInactive() {
        return carreraRepository.findAllCarreraInactive();
    }

    @Override
    public CarreraEntity findById(Integer id) {
        return carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el id de la carrera: " + id));
    }

    @Override
    public CarreraEntity add(CarreraEntity c) {
        c.setFechaRegistro(LocalDate.now());
        c.setHoraModificacion(LocalTime.now());
        c.setFechaModificacion(LocalDate.now());
        return carreraRepository.save(c);
    }

    @Override
    public CarreraEntity update(CarreraEntity c) {
        CarreraEntity objcarrera = new CarreraEntity();
        BeanUtils.copyProperties(c, objcarrera);
        objcarrera.setHoraModificacion(LocalTime.now());
        objcarrera.setFechaModificacion(LocalDate.now());
        return carreraRepository.save(objcarrera);
    }

    @Override
    public CarreraEntity delete(CarreraEntity c) {
        CarreraEntity objcarrera = carreraRepository.findById(c.getId())
                .orElseThrow(() -> new RuntimeException("No se encontró una carrera con el ID: " + c.getId()));
        objcarrera.setEstado(false);
        return carreraRepository.save(objcarrera);
    }
}
