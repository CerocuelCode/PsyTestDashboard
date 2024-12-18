package pe.com.psytest.controller;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetalleEstudianteEntity;
import pe.com.psytest.service.CarreraService;
import pe.com.psytest.service.DetalleEstudianteService;
import pe.com.psytest.service.UsuarioService;

@Controller
@RequestMapping("/detalleestudiante")
public class DetalleEstudianteController {
    @Autowired
    private DetalleEstudianteService detalleEstudianteService;

    @Autowired
    private CarreraService carreraService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarDetalleEstudiante(Model model) {
        model.addAttribute("detallesestudiantes", detalleEstudianteService.findAllEstudianteActive());
        return "admin/estudiante/listar_estudiante";
    }

    @GetMapping("/listarInactivos")
    public String MostrarDetalleEstudianteInactivos(Model model) {
        model.addAttribute("detallesestudiantes", detalleEstudianteService.findAllEstudianteInactive());
        return "admin/estudiante/listar_estudiante_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroEstudiante(Model model) {
        model.addAttribute("carreras", carreraService.findAllCarreraActive());
        model.addAttribute("usuarios", usuarioService.findEstudiantesLibres());
        return "admin/estudiante/registro_estudiante";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarEstudiante(@PathVariable Integer id, Model model) {
        model.addAttribute("carreras", carreraService.findAllCarreraActive());
        model.addAttribute("usuarios", usuarioService.findAllUsuarioActive());
        model.addAttribute("detallesestudiantes", detalleEstudianteService.findById(id));
        return "admin/estudiante/actualizar_estudiante";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDetalleEstudiante(@PathVariable Integer id, Model model) {
        DetalleEstudianteEntity objDetalleEstudiante = new DetalleEstudianteEntity();
        objDetalleEstudiante.setId(id);
        detalleEstudianteService.delete(objDetalleEstudiante);
        return "redirect:/detalleestudiante/listar";
    }

    @ModelAttribute("detalleestudiante")
    public DetalleEstudianteEntity ModeloDetalleEstudiante() {
        return new DetalleEstudianteEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarDetalleEstudiante(@ModelAttribute("detalleestudiante") DetalleEstudianteEntity de) {
        detalleEstudianteService.add(de);
        return "redirect:/detalleestudiante/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarDetalleEstudiante(@PathVariable Integer id, @ModelAttribute("detalleestudiante") DetalleEstudianteEntity de) {
        detalleEstudianteService.update(de);
        return "redirect:/detalleestudiante/listar";
    }

}
