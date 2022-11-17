package com.libreria.libreriaspringboot.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "copias")
public class Copia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copia")
    private Integer idCopia;

    private String estado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idLibro")
    private Libro libro;

    @ManyToMany(mappedBy = "copiaPrestada")
    List<Cliente> clientePrestado;

    public Copia() {
    }

    public Copia(Integer idCopia, String estado, Libro libro, List<Cliente> clientePrestado) {
        this.idCopia = idCopia;
        this.estado = estado;
        this.libro = libro;
        this.clientePrestado = clientePrestado;
    }

    public Integer getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(Integer idCopia) {
        this.idCopia = idCopia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Cliente> getClientePrestado() {
        return clientePrestado;
    }

    public void setClientePrestado(List<Cliente> clientePrestado) {
        this.clientePrestado = clientePrestado;
    }

    @Override
    public String toString() {
        return "ID " + idCopia + " - " + libro;
    }

    
}
