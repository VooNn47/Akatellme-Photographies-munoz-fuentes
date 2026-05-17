package com.estudio.service_pagos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.estudio.service_pagos.model.Pago;
import com.estudio.service_pagos.repository.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Pago> listarTodos(){
        return pagoRepository.findAll();
    }

    public Optional <Pago> buscarPorId(Long id){
        return pagoRepository.findById(id);
    }
    public Pago guardar(Pago pago){
        try{
            Object reserva = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/reservas/"+ pago.getReservaId())
                .retrieve()
                .bodyToMono(Object.class)
                .block();
            System.out.println(reserva);

        } catch (Exception e){
            throw new RuntimeException("La reserva no existe");
        }

        if(pago.getEstado()== null){
            pago.setEstado("PAGADO");
        }

        if (pago.getFechaPago()==null){
                pago.setFechaPago(LocalDate.now());
        }
        return pagoRepository.save(pago);
    }


        
        public void eliminar(Long id){
            pagoRepository.deleteById(id);
        }

}
