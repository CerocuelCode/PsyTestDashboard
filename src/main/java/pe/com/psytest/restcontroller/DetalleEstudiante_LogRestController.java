package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.DetalleEstudiante_LogEntity;
import pe.com.psytest.service.DetalleEstudiante_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/detalleestudiante_log")
public class DetalleEstudiante_LogRestController {
    @Autowired
    private DetalleEstudiante_LogService detalleEstudianteLogService;

    @GetMapping
    public List<DetalleEstudiante_LogEntity> findAll() {
        return detalleEstudianteLogService.findAll();
    }

    @GetMapping("/{id}")
    public DetalleEstudiante_LogEntity findById(@PathVariable Integer id) {
        return detalleEstudianteLogService.findById(id);
    }
}
