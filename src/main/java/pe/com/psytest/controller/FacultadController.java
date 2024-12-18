package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.service.FacultadService;

@Controller
@RequestMapping("/facultad")
public class FacultadController {
    @Autowired
    private FacultadService facultadService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarFacultad(Model model) {
        model.addAttribute("facultades", facultadService.findAllFacultadActive());
        return "admin/facultad/listar_facultad";
    }

    @GetMapping("/registro")
    public String FormularioRegistroFacultad() {
        return "admin/facultad/registro_facultad";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarFacultad(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("facultades", facultadService.findById(id));
        return "admin/facultad/actualizar_facultad";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarFacultad(@PathVariable Integer id, Model modelo) {
        FacultadEntity objFacultad = new FacultadEntity();
        objFacultad.setId(id);
        facultadService.delete(objFacultad);
        return "redirect:/facultad/listar";
    }

    @ModelAttribute("facultad")
    public FacultadEntity ModeloFacultad() {
        return new FacultadEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarFacultad(@ModelAttribute("facultad") FacultadEntity f) {
        facultadService.add(f);
        return "redirect:/facultad/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarFacultad(@PathVariable Integer id, @ModelAttribute("facultad") FacultadEntity f) {
        facultadService.update(f);
        return "redirect:/facultad/listar";
    }
}
