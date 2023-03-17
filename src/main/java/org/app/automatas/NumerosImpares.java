package org.app.diagramas;

import org.app.modelos.Alfabeto;
import org.app.modelos.Automata;
import org.app.modelos.Estado;
import org.app.modelos.Simbolo;

import java.util.LinkedHashSet;
import java.util.Set;

public class NumerosImpares {
    public static void main(String[] args) {

        // Se definen los simbolos del alfabeto
        Simbolo cero = new Simbolo("0");
        Simbolo uno = new Simbolo("1");

        Alfabeto alfabeto = new Alfabeto();
        alfabeto.agregarSimbolo(cero);
        alfabeto.agregarSimbolo(uno);

        // Se definen los estados
        Set<Estado> estados = new LinkedHashSet<>();
        Estado a = new Estado("a");
        Estado b = new Estado("b");
        estados.add(a);
        estados.add(b);

        // Se crean las transiciones entre estados
        a.unir(cero, a);
        a.unir(uno, b);

        b.unir(cero, b);
        b.unir(uno, a);

        // Se crea el autómata
        Automata A = new Automata(alfabeto, estados);
        // Se asigna el estado inicial
        A.asignarEstado(a);
        // Se asignan él o los estados finales
        A.agregarEstadoFinal(b);

        A.imprimirDelta();

        // Se evalúa en el autómata una palabra
        String palabra = "01010010100111";
        boolean evaluacion = A.evaluar(palabra);

        System.out.println(evaluacion);

    }
}
