package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.entity.Facultad_LogEntity;
import pe.com.psytest.service.Facultad_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/facultad_log")
public class Facultad_LogRestController {
    @Autowired
    private Facultad_LogService facultadLogService;

    @GetMapping
    public List<Facultad_LogEntity> findAll() {
        return facultadLogService.findAll();
    }

    @GetMapping("/{id}")
    public Facultad_LogEntity findById(@PathVariable Integer id) {
        return facultadLogService.findById(id);
    }
}
