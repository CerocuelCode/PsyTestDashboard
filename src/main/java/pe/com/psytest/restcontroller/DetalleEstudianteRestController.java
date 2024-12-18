package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetalleEstudianteEntity;
import pe.com.psytest.service.DetalleEstudianteService;

import java.util.List;

@RestController
@RequestMapping("/api/detalleestudiante")
public class DetalleEstudianteRestController {
    @Autowired
    private DetalleEstudianteService detalleEstudianteService;

    @GetMapping
    public List<DetalleEstudianteEntity> findAll() {
        return detalleEstudianteService.findAll();
    }

    @GetMapping("/findAllEstudianteActive")
    public List<DetalleEstudianteEntity> findAllEstudianteActive() {
        return detalleEstudianteService.findAllEstudianteActive();
    }

    @GetMapping("/findAllEstudianteInactive")
    public List<DetalleEstudianteEntity> findAllEstudianteInactive() {
        return detalleEstudianteService.findAllEstudianteInactive();
    }

    @GetMapping("/{id}")
    public DetalleEstudianteEntity findById(@PathVariable Integer id) {
        return detalleEstudianteService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public DetalleEstudianteEntity save(@RequestBody DetalleEstudianteEntity de) {
        return detalleEstudianteService.add(de);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public DetalleEstudianteEntity update(@PathVariable Integer id, @RequestBody DetalleEstudianteEntity de) {
        de.setId(id);
        return detalleEstudianteService.update(de);
    }

    //Eliminar --> DELETE
    @DeleteMapping("/{id}")
    public DetalleEstudianteEntity delete(@PathVariable Integer id) {
        DetalleEstudianteEntity objDetalleEstudiante = new DetalleEstudianteEntity();
        objDetalleEstudiante.setEstado(false);
        return detalleEstudianteService.delete(DetalleEstudianteEntity.builder().id(id).build());
    }

}
