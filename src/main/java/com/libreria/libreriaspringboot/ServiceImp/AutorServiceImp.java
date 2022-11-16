package com.libreria.libreriaspringboot.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreriaspringboot.Model.Autor;
import com.libreria.libreriaspringboot.Repository.AutorRepository;
import com.libreria.libreriaspringboot.Service.AutorService;

@Service
public class AutorServiceImp implements AutorService{

    @Autowired
    private AutorRepository repository;

    @Override
    public List<Autor> listarAutores() {
        return repository.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Autor obtenerAutorPorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Autor actualizarAutor(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public void eliminarAutor(Integer id) {
        repository.deleteById(id);
    }
    
}
