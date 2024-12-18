package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.Cita_LogEntity;
import pe.com.psytest.service.Cita_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/cita_log")
public class Cita_LogRestController {
    @Autowired
    private Cita_LogService citaLogService;

    @GetMapping
    public List<Cita_LogEntity> findAll() {
        return citaLogService.findAll();
    }

    @GetMapping("{id}")
    public Cita_LogEntity findById(@PathVariable Integer id) {
        return citaLogService.findById(id);
    }
}
