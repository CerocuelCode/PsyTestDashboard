package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.ResultadoTestEntity;
import pe.com.psytest.service.DetalleEstudianteService;
import pe.com.psytest.service.ResultadoTestService;

@Controller
@RequestMapping("/resultadotest")
public class ResultadoTestController {
    @Autowired
    private ResultadoTestService resultadoTestService;

    @Autowired
    private DetalleEstudianteService detalleEstudianteService;


    @GetMapping(value = {"", "/", "listar"})
    public String MostrarResultadoTest(Model model) {
        model.addAttribute("estudiantes", detalleEstudianteService.findAllEstudianteActive());
        model.addAttribute("resultadosTests", resultadoTestService.findAll());
        return "admin/resultadoTest/listar_resultadoTest";
    }

    @ModelAttribute("resultadotest")
    public ResultadoTestEntity ModeloResultadoTest() {
        return new ResultadoTestEntity();
    }
}
