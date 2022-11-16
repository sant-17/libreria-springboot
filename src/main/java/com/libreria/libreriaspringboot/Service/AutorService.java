package com.libreria.libreriaspringboot.Service;

import java.util.List;

import com.libreria.libreriaspringboot.Model.Autor;

public interface AutorService {
    
    public List<Autor> listarAutores();

    public Autor guardarAutor(Autor autor);

    public Autor obtenerAutorPorId(Integer id);

    public Autor actualizarAutor(Autor autor);

    public void eliminarAutor(Integer id);
}
