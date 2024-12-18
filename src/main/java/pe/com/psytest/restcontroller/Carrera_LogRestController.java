package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.Carrera_LogEntity;
import pe.com.psytest.service.Carrera_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/carrera_log")
public class Carrera_LogRestController {
    @Autowired
    private Carrera_LogService carreraLogService;

    @GetMapping
    public List<Carrera_LogEntity> findAll() {
        return carreraLogService.findAll();
    }

    @GetMapping("/{id}")
    public Carrera_LogEntity findById(@PathVariable Integer id) {
        return carreraLogService.findById(id);
    }
}
