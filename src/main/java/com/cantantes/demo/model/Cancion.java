package com.cantantes.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ManyToMany(mappedBy = "canciones", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<Cantante> cantantes = new ArrayList<>();

    public Cancion() {
    }

    public Cancion(String titulo, Genero genero) {
        this.titulo = titulo;
        this.genero = genero;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Cantante> getCantantes() {
        return cantantes;
    }

    public void setCantantes(List<Cantante> cantantes) {
        this.cantantes = cantantes;
    }
}
