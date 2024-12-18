package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.UsuarioEntity;
import pe.com.psytest.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping( "/findAllUsuarioActive")
    public List<UsuarioEntity> findAllUsuarioActive() {
        return usuarioService.findAllUsuarioActive();
    }

    @GetMapping( "/findAllUsuarioInactive")
    public List<UsuarioEntity> findAllUsuarioInactive() {
        return usuarioService.findAllUsuarioInactive();
    }

    @GetMapping("/findEstudiantesLibres")
    public List<UsuarioEntity> findEstudiantesLibres() {
        return usuarioService.findEstudiantesLibres();
    }

    @GetMapping("/findPsicologosLibres")
    public List<UsuarioEntity> findPsicologosLibres() {
        return usuarioService.findPsicologosLibres();
    }

    @GetMapping("/{id}")
    public UsuarioEntity findById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public UsuarioEntity add(@RequestBody UsuarioEntity u) {
        return usuarioService.add(u);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public UsuarioEntity update(@PathVariable Integer id, @RequestBody UsuarioEntity u) {
        u.setId(id);
        return usuarioService.update(u);
    }

    //Eliminar --> ELIMINAR
    @DeleteMapping("/{id}")
    public UsuarioEntity delete(@PathVariable Integer id) {
        UsuarioEntity objusuario = new UsuarioEntity();
        objusuario.setEstado(false);
        return usuarioService.delete(UsuarioEntity.builder().id(id).build());
    }

}
