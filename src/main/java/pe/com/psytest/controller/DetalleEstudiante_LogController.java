package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetalleEstudiante_LogEntity;
import pe.com.psytest.service.DetalleEstudiante_LogService;

import java.util.List;

@Controller
@RequestMapping("/detalleestudiante_log")
public class DetalleEstudiante_LogController {
    @Autowired
    private DetalleEstudiante_LogService detalleEstudianteLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarDetalleEstudiante_Log(Model model) {
        model.addAttribute("detallesEstudiantes_logs", detalleEstudianteLogService.findAll());
        return "admin/estudiante/listar_estudiantelog";
    }

    @ModelAttribute("detalleEstudiante_log")
    public DetalleEstudiante_LogEntity ModeloDetalleEstudiante_Log() {
        return new DetalleEstudiante_LogEntity();
    }
}
