package com.libreria.libreriaspringboot.Service;

import java.util.List;

import com.libreria.libreriaspringboot.Model.Copia;

public interface CopiaService {
    
    public List<Copia> listarCopias();

    public Copia guardarCopia(Copia copia);

    public Copia obtenerCopiaPorId(Integer id);

    public Copia actualizarCopia(Copia copia);

    public void eliminarCopia(Integer id);
}
