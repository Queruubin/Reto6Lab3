package com.reto6;

public abstract class Tecnico {
    protected Tecnico siguiente;
    protected String nivel;
    protected String especialidad;
    protected int maxPrioridad;

    public void setSiguiente(Tecnico siguiente) {
        this.siguiente = siguiente;
    }

    public void procesar(Ticket ticket) {
        if (puedeResolver(ticket)) {
            ticket.setEstado("Resuelto");
            System.out.println("Ticket: " + nivel + " resolvió el problema.");
        } else if (siguiente != null) {
            System.out.println("Técnico " + nivel + " no pudo resolver. Escalando...");
            siguiente.procesar(ticket);
        } else {
            System.out.println("Ticket pendiente de escalamiento. Ningún técnico disponible.");
        }
    }

    private boolean puedeResolver(Ticket ticket) {
        return ticket.getDificultad().equalsIgnoreCase(this.nivel) &&
               ticket.getEspecialidad().equalsIgnoreCase(this.especialidad) &&
               ticket.getPrioridad() <= this.maxPrioridad;
    }

    public class TecnicoBasico extends Tecnico {
    public TecnicoBasico(String especialidad) {
        this.nivel = "Basico";
        this.especialidad = especialidad;
        this.maxPrioridad = 2; // Solo resuelve prioridad baja
    }
  }

  public class TecnicoIntermedio extends Tecnico {
      public TecnicoIntermedio(String especialidad) {
          this.nivel = "Intermedio";
          this.especialidad = especialidad;
          this.maxPrioridad = 4;
      }
  }

  public class TecnicoAvanzado extends Tecnico {
      public TecnicoAvanzado(String especialidad) {
          this.nivel = "Avanzado";
          this.especialidad = especialidad;
          this.maxPrioridad = 5;
      }
  }
}

