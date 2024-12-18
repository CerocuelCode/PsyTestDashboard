package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.ResultadoTest_LogEntity;
import pe.com.psytest.service.ResultadoTest_LogService;

@Controller
@RequestMapping("/resultadotest_log")
public class ResultadoTest_LogController {
    @Autowired
    private ResultadoTest_LogService resultadoTestLogService;

    @GetMapping(value = {"", "/", "listar"})
    public String MostrarResultadoTestLog(Model model) {
        model.addAttribute("resultadosTests_Logs", resultadoTestLogService.findAll());
        return "admin/resultadoTest/listar_resultadoTestlog";
    }

    @ModelAttribute("resultadotest_log")
    public ResultadoTest_LogEntity ModeloResultadoTest_Log() {
        return new ResultadoTest_LogEntity();
    }
}
