package com.libreria.libreriaspringboot.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreriaspringboot.Model.Libro;
import com.libreria.libreriaspringboot.Repository.LibroRepository;
import com.libreria.libreriaspringboot.Service.LibroService;

@Service
public class LibroServiceImp implements LibroService{

    @Autowired
    private LibroRepository repository;

    @Override
    public List<Libro> listarLibros() {
        return repository.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public Libro obtenerLibroPorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return repository.save(libro);
    }

    @Override
    public void eliminarLibro(Integer id) {
        repository.deleteById(id);
    }
    
}
