package pe.com.psytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.psytest.entity.Usuario_LogEntity;
import pe.com.psytest.service.Usuario_LogService;

@Controller
@RequestMapping("/usuario_log")
public class Usuario_LogController {
    @Autowired
    private Usuario_LogService usuarioLogService;

    @RequestMapping(value = {"", "/", "listar"})
    public String MostrarUsuario_Log(Model model) {
        model.addAttribute("usuarios_logs", usuarioLogService.findAll());
        return "admin/usuario/listar_usuariolog";
    }

    @ModelAttribute("usuario_log")
    public Usuario_LogEntity ModeloUsuarioLog() {
        return new Usuario_LogEntity();
    }
}
