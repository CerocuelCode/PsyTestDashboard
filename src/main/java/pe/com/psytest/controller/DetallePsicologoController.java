package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetallePsicologoEntity;
import pe.com.psytest.service.DetallePsicologoService;
import pe.com.psytest.service.UsuarioService;

@Controller
@RequestMapping("/detallepsicologo")
public class DetallePsicologoController {
    @Autowired
    private DetallePsicologoService detallePsicologoService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarDetallePsicologo(Model model){
        model.addAttribute("detallespsicologos", detallePsicologoService.findAllPsicologoActive());
        return "admin/psicologo/listar_psicologo";
    }

    @GetMapping("/listarInactivos")
    public String MostrarDetallePsicologoInactivos(Model model){
        model.addAttribute("detallespsicologos", detallePsicologoService.findAllPsicologoInactive());
        return "admin/psicologo/listar_psicologo_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroPsicologo(Model model){
        model.addAttribute("usuarios", usuarioService.findPsicologosLibres());
        return "admin/psicologo/registro_psicologo";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarPsicologo(@PathVariable Integer id, Model model){
        model.addAttribute("usuarios", usuarioService.findAllUsuarioActive());
        model.addAttribute("detallespsicologos", detallePsicologoService.findById(id));
        return "admin/psicologo/actualizar_psicologo";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarDetallePsicologo(@PathVariable Integer id, Model model){
        DetallePsicologoEntity objDetallePsicologo = new DetallePsicologoEntity();
        objDetallePsicologo.setId(id);
        detallePsicologoService.delete(objDetallePsicologo);
        return "redirect:/detallepsicologo/listar";
    }

    @ModelAttribute("detallepsicologo")
    public DetallePsicologoEntity ModeloDetallePsicologo(){
        return new DetallePsicologoEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarDetallePsicologo(@ModelAttribute("detallepsicologo") DetallePsicologoEntity dp){
        detallePsicologoService.add(dp);
        return "redirect:/detallepsicologo/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarDetallePsicologo(@PathVariable Integer id, @ModelAttribute("detallepsicologo") DetallePsicologoEntity dp){
        detallePsicologoService.update(dp);
        return "redirect:/detallepsicologo/listar";
    }
}
