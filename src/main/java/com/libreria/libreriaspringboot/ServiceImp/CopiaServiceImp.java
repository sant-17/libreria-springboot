package com.libreria.libreriaspringboot.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreriaspringboot.Model.Copia;
import com.libreria.libreriaspringboot.Repository.CopiaRepository;
import com.libreria.libreriaspringboot.Service.CopiaService;

@Service
public class CopiaServiceImp implements CopiaService {

    @Autowired
    private CopiaRepository repository;

    @Override
    public List<Copia> listarCopias() {
        return repository.findAll();
    }

    @Override
    public Copia guardarCopia(Copia copia) {
        return repository.save(copia);
    }

    @Override
    public Copia obtenerCopiaPorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Copia actualizarCopia(Copia copia) {
        return repository.save(copia);
    }

    @Override
    public void eliminarCopia(Integer id) {
        repository.deleteById(id);
    }
    
}
