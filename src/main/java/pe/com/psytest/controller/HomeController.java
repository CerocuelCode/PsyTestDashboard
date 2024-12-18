package pe.com.psytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index"; // El archivo principal.html debe estar en /resources/templates
    }

    @GetMapping("/error")
    public String mostrarPaginaError() {
        return "error";
    }
}
