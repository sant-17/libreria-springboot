package com.libreria.libreriaspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libreria.libreriaspringboot.Model.Copia;

@Repository
public interface CopiaRepository extends JpaRepository<Copia, Integer> {
    
}
