package com.cantantes.demo.model;

public enum Genero {
    CLASICA("Clasica"),
    ROCK("Rock"),
    POP("Pop"),
    JAZZ("Jazz"),
    REGGAE("Reggae"),
    HIPHOP("HipHop"),
    COUNTRY("Country"),
    ELECTRONICA("Electronica"),
    LATINO("Latino"),
    FOLK("Folk"),
    BLUES("Blues"),
    METAL("Metal"),
    RNB("R&B"),
    REGGAETON("Reggaeton"),
    TRAP("Trap"),
    OTRO("Otro")
    ;

    private String categoriaOmdb;

    Genero(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }

    public static Genero fromString(String text){
        for (Genero genero : Genero.values()){
            if (genero.categoriaOmdb.equalsIgnoreCase(text)){
                return genero;
            }
        }
        throw new IllegalArgumentException("Ningun genero encontrado: " + text);
    }
}
