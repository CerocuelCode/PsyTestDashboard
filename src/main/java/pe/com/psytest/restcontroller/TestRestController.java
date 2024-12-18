package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.TestEntity;
import pe.com.psytest.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestRestController {
    @Autowired
    private TestService testService;

    @GetMapping
    public List<TestEntity> findAll() {
        return testService.findAll();
    }

    @GetMapping( "/findAllTestActive")
    public List<TestEntity> findAllTestActive() {
        return testService.findAllTestActive();
    }

    @GetMapping( "/findAllTestInactive")
    public List<TestEntity> findAllTestInactive() {
        return testService.findAllTestInactive();
    }

    @GetMapping("/{id}")
    public TestEntity findById(@PathVariable Integer id) {
        return testService.findById(id);
    }

    //Regitrar --> POST
    @PostMapping
    public TestEntity add(@RequestBody TestEntity t) {
        return testService.add(t);
    }

    //Actualizar --> PUT
    @PutMapping("/{id}")
    public TestEntity update(@PathVariable Integer id, @RequestBody TestEntity t) {
        t.setId(id);
        return testService.update(t);
    }

    //Eliminar --> DElETE
    @DeleteMapping("/{id}")
    public TestEntity delete(@PathVariable Integer id) {
        TestEntity objfacultad = new TestEntity();
        objfacultad.setEstado(false);
        return testService.delete(TestEntity.builder().id(id).build());
    }
}
