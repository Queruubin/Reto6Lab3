package com.reto6;


public class TecnicoAvanzado extends Tecnico {
    public TecnicoAvanzado(String especialidad) {
        this.nivel = "Avanzado";
        this.especialidad = especialidad;
        this.maxPrioridad = 5;
    }
}

