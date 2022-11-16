package com.libreria.libreriaspringboot.Service;

import java.util.List;

import com.libreria.libreriaspringboot.Model.Libro;

public interface LibroService {
    
    public List<Libro> listarLibros();

    public Libro guardarLibro(Libro libro);

    public Libro obtenerLibroPorId(Integer id);

    public Libro actualizarLibro(Libro libro);

    public void eliminarLibro(Integer id);
}
