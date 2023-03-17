package org.app.diagramas;

import org.app.modelos.Alfabeto;
import org.app.modelos.Automata;
import org.app.modelos.Estado;
import org.app.modelos.Simbolo;

import java.util.LinkedHashSet;
import java.util.Set;

public class Semana1 {
    public static void main(String[] args) {

        // Se definen los simbolos del alfabeto
        Simbolo a = new Simbolo("a");
        Simbolo b = new Simbolo("b");

        Alfabeto alfabeto = new Alfabeto();
        alfabeto.agregarSimbolo(a);
        alfabeto.agregarSimbolo(b);

        // Se definen los estados
        Set<Estado> estados = new LinkedHashSet<>();
        Estado q = new Estado("q");
        Estado s = new Estado("s");
        Estado r = new Estado("r");
        Estado u = new Estado("u");
        Estado t = new Estado("t");
        estados.add(q);
        estados.add(s);
        estados.add(r);
        estados.add(u);
        estados.add(t);

        // Se crean las transiciones entre estados
        q.unir(a, r);
        q.unir(b, s);

        r.unir(a, r);
        r.unir(b, r);

        s.unir(b, t);
        s.unir(a, t);

        t.unir(a, u);
        t.unir(b, s);

        u.unir(a, u);
        u.unir(b, u);

        // Se crea el autómata
        Automata A = new Automata(alfabeto, estados);
        // Se asigna el estado inicial
        A.asignarEstado(q);
        // Se asignan él o los estados finales
        A.agregarEstadoFinal(t);
        A.agregarEstadoFinal(u);

        A.imprimirDelta();

        // Se evalúa en el autómata una palabra
        String palabra = "bba";
        boolean evaluacion = A.evaluar(palabra);

        System.out.println(evaluacion);
    }
}