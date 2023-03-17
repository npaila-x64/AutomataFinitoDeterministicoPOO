package org.example;

import java.util.HashSet;
import java.util.Set;

public class Automata {

    // Se prefiere el uso de Set para evitar duplicidades
    private final Set<Estado> estadosFinales;
    // El empleo de la clase Estado se basa en el patrón de diseño 'State Pattern'
    private Estado estado;

    public Automata(Set<Estado> estados) {
        estadosFinales = new HashSet<>();

        // A cada estado se le asocia este autómata
        for (Estado estado : estados) {
            estado.asignarAutomata(this);
        }
    }

    public void agregarEstadoFinal(Estado estado) {
        estadosFinales.add(estado);
    }

    public void obtenerDelta() {

    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean evaluar(String palabra) {
        aplicarTransiciones(palabra);

        // Si el estado actual conincide con algún estado final
        // entonces la palabra es aceptada por el autómata
        for (Estado estadoFinal : estadosFinales) {
            if (estadoFinal.equals(estado)) {
                return true;
            }
        }

        return false;
    }

    private void aplicarTransiciones(String palabra) {
        for (String c : palabra.split("")) {
            estado.transicionar(c);
        }
    }
}
