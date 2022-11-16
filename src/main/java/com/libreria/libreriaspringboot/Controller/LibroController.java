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

import com.libreria.libreriaspringboot.Model.Autor;
import com.libreria.libreriaspringboot.Model.Libro;
import com.libreria.libreriaspringboot.Service.AutorService;
import com.libreria.libreriaspringboot.Service.LibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService service;

    @Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    public String listarLibros(Model model){
        model.addAttribute("libros", service.listarLibros());
        return "libro/libros";
    }

    @GetMapping("/nuevo")
    public String nuevoLibro(Model model){
        Libro libro = new Libro();
        model.addAttribute("libro", libro);

        List<Autor> autores = autorService.listarAutores();
        model.addAttribute("autores", autores);

        return "libro/nuevo_libro";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") Libro libro){
        service.guardarLibro(libro);
        return "redirect:listar";
    }

    @GetMapping("/editar/{id}")
    public String editarLibro(@PathVariable Integer id, Model model){
        model.addAttribute("libro", service.obtenerLibroPorId(id));

        List<Autor> autores = autorService.listarAutores();
        model.addAttribute("autores", autores);

        return "libro/editar_libro";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarLibro(@PathVariable Integer id, @ModelAttribute("libro") Libro libro, Model model){
        Libro libroExistente = service.obtenerLibroPorId(id);
        libroExistente.setIdLibro(id);
        libroExistente.setTitulo(libro.getTitulo());
        libroExistente.setEditorial(libro.getEditorial());
        libroExistente.setGenero(libro.getGenero());
        libroExistente.setAnyo(libro.getAnyo());
        libroExistente.setAutor(libro.getAutor());
        service.actualizarLibro(libroExistente);
        return "redirect:../listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id){
        service.eliminarLibro(id);
        return "redirect:../listar";
    }
}
