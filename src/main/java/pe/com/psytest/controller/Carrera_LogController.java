package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Carrera_LogEntity;
import pe.com.psytest.service.Carrera_LogService;

@Controller
@RequestMapping("/carrera_log")
public class Carrera_LogController {
    @Autowired
    private Carrera_LogService carreraLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarCarrera_Log(Model model) {
        model.addAttribute("carreras_logs", carreraLogService.findAll());
        return "admin/carrera/listar_carreralog";
    }

    @ModelAttribute("carrera_log")
    public Carrera_LogEntity ModeloCarrera_Log() {
        return new Carrera_LogEntity();
    }
}
