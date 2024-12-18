package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.CarreraEntity;
import pe.com.psytest.service.CarreraService;

import java.util.List;

@RestController
@RequestMapping("/api/carrera")
public class CarreraRestController {
    @Autowired
    private CarreraService carreraService;

    @GetMapping
    public List<CarreraEntity> findAll() {
        return carreraService.findAll();
    }

    @GetMapping("/findAllCarreraActive")
    public List<CarreraEntity> findAllCarreraActive() {
        return carreraService.findAllCarreraActive();
    }

    @GetMapping("/findAllCarreraInactive")
    public List<CarreraEntity> findAllCarreraInactive() {
        return carreraService.findAllCarreraInactive();
    }

    @GetMapping("/{id}")
    public CarreraEntity findById(@PathVariable Integer id) {
        return carreraService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public CarreraEntity add(@RequestBody CarreraEntity c) {
        return carreraService.add(c);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public CarreraEntity update(@PathVariable Integer id, @RequestBody CarreraEntity c) {
        c.setId(id);
        return carreraService.update(c);
    }

    //Eliminar --> DELETE
    @DeleteMapping("/{id}")
    public CarreraEntity delete(@PathVariable Integer id) {
        CarreraEntity objcarrera = new CarreraEntity();
        objcarrera.setEstado(false);
        return carreraService.delete(CarreraEntity.builder().id(id).build());
    }
}
