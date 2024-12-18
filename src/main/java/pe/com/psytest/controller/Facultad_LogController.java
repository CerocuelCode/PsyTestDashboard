package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Facultad_LogEntity;
import pe.com.psytest.service.Facultad_LogService;

@Controller
@RequestMapping("/facultad_log")
public class Facultad_LogController {
    @Autowired
    private Facultad_LogService facultadLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarFacultad_Log(Model model) {
        model.addAttribute("facultades_log", facultadLogService.findAll());
        return "admin/facultad/listar_facultadlog";
    }

    @ModelAttribute("facultad_log")
    public Facultad_LogEntity ModeloFacultad_Log() {
        return new Facultad_LogEntity();
    }
}
