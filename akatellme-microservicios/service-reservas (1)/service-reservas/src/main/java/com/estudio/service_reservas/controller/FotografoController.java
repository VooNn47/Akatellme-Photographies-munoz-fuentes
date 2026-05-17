package com.estudio.service_reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudio.service_reservas.model.Fotografo;
import com.estudio.service_reservas.repository.FotografoRepository;

@RestController
@RequestMapping("/fotografos")

public class FotografoController 
{
    @Autowired
    private FotografoRepository fotografoRepository;

    @PostMapping("/guardar")
    public Fotografo guardar(@RequestBody Fotografo fotografo){
        return fotografoRepository.save(fotografo);
    }

    @GetMapping("/listar")
    public List<Fotografo> listar(){
        return fotografoRepository.findAll();
    }

}
