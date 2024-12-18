package pe.com.psytest.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.psytest.entity.Test_LogEntity;
import pe.com.psytest.service.Test_LogService;

import java.util.List;

@RestController
@RequestMapping("/api/test_log")
public class Test_LogRestController {
    @Autowired
    private Test_LogService testLogService;

    @GetMapping
    public List<Test_LogEntity> findAll() {
        return testLogService.findAll();
    }

    @GetMapping("/{id}")
    public Test_LogEntity findById(@PathVariable Integer id) {
        return testLogService.findById(id);
    }
}
