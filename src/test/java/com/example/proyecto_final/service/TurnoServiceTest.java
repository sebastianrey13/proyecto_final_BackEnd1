package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Domicilio;
import com.example.proyecto_final.model.Odontologo;
import com.example.proyecto_final.model.Paciente;
import com.example.proyecto_final.model.Turno;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoService turnoService;

    @Test
    public void testCrearOdontologo(){
        Odontologo odontologo = new Odontologo("Sebastian","Rey",12345);
        odontologoService.guardar(odontologo);

        Paciente paciente = new Paciente("Sebastian","Rey","12344",new Date(), new Domicilio("primera","12345","localidad","provincia"));
        pacienteService.guardar(paciente);


        Turno turno = new Turno(paciente,odontologo,new Date());

        turnoService.guardar(turno);

        Optional<Turno> turno1 = turnoService.buscar(1);

        assertTrue(turno1.get().getId() != 0);
    }

    @Test
    public void testBuscarTurno(){
        Assert.assertNotNull(turnoService.buscar(1));
    }

    @Test
    public void testEliminarTurno(){
        turnoService.eliminar(1);
        Assert.assertFalse(turnoService.buscar(1).isPresent());
    }

}