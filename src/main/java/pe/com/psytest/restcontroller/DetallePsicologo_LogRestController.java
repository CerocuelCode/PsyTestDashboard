package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.DetallePsicologo_LogEntity;
import pe.com.psytest.service.DetallePsicologo_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/detallepsicologo_log")
public class DetallePsicologo_LogRestController {
    @Autowired
    private DetallePsicologo_LogService detallePsicologoLogService;

    @GetMapping
    public List<DetallePsicologo_LogEntity> findAll() {
        return detallePsicologoLogService.findAll();
    }

    @GetMapping("/{id}")
    public DetallePsicologo_LogEntity findById(@PathVariable Integer id) {
        return detallePsicologoLogService.findById(id);
    }
}
