package com.cantantes.demo.model;

import com.cantantes.demo.service.ConsultaGemini;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cantantes")
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String alias;
    private int edad;
    private String nacionalidad;
    private String biografia;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "cantante_cancion",
            joinColumns = @JoinColumn(name = "cantante_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private Set<Cancion> canciones = new HashSet<>();

    public Cantante() {
    }

    public Cantante(String alias) {
        this.alias = alias;
        this.nombre = ConsultaGemini.obtenerNombreCantante(this.alias);
        try{
            this.edad = Integer.valueOf(ConsultaGemini.obtenerEdad(this.alias));
        }catch (NumberFormatException e){
            this.edad = 0;
        }
        this.nacionalidad = ConsultaGemini.obtenerNacionalidad(this.alias);
        this.biografia = ConsultaGemini.obtenerBiografia(this.alias);
    }

    public Set<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    @Override
    public String toString() {
        return "Cantante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", alias='" + alias + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", biografia='" + biografia + '\'' +
                '}';
    }
}
