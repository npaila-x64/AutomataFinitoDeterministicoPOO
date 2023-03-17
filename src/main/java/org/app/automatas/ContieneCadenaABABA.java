package org.app.automatas;

import org.app.modelos.*;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContieneCadenaABABA {
    public static void main(String[] args) {

        // Se definen los simbolos del alfabeto
        Simbolo a = new Simbolo("a");
        Simbolo b = new Simbolo("b");
        Simbolo c = new Simbolo("c");

        Alfabeto alfabeto = new Alfabeto();
        alfabeto.agregarSimbolo(a);
        alfabeto.agregarSimbolo(b);
        alfabeto.agregarSimbolo(c);

        // Se definen los estados
        Set<Estado> estados = new LinkedHashSet<>();
        Estado q = new Estado("q");
        Estado s = new Estado("s");
        Estado r = new Estado("r");
        Estado u = new Estado("u");
        Estado t = new Estado("t");
        Estado v = new Estado("v");
        estados.add(q);
        estados.add(s);
        estados.add(r);
        estados.add(u);
        estados.add(t);
        estados.add(v);

        // Se crean las transiciones entre estados
        q.unir(a, r);
        q.unir(b, q);
        q.unir(c, q);

        r.unir(a, q);
        r.unir(b, s);
        r.unir(c, q);

        s.unir(a, t);
        s.unir(b, q);
        s.unir(c, q);

        t.unir(a, q);
        t.unir(b, u);
        t.unir(c, q);

        u.unir(a, v);
        u.unir(b, q);
        u.unir(c, q);

        v.unir(a, v);
        v.unir(b, v);
        v.unir(c, v);

        // Se crea el autómata
        Automata A = new Automata(alfabeto, estados);
        // Se asigna el estado inicial
        A.asignarEstado(q);
        // Se asignan él o los estados finales
        A.agregarEstadoFinal(v);

        A.imprimirDelta();

        // Se evalúa en el autómata una palabra
        String palabra = "ccababaaaa";
        boolean evaluacion = A.evaluar(palabra);

        System.out.println(evaluacion);
    }
}
