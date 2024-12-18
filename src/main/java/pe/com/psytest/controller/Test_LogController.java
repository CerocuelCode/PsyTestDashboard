package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Test_LogEntity;
import pe.com.psytest.service.Test_LogService;

@Controller
@RequestMapping("/test_log")
public class Test_LogController {
    @Autowired
    private Test_LogService testLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarTest_Log(Model model) {
        model.addAttribute("tests_logs", testLogService.findAll());
        return "admin/test/listar_testlog";
    }

    @ModelAttribute("test_log")
    public Test_LogEntity ModeloTest_Log() {
        return new Test_LogEntity();
    }
}
