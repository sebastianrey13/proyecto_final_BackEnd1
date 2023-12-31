package com.example.proyecto_final.model;

/*import jakarta.persistence.*;*/
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Odontologo implements Serializable {
    @Id
    @SequenceGenerator(
            name = "odontologo_sequence",
            sequenceName = "odontologo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "odontologo_sequence"
    )
    @Column(name = "id", nullable = false)
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    /*public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }*/

    @Override
    public String toString() {
        return "Odontologo" + "\n" +
                "Id: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Matricula: " + matricula;
    }
}
