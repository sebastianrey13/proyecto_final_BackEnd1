package com.example.proyecto_final.controller;

import com.example.proyecto_final.model.Turno;
import com.example.proyecto_final.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @PostMapping("/crear")
    public ResponseEntity<Turno> crear(@RequestBody Turno t){
        Turno turno = turnoService.guardar(t);
        return ResponseEntity.ok(turno);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Turno> buscar(@RequestParam Integer id){
        Optional<Turno> turno = turnoService.buscar(id);
        return turno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam Integer id){
        if(turnoService.buscar(id).isPresent()){
            turnoService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Turno> actualizar (@RequestBody Turno t){
        ResponseEntity<Turno> turno = null;
        if (t.getId() != null && turnoService.buscar(t.getId()).isPresent()){
            turno = ResponseEntity.ok(turnoService.actualizar(t));
        }
        else{
            turno = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return turno;
    }

}
