package org.example.classes;

import java.util.HashMap;
import java.util.Map;

public class ForecastApi {
    private static Map<String, Local> locais = new HashMap<>();

    public static Local getLocal(String coordenadas) {
        return locais.get(coordenadas);
    }

    public static void addLocal(Local local) {
        locais.put(local.getCoordenadas(), local);
    }
}