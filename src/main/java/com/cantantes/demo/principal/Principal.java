package com.cantantes.demo.principal;

import com.cantantes.demo.model.Cancion;
import com.cantantes.demo.model.Cantante;
import com.cantantes.demo.model.Genero;
import com.cantantes.demo.repository.CantanteRepository;
import com.cantantes.demo.service.ConsultaGemini;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private CantanteRepository repositorio;
    private Scanner teclado = new Scanner(System.in);

    public Principal(CantanteRepository repository) {
        this.repositorio = repository;
    }

    public void mostrarMenu(){
        int opc;
        do{
            System.out.println("Bienvenido. Seleccione una opción:");
            System.out.println("1 - Cargar Cantante");
            System.out.println("2 - Cargar cancion");
            System.out.println("3 - Buscar canciones de un cantante");
            System.out.println("4 - Buscar cantante por nacionalidad");
            System.out.println("0 - Salir.");
            opc = teclado.nextInt();

            switch (opc){
                case 1:
                    cargarCantante();
                    break;

                case 2:
                    cargarCancion();
                    break;

                case 3:
                    buscarCancionesDeCantante();
                    break;

                case 4:
                    buscarCantantePorNacionalidad();
                    break;
            }

        }while (opc != 0);
    }

    public void cargarCantante(){
        teclado.nextLine();
        System.out.println("Ingrese el alias del cantante:");
        String alias = teclado.nextLine();

        Cantante cantante = new Cantante(alias);
        repositorio.save(cantante);
    }

    public void buscarCancionesDeCantante(){
        teclado.nextLine();
        System.out.println("Ingrese el alias del cantante");
        String alias = teclado.nextLine();
        Cantante cantante = repositorio.findCantante(alias);

        if (cantante == null){
            System.out.println("No se encontró el cantante con el alias: " + alias);
            return;
        }else{
            List<Cancion> canciones = repositorio.findCancionesByCantanteId(cantante.getId());
            canciones.forEach(c -> System.out.println("Canción: " + c.getTitulo()));
        }
    }

    public void buscarCantantePorNacionalidad(){
        teclado.nextLine();
        System.out.println("Ingrese la nacionalidad del cantante");
        String nacionalidad = teclado.nextLine();

        List<Cantante> cantantes = repositorio.findCantantesByNacionalidad(nacionalidad);
                cantantes.forEach(c -> System.out.println("Cantante: " + c.getNombre() + " - Nacionalidad: " + c.getNacionalidad() + " - Biografia: " + c.getBiografia()));
    }

    public void cargarCancion(){
        teclado.nextLine();
        System.out.println("Ingrese el alias del cantante");
        String alias = teclado.nextLine();
        Cantante cantante = repositorio.findCantante(alias);

        if (cantante == null){
            System.out.println("No se encontró el cantante con el alias: " + alias);
            return;
        }

        System.out.println(cantante);

        System.out.println("Ingrese el nombre de la cancion");
        String nombreCancion = teclado.nextLine();

        System.out.println("Ingrese el genero de la canción");
        String genero = teclado.nextLine();

        var categoria = Genero.fromString(genero);
        Cancion cancion = new Cancion(nombreCancion, categoria);


        cancion.getCantantes().add(cantante);
        cantante.getCanciones().add(cancion);
        repositorio.save(cantante);

        }

    }
