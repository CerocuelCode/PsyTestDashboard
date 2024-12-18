package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Cita_LogEntity;
import pe.com.psytest.service.Cita_LogService;

@Controller
@RequestMapping("/cita_log")
public class Cita_LogController {
    @Autowired
    private Cita_LogService citaLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarCita_Log(Model model){
        model.addAttribute("citas_logs", citaLogService.findAll());
        return "admin/cita/listar_citalog";
    }

    @ModelAttribute("cita_log")
    public Cita_LogEntity ModeloCita_Log(){
        return new Cita_LogEntity();
    }
}
