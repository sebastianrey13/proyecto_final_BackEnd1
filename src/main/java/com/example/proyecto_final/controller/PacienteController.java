package com.example.proyecto_final.controller;

import com.example.proyecto_final.model.Paciente;
import com.example.proyecto_final.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente p){
        Paciente paciente = pacienteService.guardar(p);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Paciente> buscar(@RequestParam Integer id){
        Optional<Paciente> paciente = pacienteService.buscar(id);

        if (paciente.isPresent()){
            return ResponseEntity.ok(paciente.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        /*return paciente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());*/
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam Integer id){
        if(pacienteService.buscar(id).isPresent()){
            pacienteService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
    @PutMapping("/actualizar")
    public ResponseEntity<Paciente> actualizar (@RequestBody Paciente p){
        ResponseEntity<Paciente> paciente = null;
        if (p.getId() != null && pacienteService.buscar(p.getId()).isPresent()){
            paciente = ResponseEntity.ok(pacienteService.actualizar(p));
        }
        else{
            paciente = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return paciente;
    }

}
