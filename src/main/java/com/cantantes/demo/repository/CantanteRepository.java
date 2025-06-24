package com.cantantes.demo.repository;

import com.cantantes.demo.model.Cancion;
import com.cantantes.demo.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CantanteRepository extends JpaRepository<Cantante, Long> {

    @Query("SELECT c FROM Cantante c WHERE c.alias ILIKE %:alias%")
    Cantante findCantante(String alias);

    @Query("SELECT c FROM Cancion c WHERE c.titulo ILIKE %:titulo%")
    Cancion findCancion(String titulo);

    @Query("SELECT c FROM Cancion c JOIN c.cantantes cant WHERE cant.id = :cantanteId")
    List<Cancion> findCancionesByCantanteId(@Param("cantanteId") Long cantanteId);

    @Query("SELECT c FROM Cantante c WHERE c.nacionalidad ILIKE %:nacionalidad%")
    List<Cantante> findCantantesByNacionalidad(String nacionalidad);

}
