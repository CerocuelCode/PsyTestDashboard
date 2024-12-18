package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.ResultadoTest_LogEntity;
import pe.com.psytest.service.ResultadoTest_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/resultadotest_log")
public class ResultadoTest_LogRestController {
    @Autowired
    private ResultadoTest_LogService resultadoTestLogService;

    @GetMapping
    public List<ResultadoTest_LogEntity> findAll(){
        return resultadoTestLogService.findAll();
    }

    @GetMapping("{id}")
    public ResultadoTest_LogEntity findById(@PathVariable Integer id){
        return resultadoTestLogService.findById(id);
    }
}
