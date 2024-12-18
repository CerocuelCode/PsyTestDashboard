package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.CitaEntity;
import pe.com.psytest.repository.CitaRepository;
import pe.com.psytest.service.CitaService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<CitaEntity> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public List<CitaEntity> findAllCitaActive() {
        return citaRepository.findAllCitaActive();
    }

    @Override
    public List<CitaEntity> findAllCitaInactive() {
        return citaRepository.findAllCitaInactive();
    }

    @Override
    public List<CitaEntity> findAllCitaReservada() {
        return citaRepository.findAllCitaReservada();
    }


    @Override
    public CitaEntity findById(Integer id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CitaEntity no encontrada con id: " + id));
    }

    @Override
    public CitaEntity add(CitaEntity c) {
        c.setFechaRegistro(LocalDate.now());
        c.setHoraModificacion(LocalTime.now());
        c.setFechaModificacion(LocalDate.now());
        return citaRepository.save(c);
    }

    @Override
    public CitaEntity update(CitaEntity c) {
        CitaEntity objcita = new CitaEntity();
        BeanUtils.copyProperties(c, objcita);
        objcita.setHoraModificacion(LocalTime.now());
        objcita.setFechaModificacion(LocalDate.now());
        return citaRepository.save(objcita);
    }

    @Override
    public CitaEntity delete(CitaEntity c) {
        CitaEntity objcita = citaRepository.findById(c.getId())
                .orElseThrow(() -> new RuntimeException("No se encontro una cita con el ID: " + c.getId()));
        objcita.setEstado(false);
        return citaRepository.save(objcita);
    }
}
