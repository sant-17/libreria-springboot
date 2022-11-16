package com.libreria.libreriaspringboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libreria.libreriaspringboot.Model.Autor;
import com.libreria.libreriaspringboot.Service.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private AutorService service;

    @GetMapping("/listar")
    public String listarAutores(Model model){
        model.addAttribute("autores", service.listarAutores());
        return "autor/autores";
    }

    @GetMapping("/nuevo")
    public String nuevoAutor(Model model){
        Autor autor = new Autor();
        model.addAttribute("autor", autor);
        return "autor/nuevo_autor";
    }

    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute("autor") Autor autor){
        service.guardarAutor(autor);
        return "redirect:listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProveedor(@PathVariable Integer id, Model model){
        model.addAttribute("autor", service.obtenerAutorPorId(id));
        return "autor/editar_autor";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarAutor(@PathVariable Integer id, @ModelAttribute("autor") Autor autor, Model model){
        Autor autorExistente = service.obtenerAutorPorId(id);
        autorExistente.setIdAutor(id);
        autorExistente.setNombre(autor.getNombre());
        autorExistente.setNacionalidad(autor.getNacionalidad());
        autorExistente.setFechaNacimiento(autor.getFechaNacimiento());
        service.actualizarAutor(autorExistente);
        return "redirect:../listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAutor(@PathVariable Integer id){
        service.eliminarAutor(id);
        return "redirect:../listar";
    }
}
