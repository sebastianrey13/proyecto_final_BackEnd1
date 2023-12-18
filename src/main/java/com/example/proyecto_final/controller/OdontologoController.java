package com.example.proyecto_final.controller;

import com.example.proyecto_final.model.Odontologo;
import com.example.proyecto_final.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping("/crear")
    public ResponseEntity<Odontologo> crear(@RequestBody Odontologo o){
        Odontologo odontologo = odontologoService.guardar(o);
        return ResponseEntity.ok(odontologo);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Odontologo> buscar(@RequestParam Integer id){
        Optional<Odontologo> odontologo = odontologoService.buscar(id);
        /*if (odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }*/
        return odontologo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminar(@RequestParam Integer id){

        if(odontologoService.buscar(id).isPresent()){
            odontologoService.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Odontologo> actualizar (@RequestBody Odontologo o){
        ResponseEntity<Odontologo> odontologo = null;
        if (o.getId() != null && odontologoService.buscar(o.getId()).isPresent()){
            odontologo = ResponseEntity.ok(odontologoService.actualizar(o));
        }
        else{
            odontologo = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return odontologo;
    }

}