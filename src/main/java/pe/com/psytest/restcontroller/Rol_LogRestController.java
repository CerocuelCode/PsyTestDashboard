package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.Rol_LogEntity;
import pe.com.psytest.service.Rol_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/rol_log")
public class Rol_LogRestController {
    @Autowired
    private Rol_LogService rolLogService;

    @GetMapping
    public List<Rol_LogEntity> findAll() {
        return rolLogService.findAll();
    }

    @GetMapping("/{id}")
    public Rol_LogEntity findById(@PathVariable Integer id) {
        return rolLogService.findById(id);
    }
}
