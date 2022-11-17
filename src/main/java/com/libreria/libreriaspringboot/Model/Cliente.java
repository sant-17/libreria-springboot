package com.libreria.libreriaspringboot.Model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    private String nombre;

    private String telefono;

    private String direccion;

    private Integer idCopia;

    @ManyToMany
    @JoinTable(
        name = "prestamos",
        joinColumns = @JoinColumn(name = "idCliente"),
        inverseJoinColumns = @JoinColumn(name = "idCopia")
    )
    List<Copia> copiaPrestada;

    public void agregarCopia(Copia copia){
        copiaPrestada.add(copia);
        copia.getClientePrestado().add(this);
    }

    public void removerCopia(Copia copia){
        copiaPrestada.remove(copia);
        copia.getClientePrestado().remove(this);
    }

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String telefono, String direccion, Integer idCopia,
            List<Copia> copiaPrestada) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.idCopia = idCopia;
        this.copiaPrestada = copiaPrestada;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Copia> getCopiaPrestada() {
        return copiaPrestada;
    }

    public void setCopiaPrestada(List<Copia> copiaPrestada) {
        this.copiaPrestada = copiaPrestada;
    }

    public Integer getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(Integer idCopia) {
        this.idCopia = idCopia;
    }

    
}
