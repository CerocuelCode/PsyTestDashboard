package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.entity.TestEntity;
import pe.com.psytest.service.TestService;
import pe.com.psytest.service.TipotestService;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private TipotestService tipotestService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarTest(Model model) {
        model.addAttribute("tests", testService.findAllTestActive());
        return "admin/test/listar_test";
    }

    @GetMapping("/listarInactivos")
    public String MostrarTestInactivo(Model model) {
        model.addAttribute("tests", testService.findAllTestInactive());
        return "admin/test/listar_test_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroTest(Model model) {
        model.addAttribute("tipostest", tipotestService.findAllTipoTestActive());
        return "admin/test/registro_test";
    }

    @GetMapping("/actualizar/{id}")
    public String MostrarActualizaTest(@PathVariable Integer id, Model model) {
        model.addAttribute("tipostest", tipotestService.findAllTipoTestActive());
        model.addAttribute("tests", testService.findById(id));
        return "admin/test/actualizar_test";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarTest(@PathVariable Integer id, Model modelo) {
        TestEntity objtest = new TestEntity();
        objtest.setId(id);
        testService.delete(objtest);
        return "redirect:/test/listar";
    }

    @ModelAttribute("test")
    public TestEntity ModeloTest() {
        return new TestEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarTest(@ModelAttribute("test") TestEntity t) {
        testService.add(t);
        return "redirect:/test/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarTest(@PathVariable Integer id, @ModelAttribute("test") TestEntity t) {
        testService.update(t);
        return "redirect:/test/listar";
    }
}
