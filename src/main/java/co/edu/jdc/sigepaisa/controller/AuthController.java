package co.edu.jdc.sigepaisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/inicio")
    public String inicioAdmin(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("seccion", "inicio");
        model.addAttribute("contenido", "inicio/admin");
        return "layout/base";
    }

    @GetMapping("/vendedor/inicio")
    public String inicioVendedor(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("seccion", "inicio");
        model.addAttribute("contenido", "inicio/vendedor");
        return "layout/base";
    }
}