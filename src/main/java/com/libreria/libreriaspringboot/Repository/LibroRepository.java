package com.libreria.libreriaspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreriaspringboot.Model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
    
}
