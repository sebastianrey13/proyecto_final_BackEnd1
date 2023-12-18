package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Odontologo;
import com.example.proyecto_final.model.Paciente;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    @Test
    public void testCrearOdontologo(){
        Odontologo odontologo = new Odontologo("Sebastian","Rey",12345);

        odontologoService.guardar(odontologo);

        Optional<Odontologo> odontologo1 = odontologoService.buscar(1);

        assertTrue(odontologo1.get().getId() != 0);

    }

    @Test
    public void testBuscarTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertTrue(odontologos.isEmpty());
        System.out.println(odontologos);
    }


}