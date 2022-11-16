package com.libreria.libreriaspringboot.Service;

import java.util.List;

import com.libreria.libreriaspringboot.Model.Cliente;

public interface ClienteService {
    public List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente obtenerClientePorId(Integer id);

    public Cliente actualizarCliente(Cliente cliente);

    public void eliminarCliente(Integer id);
}
