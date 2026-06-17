package com.serice.resenas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serice.resenas.model.Modelo;
import com.serice.resenas.repository.ResenaRepository;

@Service
public class ResenasService 
{
    @Autowired
    private ResenaRepository repository;

    public List<Modelo> listar(){
        return repository.findAll();
    }
    public Modelo guardar(Modelo resena) {
        return repository.save(resena);
    }

    public Modelo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Modelo actualizar(Long id, Modelo nuevo) {
    Modelo existente = repository.findById(id).orElse(null);

    if (existente == null) {
        return null;
    }

    existente.setClasificacion(nuevo.getClasificacion());
    existente.setClienteid(nuevo.getClienteid());
    existente.setComentario(nuevo.getComentario());
    existente.setEventoid(nuevo.getEventoid());
    existente.setFecha(nuevo.getFecha());

    return repository.save(existente);
}

    public void eliminar(Long id) {
        repository.deleteById(id);
    }



}
