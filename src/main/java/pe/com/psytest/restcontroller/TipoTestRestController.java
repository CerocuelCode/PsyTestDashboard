package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.TipoTestEntity;
import pe.com.psytest.service.TipotestService;

import java.util.List;

@Controller
@RequestMapping("/api/tipo_test")
public class TipoTestRestController {
    @Autowired
    private TipotestService tipotestService;

    @GetMapping
    public List<TipoTestEntity> findAll() {
        return tipotestService.findAll();
    }

    @GetMapping("/findAllTipoTestActive")
    public List<TipoTestEntity> findAllTipoTestActive(){
        return tipotestService.findAllTipoTestActive();
    }

    @GetMapping("/findAllTipoTestInactive")
    public List<TipoTestEntity> findAllTipoTestInactive(){
        return tipotestService.findAllTipoTestInactive();
    }

    @GetMapping("/{id}")
    public TipoTestEntity findById(@PathVariable Integer id) {
        return tipotestService.findById(id);
    }

    //Registrar --> POST
    @PostMapping
    public TipoTestEntity add(@RequestBody TipoTestEntity tt) {
        return tipotestService.add(tt);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public TipoTestEntity update(@PathVariable Integer id, @RequestBody TipoTestEntity tt) {
        tt.setId(id);
        return tipotestService.update(tt);
    }

    //Eliminar --> DELETE
    @DeleteMapping("/{id}")
    public TipoTestEntity delete(@PathVariable Integer id) {
        TipoTestEntity objtipotest = new TipoTestEntity();
        objtipotest.setEstado(false);
        return tipotestService.delete(TipoTestEntity.builder().id(id).build());
    }
}
