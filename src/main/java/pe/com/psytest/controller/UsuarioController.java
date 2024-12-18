package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.com.psytest.entity.DetalleEstudianteEntity;
import pe.com.psytest.entity.UsuarioEntity;
import pe.com.psytest.service.DetalleEstudianteService;
import pe.com.psytest.service.RolService;
import pe.com.psytest.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarUsuario(Model model) {
        model.addAttribute("roles", rolService.findAllRolActive());
        model.addAttribute("usuarios", usuarioService.findAllUsuarioActive());
        return "admin/usuario/listar_usuario";
    }

    @GetMapping("/listarInactivos")
    public String MostrarUsuarioInactive(Model model) {
        model.addAttribute("roles", rolService.findAllRolActive());
        model.addAttribute("usuarios", usuarioService.findAllUsuarioInactive());
        return "admin/usuario/listar_usuario_inactivo";
    }

    @GetMapping("/registro")
    public String FormularioRegistroUsuario(Model model) {
        model.addAttribute("roles", rolService.findAllRolActive());
        return "admin/usuario/registro_usuario";
    }

    @GetMapping("/actualizar/{id}")
    public String FormularioActualizarUsuario(@PathVariable Integer id, Model model) {
        model.addAttribute("roles", rolService.findAllRolActive());
        model.addAttribute("usuarios", usuarioService.findById(id));
        return "admin/usuario/actualizar_usuario";
    }

    @GetMapping("/eliminar/{id}")
    public String EliminarUsuario(@PathVariable Integer id, Model model) {
        UsuarioEntity objUsu = new UsuarioEntity();
        objUsu.setId(id);
        usuarioService.delete(objUsu);
        return "redirect:/usuario/listar";
    }

    @ModelAttribute("usuario")
    public UsuarioEntity ModeloUsuario() {
        return new UsuarioEntity();
    }

    @PostMapping("/registrar")
    public String RegistrarUsuario(@ModelAttribute("usuario") UsuarioEntity u) {
        usuarioService.add(u);
        return "redirect:/usuario/listar";
    }

    @PostMapping("/actualizar/{id}")
    public String ActualizarUsuario(@PathVariable Integer id, @ModelAttribute("usuario") UsuarioEntity u) {
        usuarioService.update(u);
        return "redirect:/usuario/listar";
    }

}
