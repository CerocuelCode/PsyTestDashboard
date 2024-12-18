package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.CitaEntity;
import pe.com.psytest.service.CitaService;

import java.util.List;

@Controller
@RequestMapping("/api/cita")
public class CitaRestController {
    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<CitaEntity> findAll() {
        return citaService.findAll();
    }

    @GetMapping("/findAllCitaActive")
    public List<CitaEntity> findAllCitaActive(){
        return citaService.findAllCitaActive();
    }

    @GetMapping("/findAllCitaInactive")
    public List<CitaEntity> findAllCitaInactive(){
        return citaService.findAllCitaInactive();
    }

    @GetMapping("/findAllCitaReservada")
    public List<CitaEntity> findAllCitaReservada(){
        return citaService.findAllCitaReservada();
    }

    @GetMapping("/{id}")
    public CitaEntity findById(@PathVariable Integer id) {
        return citaService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public CitaEntity add(@RequestBody CitaEntity c) {
        return citaService.add(c);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public CitaEntity update(@PathVariable Integer id, @RequestBody CitaEntity c) {
        c.setId(id);
        return citaService.update(c);
    }

    //Eliminar --> DELETE
    @DeleteMapping("/{id}")
    public CitaEntity delete(@PathVariable Integer id) {
        CitaEntity objcita = new CitaEntity();
        objcita.setEstado(false);
        return citaService.delete(CitaEntity.builder().id(id).build());
    }
}
