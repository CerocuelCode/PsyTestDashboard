package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.DetalleEstudianteEntity;
import pe.com.psytest.entity.DetallePsicologoEntity;
import pe.com.psytest.repository.DetallePsicologoRepository;
import pe.com.psytest.service.DetallePsicologoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DetallePsicologoServiceImpl implements DetallePsicologoService {
    @Autowired
    private DetallePsicologoRepository detallePsicologoRepository;

    @Override
    public List<DetallePsicologoEntity> findAll() {
        return detallePsicologoRepository.findAll();
    }

    @Override
    public List<DetallePsicologoEntity> findAllPsicologoActive() {
        return detallePsicologoRepository.findAllPsicologoActive();
    }

    @Override
    public List<DetallePsicologoEntity> findAllPsicologoInactive() {
        return detallePsicologoRepository.findAllPsicologoInactive();
    }

    @Override
    public DetallePsicologoEntity findById(Integer id) {
        return detallePsicologoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el id: " + id));
    }

    @Override
    public DetallePsicologoEntity add(DetallePsicologoEntity dp) {
        dp.setFechaRegistro(LocalDate.now());
        dp.setHoraModificacion(LocalTime.now());
        dp.setFechaModificacion(LocalDate.now());
        dp.setFoto("https://i.pinimg.com/236x/1a/d8/e6/1ad8e6267b2af6650cb50e7a57d8c633.jpg");
        return detallePsicologoRepository.save(dp);
    }

    @Override
    public DetallePsicologoEntity update(DetallePsicologoEntity dp) {
        DetallePsicologoEntity objDetallePsicologo = new DetallePsicologoEntity();
        BeanUtils.copyProperties(dp, objDetallePsicologo);
        objDetallePsicologo.setFoto("https://i.pinimg.com/236x/1a/d8/e6/1ad8e6267b2af6650cb50e7a57d8c633.jpg");
        objDetallePsicologo.setHoraModificacion(LocalTime.now());
        objDetallePsicologo.setFechaModificacion(LocalDate.now());
        return detallePsicologoRepository.save(objDetallePsicologo);
    }

    @Override
    public DetallePsicologoEntity delete(DetallePsicologoEntity dp) {
        DetallePsicologoEntity objDetallePsicologo = detallePsicologoRepository.findById(dp.getId())
                .orElseThrow(() -> new RuntimeException("No se encontro el id: " + dp.getId()));
        objDetallePsicologo.setEstado(false);
        return detallePsicologoRepository.save(objDetallePsicologo);
    }
}
