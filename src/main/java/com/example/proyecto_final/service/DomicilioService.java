package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Domicilio;
import com.example.proyecto_final.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;

    public Domicilio guardar(Domicilio d){
        return domicilioRepository.save(d);
    }

    public Optional<Domicilio> buscar(Integer id){
        return domicilioRepository.findById(id);
    }

    public void eliminar(Integer id){
        domicilioRepository.deleteById(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioRepository.findAll();
    }

    public Domicilio actualizar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }
}
