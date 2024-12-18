package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.TipoTestEntity;
import pe.com.psytest.service.TipotestService;

@Controller
@RequestMapping("/tipo_test")
public class TipoTestController {
    @Autowired
    private TipotestService tipotestService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarTipoTest(Model model){
        model.addAttribute("tipos_tests", tipotestService.findAllTipoTestActive());
        return "admin/tipotest/listar_tipotest";
    }

    @GetMapping("/registro")
    public String FormularioRegistroTipoTest(){
        return "admin/tipotest/registro_tipotest";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarTipoTest(@PathVariable Integer id, Model model){
        model.addAttribute("tipos_tests", tipotestService.findById(id));
        return "admin/tipotest/registro_tipotest";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarTipoTest(@PathVariable Integer id, Model model){
        TipoTestEntity objTipoTest = new TipoTestEntity();
        objTipoTest.setId(id);
        tipotestService.delete(objTipoTest);
        return "redirect:/tipo_test/listar";
    }

    @ModelAttribute("tipo_test")
    public TipoTestEntity ModeloTipoTest(){
        return new TipoTestEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarTipoTest(@ModelAttribute("tipo_test") TipoTestEntity tp){
        tipotestService.add(tp);
        return "redirect:/tipo_test/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarTipoTest(@PathVariable Integer id, @ModelAttribute("tipo_test") TipoTestEntity tp){
        tipotestService.update(tp);
        return "redirect:/tipo_test/listar";
    }
}
