package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.RolEntity;
import pe.com.psytest.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
public class RolRestController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolEntity> findAll() {
        return rolService.findAll();
    }

    @GetMapping("/findAllRolActive")
    public List<RolEntity> findAllRolActive() {
        return rolService.findAllRolActive();
    }

    @GetMapping("/findAllRolInactive")
    public List<RolEntity> findAllRolInactive() {
        return rolService.findAllRolInactive();
    }

    @GetMapping("/{id}")
    public RolEntity findById(@PathVariable Integer id) {
        return rolService.findById(id);
    }

    //Regitrar --> POST
    @PostMapping
    public RolEntity add(@RequestBody RolEntity r) {
        return rolService.add(r);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public RolEntity update(@PathVariable Integer id, @RequestBody RolEntity r) {
        r.setId(id);
        return rolService.update(r);
    }

    //Eliminar --> DElETE
    @DeleteMapping("/{id}")
    public RolEntity delete(@PathVariable Integer id) {
        RolEntity objRol = new RolEntity();
        objRol.setEstado(false);
        return rolService.delete(RolEntity.builder().id(id).build());
    }
}
