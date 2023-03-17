package org.app.modelos;

import java.util.HashSet;
import java.util.Set;

public class Automata {

    private final Alfabeto alfabeto;
    // Se prefiere el uso de Set para evitar duplicidades
    private final Set<Estado> estados;
    private final Set<Estado> estadosFinales = new HashSet<>();
    // El empleo de la clase Estado se basa en el patrón de diseño 'State Pattern'
    private Estado estado;

    public Automata(Alfabeto alfabeto, Set<Estado> estados) {
        this.estados = estados;
        this.alfabeto = alfabeto;

        // A cada estado se le asocia este autómata
        for (Estado estado : estados) estado.asignarAutomata(this);
    }

    public void agregarEstadoFinal(Estado estado) {
        estadosFinales.add(estado);
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean evaluar(String palabra) {
        // Se aplican las transiciones en base a la palabra de entrada
        // En caso de que en la palabra exista un símbolo inválido esta se rechaza
        try {
            aplicarTransiciones(palabra);
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
            return false;
        }

        // Si el estado actual conincide con algún estado final
        // entonces la palabra es aceptada por el autómata
        for (Estado estadoFinal : estadosFinales) {
            if (estadoFinal.equals(estado)) return true;
        }

        return false;
    }

    private void aplicarTransiciones(String palabra) throws IllegalStateException {
        for (String simbolo : palabra.split("")) {
            if (alfabeto.contiene(simbolo)) {
                estado.transicionar(simbolo);
            } else {
                throw new IllegalStateException("Se encontró un símbolo inválido en la palabra");
            }
        }
    }

    public void imprimirDelta() {
        StringBuilder sb = new StringBuilder();

        sb.append("Delta del Autómata\n");
        for (Simbolo s : alfabeto.obtenerSimbolos()) {
            sb.append("\t").append(s);
        }
        sb.append("\n");

        for (Estado e : estados) {
            sb.append(e).append("\t");
            for (Estado eu : e.obtenerEstadosUnidos()) {
                sb.append(eu).append("\t");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
