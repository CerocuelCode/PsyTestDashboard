package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.FacultadEntity;
import pe.com.psytest.entity.RolEntity;
import pe.com.psytest.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarRol(Model model) {
        model.addAttribute("roles", rolService.findAllRolActive());
        return "admin/rol/listar_rol";
    }

    @GetMapping("/listarInactivos")
    public String MostrarRolInactivos(Model model) {
        model.addAttribute("roles", rolService.findAllRolInactive());
        return "admin/rol/listar_rol_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroRol() {
        return "admin/rol/registro_rol";
    }

    @GetMapping("/actualizar/{id}")
    public String MostrarActualizaRol(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("roles", rolService.findById(id));
        return "admin/rol/actualizar_rol";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarRol(@PathVariable Integer id, Model modelo) {
        RolEntity objrol = new RolEntity();
        objrol.setId(id);
        rolService.delete(objrol);
        return "redirect:/rol/listar";
    }

    @ModelAttribute("rol")
    public RolEntity ModeloRol() {
        return new RolEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarRol(@ModelAttribute("rol") RolEntity r) {
        rolService.add(r);
        return "redirect:/rol/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarRol(@PathVariable Integer id, @ModelAttribute("rol") RolEntity r) {
        rolService.update(r);
        return "redirect:/rol/listar";
    }
}
