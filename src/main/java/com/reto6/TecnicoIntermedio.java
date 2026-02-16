package com.reto6;

public class TecnicoIntermedio extends Tecnico {
    public TecnicoIntermedio(String especialidad) {
        this.nivel = "Intermedio";
        this.especialidad = especialidad;
        this.maxPrioridad = 4;
    }
}
