package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Rol_LogEntity;
import pe.com.psytest.service.Rol_LogService;

@Controller
@RequestMapping("/rol_log")
public class Rol_LogController {
    @Autowired
    private Rol_LogService rolLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarRol_Log(Model model) {
        model.addAttribute("rols_logs", rolLogService.findAll());
        return "admin/rol/listar_rollog";
    }

    @ModelAttribute("rol_log")
    public Rol_LogEntity ModeloRol_Log() {
        return new Rol_LogEntity();
    }
}
