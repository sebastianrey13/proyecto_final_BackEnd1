package com.example.proyecto_final.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*import jakarta.persistence.*;*/
import javax.persistence.*;
import java.io.Serializable;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table
public class Domicilio implements Serializable {
    @Id
    @SequenceGenerator(
            name = "domicilio_sequence",
            sequenceName = "domicilio_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "domicilio_sequence"
    )
    @Column(name = "id", nullable = false)
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    /*@OneToOne(mappedBy = "domicilio")
    private Paciente paciente;*/

    public Domicilio() {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(Integer id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio" + "\n" +
                "Id: " + id + "\n" +
                "Calle: " + calle + "\n" +
                "Numero: " + numero + "\n" +
                "Localidad: " + localidad + "\n" +
                "Provincia: " + provincia;
    }
}
