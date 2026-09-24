package co.edu.jdc.sigepaisa.controller;

import co.edu.jdc.sigepaisa.entity.Producto;
import co.edu.jdc.sigepaisa.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listarActivos());
        model.addAttribute("titulo", "Productos");
        model.addAttribute("seccion", "productos");
        model.addAttribute("contenido", "productos/lista");
            return "layout/base";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Nuevo producto");
        model.addAttribute("seccion", "productos");
        model.addAttribute("contenido", "productos/formulario");
        return "layout/base";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("producto", productoService.buscarPorId(id));
        model.addAttribute("titulo", "Editar producto");
        model.addAttribute("seccion", "productos");
        model.addAttribute("contenido", "productos/formulario");
        return "layout/base";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Producto");
            model.addAttribute("seccion", "productos");
            model.addAttribute("contenido", "productos/formulario");
            return "layout/base";
        }
        productoService.guardar(producto);
        return "redirect:/productos";
    }


    @GetMapping("/desactivar/{id}")
    public String desactivar(@PathVariable Integer id) {
        productoService.desactivar(id);
        return "redirect:/productos";
     }
    }
