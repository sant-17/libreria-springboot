package com.libreria.libreriaspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreriaspringboot.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}