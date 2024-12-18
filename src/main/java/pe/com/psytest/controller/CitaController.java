package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.CitaEntity;
import pe.com.psytest.service.CitaService;
import pe.com.psytest.service.DetalleEstudianteService;
import pe.com.psytest.service.DetallePsicologoService;


@Controller
@RequestMapping("/cita")
public class CitaController {
    @Autowired
    private CitaService citaService;

    @Autowired
    private DetallePsicologoService detallePsicologoService;

    @Autowired
    private DetalleEstudianteService detalleEstudianteService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarCita(Model model) {
        model.addAttribute("psicologos", detallePsicologoService.findAllPsicologoActive());
        model.addAttribute("estudiantes", detalleEstudianteService.findAllEstudianteActive());
        model.addAttribute("citas", citaService.findAllCitaActive());
        return "admin/cita/listar_cita";
    }

    @GetMapping("/listarInactivos")
    public String MostrarCitaInactivos(Model model) {
        model.addAttribute("psicologos", detallePsicologoService.findAllPsicologoActive());
        model.addAttribute("estudiantes", detalleEstudianteService.findAllEstudianteActive());
        model.addAttribute("citas", citaService.findAllCitaInactive());
        return "admin/cita/listar_cita_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroCita(Model model) {
        model.addAttribute("psicologos", detallePsicologoService.findAllPsicologoActive());
        model.addAttribute("estudiantes", detalleEstudianteService.findAllEstudianteActive());
        model.addAttribute("citas", citaService.findAllCitaActive());
        return "admin/cita/registro_cita";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarCita(@PathVariable Integer id, Model model) {
        model.addAttribute("psicologos", detallePsicologoService.findAllPsicologoActive());
        model.addAttribute("estudiantes", detalleEstudianteService.findAllEstudianteActive());
        model.addAttribute("citas", citaService.findById(id));
        return "admin/cita/actualizar_cita";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarCita(@PathVariable Integer id, Model model){
        CitaEntity objCita = new CitaEntity();
        objCita.setId(id);
        citaService.delete(objCita);
        return "redirect:/cita/listar";
    }

    @ModelAttribute("cita")
    public CitaEntity ModeloCita() {
        return new CitaEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarCita(@ModelAttribute("cita") CitaEntity c) {
        citaService.add(c);
        return "redirect:/cita/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarCita(@PathVariable Integer id, @ModelAttribute("cita") CitaEntity c) {
        citaService.update(c);
        return "redirect:/cita/listar";
    }
}
