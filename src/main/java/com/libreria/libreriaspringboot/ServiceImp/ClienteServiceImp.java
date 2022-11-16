package com.libreria.libreriaspringboot.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.libreriaspringboot.Model.Cliente;
import com.libreria.libreriaspringboot.Repository.ClienteRepository;
import com.libreria.libreriaspringboot.Service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        repository.deleteById(id);
    }
    
}
