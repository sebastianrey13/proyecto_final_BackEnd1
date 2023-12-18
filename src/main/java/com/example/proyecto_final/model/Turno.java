package com.example.proyecto_final.model;

import com.fasterxml.jackson.annotation.JsonFormat;

/*import jakarta.persistence.*;*/
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Turno implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    @Id
    @SequenceGenerator(
            name = "turno_sequence",
            sequenceName = "turno_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "turno_sequence"
    )
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, Date date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public Turno(Integer id, Paciente paciente, Odontologo odontologo, Date date) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Turno" +
                "Id: " + id + "\n" +
                paciente + "\n" +
                odontologo + "\n" +
                "Fecha: " + date;
    }
}
