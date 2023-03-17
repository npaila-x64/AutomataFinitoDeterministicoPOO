package org.app.modelos;

import java.util.*;

public class Estado {
    enum ENUM {SIMBOLO, ESTADO}

    private Automata automata;
    private final String nombre;
    private final Set<Map<ENUM, Object>> uniones = new LinkedHashSet<>();

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public void transicionar(String s) {
        for (Map union : uniones) {
            Simbolo simbolo = (Simbolo) union.get(ENUM.SIMBOLO);
            Estado estado = (Estado) union.get(ENUM.ESTADO);
            if (simbolo.toString().equals(s)) {
                System.out.printf("%s -> %s vía símbolo '%s'%n", nombre, estado, simbolo);
                automata.asignarEstado(estado);
            }
        }
    }

    public void unir(Simbolo s, Estado e) {
        Map union = new HashMap();
        union.put(ENUM.SIMBOLO, s);
        union.put(ENUM.ESTADO, e);
        uniones.add(union);
    }

    public void asignarAutomata(Automata automata) {
        this.automata = automata;
    }

    public List<Estado> obtenerEstadosUnidos() {
        List<Estado> estados = new LinkedList<>();
        for (Map<ENUM, Object> union : uniones) {
            estados.add((Estado) union.get(ENUM.ESTADO));
        }
        return estados;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
