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
        String prompt = "Dime el nombre real público de: " + aliasCantante + "(SOLO RESPONDE EL NOMBRE REAL, POR EJEMPLO {MAURO LOMBARDO}. Si algún dato no está disponible, indícalo.";

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

    public static String obtenerEdad(String aliasCantante){
        String modelo = "gemini-2.0-flash-lite";
        String prompt = "Dime la edad real pública de: " + aliasCantante + "(RESPONDE SOLO CON LA EDAD, ES DECIR EL NUMERO POR EJEMPLO {34}. Si algún dato no está disponible, indícalo.";

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
            System.err.println("Error al llamar a la API de Gemini para obtener la edad del cantante: " + e.getMessage());
        }
        return null;
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
