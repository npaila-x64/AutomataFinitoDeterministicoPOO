package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Estado {
    enum ENUM {
        SIMBOLO, ESTADO
    }

    private Automata automata;
    private final String nombre;
    private final Set<Map<ENUM, Object>> uniones = new HashSet<>();

    public Estado(String nombre) {
        this.nombre = nombre;
    }

    public void transicionar(String c) {
        for (Map union : uniones) {
            Simbolo simbolo = (Simbolo) union.get(ENUM.SIMBOLO);
            Estado estado = (Estado) union.get(ENUM.ESTADO);
            if (simbolo.toString().equals(c)) {
                automata.asignarEstado(estado);
                break;
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

    @Override
    public String toString() {
        return nombre;
    }
}
