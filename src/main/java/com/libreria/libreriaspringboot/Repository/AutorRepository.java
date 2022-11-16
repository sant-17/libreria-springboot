package com.libreria.libreriaspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreriaspringboot.Model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{
    
}
