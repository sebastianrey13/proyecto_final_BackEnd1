package com.example.proyecto_final.controller;

import com.example.proyecto_final.model.Domicilio;
import com.example.proyecto_final.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {

    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/crear")
    public ResponseEntity<Domicilio> crear(@RequestBody Domicilio d){
        Domicilio domicilio = domicilioService.guardar(d);
        return ResponseEntity.ok(domicilio);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Domicilio> buscar(@RequestParam Integer id){
        Optional<Domicilio> domicilio = domicilioService.buscar(id);
        return domicilio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam Integer id){
        if(domicilioService.buscar(id).isPresent()){
            domicilioService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Domicilio>> buscarTodos(){
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Domicilio> actualizar (@RequestBody Domicilio d){
        ResponseEntity<Domicilio> domicilio = null;
        if (d.getId() != null && domicilioService.buscar(d.getId()).isPresent()){
            domicilio = ResponseEntity.ok(domicilioService.actualizar(d));
        }
        else{
            domicilio = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return domicilio;
    }
}
