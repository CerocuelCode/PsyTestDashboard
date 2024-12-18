package pe.com.psytest.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.psytest.entity.DetalleEstudianteEntity;
import pe.com.psytest.entity.DetallePsicologoEntity;
import pe.com.psytest.repository.DetalleEstudianteRepository;
import pe.com.psytest.service.DetalleEstudianteService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DetalleEstudianteServiceImpl implements DetalleEstudianteService {
    @Autowired
    private DetalleEstudianteRepository detalleEstudianteRepository;

    @Override
    public List<DetalleEstudianteEntity> findAll() {
        return detalleEstudianteRepository.findAll();
    }

    @Override
    public List<DetalleEstudianteEntity> findAllEstudianteActive() {
        return detalleEstudianteRepository.findAllEstudianteActive();
    }

    @Override
    public List<DetalleEstudianteEntity> findAllEstudianteInactive() {
        return detalleEstudianteRepository.findAllEstudianteInactive();
    }

    @Override
    public DetalleEstudianteEntity findById(Integer id) {
        return detalleEstudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el id de la estudiante: " + id));
    }

    @Override
    public DetalleEstudianteEntity add(DetalleEstudianteEntity de) {
        de.setFechaRegistro(LocalDate.now());
        de.setHoraModificacion(LocalTime.now());
        de.setFechaModificacion(LocalDate.now());
        de.setFoto("https://i.pinimg.com/236x/1a/d8/e6/1ad8e6267b2af6650cb50e7a57d8c633.jpg");
        return detalleEstudianteRepository.save(de);
    }

    @Override
    public DetalleEstudianteEntity update(DetalleEstudianteEntity de) {
        DetalleEstudianteEntity objDetalleEstudiante = new DetalleEstudianteEntity();
        BeanUtils.copyProperties(de, objDetalleEstudiante);
        objDetalleEstudiante.setFoto("https://i.pinimg.com/236x/1a/d8/e6/1ad8e6267b2af6650cb50e7a57d8c633.jpg");
        objDetalleEstudiante.setHoraModificacion(LocalTime.now());
        objDetalleEstudiante.setFechaModificacion(LocalDate.now());
        return detalleEstudianteRepository.save(objDetalleEstudiante);
    }

    @Override
    public DetalleEstudianteEntity delete(DetalleEstudianteEntity de) {
        DetalleEstudianteEntity objDetalleEstudiante = detalleEstudianteRepository.findById(de.getId())
                .orElseThrow(() -> new RuntimeException("No se encontro el id: " + de.getId()));

        // Validaciones adicionales
        if (objDetalleEstudiante.getUsuario() == null || objDetalleEstudiante.getCarrera() == null) {
            throw new RuntimeException("Usuario o Carrera asociados no son válidos");
        }

        objDetalleEstudiante.setEstado(false);
        return detalleEstudianteRepository.save(objDetalleEstudiante);
    }
}
