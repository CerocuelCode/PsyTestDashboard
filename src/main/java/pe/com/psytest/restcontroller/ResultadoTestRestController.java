package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.ResultadoTestEntity;
import pe.com.psytest.service.ResultadoTestService;

import java.util.List;

@RestController
@RequestMapping("/api/resultadotest")
public class ResultadoTestRestController {
    @Autowired
    private ResultadoTestService resultadoTestService;

    @GetMapping
    public List<ResultadoTestEntity> findAll() {
        return resultadoTestService.findAll();
    }

    @GetMapping("/{id}")
    public ResultadoTestEntity findById(@PathVariable int id) {
        return resultadoTestService.findById(id);
    }
}
