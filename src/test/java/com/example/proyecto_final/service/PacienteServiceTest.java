package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Domicilio;
import com.example.proyecto_final.model.Paciente;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    public void testCrearOdontologo(){
        Paciente paciente = new Paciente("Sebastian","Rey","12344",new Date(), new Domicilio("primera","12345","localidad","provincia"));
        pacienteService.guardar(paciente);
        Optional<Paciente> paciente1 = pacienteService.buscar(1);
        assertTrue(paciente1.get().getId() != 0);
    }

    @Test
    public void testBuscarTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(pacientes.size() == 1);
        System.out.println(pacientes);
    }

}