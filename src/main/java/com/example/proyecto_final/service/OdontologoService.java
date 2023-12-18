package com.example.proyecto_final.service;

import com.example.proyecto_final.model.Odontologo;
import com.example.proyecto_final.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;

    public Odontologo guardar(Odontologo o){
        return odontologoRepository.save(o);

    }

    public Optional<Odontologo> buscar(Integer id){
        return odontologoRepository.findById(id);
    }

    public void eliminar(Integer id){
        odontologoRepository.deleteById(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }

    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

}
