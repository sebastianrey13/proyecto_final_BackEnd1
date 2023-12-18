package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Turno;
import com.example.proyecto_final.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;

    public Turno guardar(Turno t){
        return turnoRepository.save(t);
    }

    public Optional<Turno> buscar(Integer id){
        return turnoRepository.findById(id);
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(id);
    }

    public List<Turno> buscarTodos(){
        return turnoRepository.findAll();
    }

    public Turno actualizar(Turno t){
        return turnoRepository.save(t);
    }

}
