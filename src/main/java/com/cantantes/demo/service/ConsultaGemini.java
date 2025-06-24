package com.cantantes.demo.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ConsultaGemini {

    private static final String apiKey = System.getenv("GEMINI_APIKEY");
    public static String obtenerBiografia(String aliasCantante){
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Dame una biografia resumida pero detallada de este cantante (Maximo 200 caracteres): " + aliasCantante;

        Client cliente = new Client.Builder().apiKey(apiKey).build();

        try{
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null
            );
            if (!respuesta.text().isEmpty()){
                return respuesta.text();
            }
        }catch (Exception e){
            System.err.println("Error al llamar a la API de Gemini para traducción: " + e.getMessage());
        }
        return null;
    }

    public static String obtenerNombreCantante(String aliasCantante){
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Proporciona ÚNICAMENTE el nombre real completo (nombre y apellidos) de este artista musical: " + aliasCantante + ". Responde solo con el nombre real, sin explicaciones adicionales. Si el dato no está disponible públicamente, responde exactamente con: 'Nombre no disponible públicamente'.";

        Client cliente = new Client.Builder().apiKey(apiKey).build();

        try{
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null
            );
            if (!respuesta.text().isEmpty()){
                return respuesta.text();
            }
        }catch (Exception e){
            System.err.println("Error al llamar a la API de Gemini para obtener el nombre del cantante: " + e.getMessage());
        }
        return null;
    }

    public static String obtenerEdad(String aliasCantante) {
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Dime ÚNICAMENTE el número de edad actual de " + aliasCantante + " sin texto adicional. " +
                "Responde solo con el número, por ejemplo: 34. No incluyas palabras, símbolos ni puntuación.";

        Client cliente = new Client.Builder().apiKey(apiKey).build();

        try {
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null
            );

            if (!respuesta.text().isEmpty()) {
                String texto = respuesta.text().trim();
                if (texto.matches("\\d+")) {
                    return texto;
                } else {
                    String soloNumeros = texto.replaceAll("[^0-9]", "");
                    if (!soloNumeros.isEmpty()) {
                        return soloNumeros;
                    }
                }
                return texto;
            }
        } catch (Exception e) {
            System.err.println("Error al llamar a la API de Gemini para obtener la edad del cantante: " + e.getMessage());
        }
        return "0";
    }

    public static String obtenerNacionalidad(String aliasCantante){
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Dime la nacionalidad real pública de: " + aliasCantante + " (SOLO NACIONALIDAD, POR EJEMPLO {Argentina} .Si algún dato no está disponible, indícalo.";

        Client cliente = new Client.Builder().apiKey(apiKey).build();

        try{
            GenerateContentResponse respuesta = cliente.models.generateContent(
                    modelo,
                    prompt,
                    null
            );
            if (!respuesta.text().isEmpty()){
                return respuesta.text();
            }
        }catch (Exception e){
            System.err.println("Error al llamar a la API de Gemini para obtener la nacionalidad del cantante: " + e.getMessage());
        }
        return null;
    }
}
