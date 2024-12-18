package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.Usuario_LogEntity;
import pe.com.psytest.service.Usuario_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/usuario_log")
public class Usuario_LogRestController {
    @Autowired
    private Usuario_LogService usuarioLogService;

    @GetMapping
    public List<Usuario_LogEntity> findAll() {
        return usuarioLogService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario_LogEntity findById(@PathVariable Integer id) {
        return usuarioLogService.findById(id);
    }
}
