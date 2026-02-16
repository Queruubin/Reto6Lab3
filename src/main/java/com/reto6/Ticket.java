package com.reto6;

public class Ticket {
    private String descripcion;
    private String dificultad; // Basica, Intermedia, Avanzada
    private int prioridad; // 1 (Baja) a 5 (Alta)
    private String especialidad;
    private String estado; // Pendiente, Resuelto

    public Ticket(String descripcion, String dificultad, int prioridad, String especialidad) {
        this.descripcion = descripcion;
        this.dificultad = dificultad;
        this.prioridad = prioridad;
        this.especialidad = especialidad;
        this.estado = "Pendiente";
    }

    // Getters y Setters
    public String getDescripcion() { return descripcion; }
    public String getDificultad() { return dificultad; }
    public int getPrioridad() { return prioridad; }
    public String getEspecialidad() { return especialidad; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getEstado() { return estado; }
}