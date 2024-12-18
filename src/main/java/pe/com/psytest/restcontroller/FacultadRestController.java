package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.service.FacultadService;

import java.util.List;

@RestController
@RequestMapping("/api/facultad")
public class FacultadRestController {
    @Autowired
    private FacultadService facultadService;

    @GetMapping
    public List<FacultadEntity> findAll() {
        return facultadService.findAll();
    }

    @GetMapping("/findAllFacultadActive")
    public List<FacultadEntity> findAllFacultadActive() {
        return facultadService.findAllFacultadActive();
    }

    @GetMapping("/findAllFacultadInactive")
    public List<FacultadEntity> findAllFacultadInactive() {
        return facultadService.findAllFacultadInactive();
    }

    @GetMapping("/{id}")
    public FacultadEntity findById(@PathVariable Integer id) {
        return facultadService.findById(id);
    }

    //Regitrar --> POST
    @PostMapping
    public FacultadEntity add(@RequestBody FacultadEntity f) {
        return facultadService.add(f);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public FacultadEntity update(@PathVariable Integer id, @RequestBody FacultadEntity f) {
        f.setId(id);
        return facultadService.update(f);
    }

    //Eliminar --> DElETE
    @DeleteMapping("/{id}")
    public FacultadEntity delete(@PathVariable Integer id) {
        FacultadEntity objfacultad = new FacultadEntity();
        objfacultad.setEstado(false);
        return facultadService.delete(FacultadEntity.builder().id(id).build());
    }
}
