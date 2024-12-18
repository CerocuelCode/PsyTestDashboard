package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetallePsicologoEntity;
import pe.com.psytest.service.DetallePsicologoService;

import java.util.List;

@RestController
@RequestMapping("/api/detallepsicologo")
public class DetallePsicologoRestController {
    @Autowired
    private DetallePsicologoService detallePsicologoService;

    @GetMapping
    public List<DetallePsicologoEntity> findAll() {
        return detallePsicologoService.findAll();
    }

    @GetMapping( "/findAllPsicologoActive")
    public List<DetallePsicologoEntity> findAllPsicologoActive() {
        return detallePsicologoService.findAllPsicologoActive();
    }

    @GetMapping( "/findAllPsicologoInactive")
    public List<DetallePsicologoEntity> findAllPsicologoInactive() {
        return detallePsicologoService.findAllPsicologoInactive();
    }

    @GetMapping("/{id}")
    public DetallePsicologoEntity findById(@PathVariable Integer id) {
        return detallePsicologoService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public DetallePsicologoEntity save(@RequestBody DetallePsicologoEntity dp) {
        return detallePsicologoService.add(dp);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public DetallePsicologoEntity update(@PathVariable Integer id, @RequestBody DetallePsicologoEntity dp) {
        dp.setId(id);
        return detallePsicologoService.update(dp);
    }

    //Eliminar --> DELETE
    @DeleteMapping("/{id}")
    public DetallePsicologoEntity delete(@PathVariable Integer id) {
        DetallePsicologoEntity objDetallePsicologo = new DetallePsicologoEntity();
        objDetallePsicologo.setEstado(false);
        return detallePsicologoService.delete(DetallePsicologoEntity.builder().id(id).build());
    }
}
