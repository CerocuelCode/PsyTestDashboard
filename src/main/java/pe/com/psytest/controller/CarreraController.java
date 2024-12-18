package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.CarreraEntity;
import pe.com.psytest.service.CarreraService;
import pe.com.psytest.service.FacultadService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @Autowired
    private FacultadService facultadService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarCarrera(Model model) {
        model.addAttribute("carreras", carreraService.findAllCarreraActive());
        return "admin/carrera/listar_carrera";
    }

    @GetMapping("/registro")
    public String FormularioRegistroCarrera(Model model) {
        model.addAttribute("facultades", facultadService.findAllFacultadActive());
        return "admin/carrera/registro_carrera";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarCarrera(@PathVariable Integer id, Model model) {
        model.addAttribute("facultades", facultadService.findAllFacultadActive());
        model.addAttribute("carreras", carreraService.findById(id));
        return "admin/carrera/actualizar_carrera";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarCarrera(@PathVariable Integer id, Model model) {
        CarreraEntity objcar = new CarreraEntity();
        objcar.setId(id);
        carreraService.delete(objcar);
        return "redirect:/carrera/listar";
    }

    @ModelAttribute("carrera")
    public CarreraEntity ModeloCarrera() {
        return new CarreraEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarCarrera(@ModelAttribute("carrera") CarreraEntity c) {
        carreraService.add(c);
        return "redirect:/carrera/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarCarrera(@PathVariable Integer id, @ModelAttribute("carrera") CarreraEntity c) {
        carreraService.update(c);
        return "redirect:/carrera/listar";
    }
}
