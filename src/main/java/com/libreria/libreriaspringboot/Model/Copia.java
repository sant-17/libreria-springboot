package com.libreria.libreriaspringboot.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "copias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Copia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copia")
    private Integer idCopia;

    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idLibro")
    private Libro libro;
}
