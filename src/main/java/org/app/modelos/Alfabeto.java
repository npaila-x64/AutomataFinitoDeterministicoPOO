package org.app.modelos;

import java.util.LinkedHashSet;
import java.util.Set;

public class Alfabeto {

    private final Set<Simbolo> simbolos = new LinkedHashSet<>();

    public void agregarSimbolo(Simbolo simbolo) {
        simbolos.add(simbolo);
    }

    public boolean contiene(String simbolo) {
        for (Simbolo s : simbolos) {
            if (s.toString().equals(simbolo)) return true;
        }
        return false;
    }

    public Set<Simbolo> obtenerSimbolos() {
        return new LinkedHashSet<>(simbolos);
    }
}
