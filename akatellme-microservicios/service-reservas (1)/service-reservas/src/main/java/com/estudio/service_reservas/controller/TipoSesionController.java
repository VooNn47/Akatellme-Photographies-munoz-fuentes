package com.estudio.service_reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.service_reservas.model.TipoSesion;
import com.estudio.service_reservas.repository.TipoSesionRepository;

@RestController
@RequestMapping("/tipos-sesion")

public class TipoSesionController 
{
    @Autowired
    private TipoSesionRepository tipoSesionRepository;

    @PostMapping("/guardar")
    public TipoSesion guardar(@RequestBody TipoSesion tipoSesion){
        return tipoSesionRepository.save(tipoSesion);
    }
    @GetMapping("/listar")
    public List<TipoSesion> listar(){
        return tipoSesionRepository.findAll();

    }

}
