package com.libreria.libreriaspringboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreria.libreriaspringboot.Model.Copia;
import com.libreria.libreriaspringboot.Model.Libro;
import com.libreria.libreriaspringboot.Service.CopiaService;
import com.libreria.libreriaspringboot.Service.LibroService;

@Controller
@RequestMapping("/copias")
public class CopiaController {
    
    @Autowired
    private CopiaService service;

    @Autowired
    private LibroService libroService;

    @GetMapping("/listar")
    public String listarCopias(Model model){
        model.addAttribute("copias", service.listarCopias());
        return "copia/copias";
    }

    @GetMapping("/nuevo")
    public String nuevoLibro(Model model){
        Copia copia = new Copia();
        model.addAttribute("copia", copia);
        
        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);

        return "copia/nueva_copia";
    }

    @PostMapping("/guardar")
    public String guardarCopia(@ModelAttribute("copia") Copia copia){
        service.guardarCopia(copia);
        return "redirect:listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCopia(@PathVariable Integer id, Model model){
        model.addAttribute("copia", service.obtenerCopiaPorId(id));

        List<Libro> libros = libroService.listarLibros();
        model.addAttribute("libros", libros);

        return "copia/editar_copia";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCopia(@PathVariable Integer id, @ModelAttribute("copia") Copia copia, Model model){
        Copia copiaExistente = service.obtenerCopiaPorId(id);
        copiaExistente.setIdCopia(id);
        copiaExistente.setLibro(copia.getLibro());
        copiaExistente.setEstado(copia.getEstado());
        service.actualizarCopia(copiaExistente);
        return "redirect:../listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCopia(@PathVariable Integer id){
        service.eliminarCopia(id);
        return "redirect:../listar";
    }
}
