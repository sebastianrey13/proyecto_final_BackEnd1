package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Paciente;
import com.example.proyecto_final.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente guardar(Paciente p){
        return pacienteRepository.save(p);
    }

    public Optional<Paciente> buscar(Integer id){
        return pacienteRepository.findById(id);
    }

    public void eliminar(Integer id){
        pacienteRepository.deleteById(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteRepository.findAll();
    }

    public Paciente actualizar (Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
