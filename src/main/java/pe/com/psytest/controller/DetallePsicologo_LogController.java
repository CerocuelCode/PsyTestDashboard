package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.DetallePsicologo_LogEntity;
import pe.com.psytest.service.DetallePsicologo_LogService;

@Controller
@RequestMapping("/detallepsicologo_log")
public class DetallePsicologo_LogController {
    @Autowired
    private DetallePsicologo_LogService detallePsicologoLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarDetallePsicologo_Log(Model model){
        model.addAttribute("detallesPsicologos_logs", detallePsicologoLogService.findAll());
        return "admin/psicologo/listar_psicologolog";
    }

    @ModelAttribute("detallePsicologo_log")
    public DetallePsicologo_LogEntity ModeloDetallePsicologo_Log(){
        return new DetallePsicologo_LogEntity();
    }
}
