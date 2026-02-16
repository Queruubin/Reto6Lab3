package com.reto6;

public class TecnicoBasico extends Tecnico {
    public TecnicoBasico(String especialidad) {
        this.nivel = "Basico";
        this.especialidad = especialidad;
        this.maxPrioridad = 2; // Solo resuelve prioridad baja
    }
}