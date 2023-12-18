package com.example.proyecto_final.repository;

import com.example.proyecto_final.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
