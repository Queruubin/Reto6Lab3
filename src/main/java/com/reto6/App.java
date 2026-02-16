package com.reto6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    private static final String ESPECIALIDAD_REDES = "Redes";
    
    public static void main( String[] args )
    {
        ejecutar();
    }
    
    public static void ejecutar() {
        // Configuración de la cadena
        Tecnico basico = new TecnicoBasico(ESPECIALIDAD_REDES);
        Tecnico intermedio = new TecnicoIntermedio(ESPECIALIDAD_REDES);
        Tecnico avanzado = new TecnicoAvanzado(ESPECIALIDAD_REDES);

        basico.setSiguiente(intermedio);
        intermedio.setSiguiente(avanzado);

        List<Ticket> tickets = new ArrayList<>();
        System.out.println("Ingrese la cantidad de tickets:");
        Scanner sc = new Scanner(System.in);
        int cantidadTickets = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < cantidadTickets; i++) {
            System.out.println("Ingrese descripción: ");
            String descripcion = sc.nextLine();
            System.out.println("Ingrese dificultad (1-Basico, 2-Intermedio, 3-Avanzado): ");
            int dificultadInput = sc.nextInt();
            String dificultad = dificultadInput == 1 ? "Basico" : dificultadInput == 2 ? "Intermedio" : "Avanzado";
            System.out.println("Ingrese prioridad (1-5): ");
            int prioridad = sc.nextInt();

            sc.nextLine();

            tickets.add(new Ticket(descripcion, dificultad, prioridad, ESPECIALIDAD_REDES));
        }

        // Procesamiento
        tickets.forEach(basico::procesar);

        // Estadísticas con Streams 
        System.out.println("\n--- Estadísticas ---");
        long resueltos = tickets.stream().filter(t -> t.getEstado().equals("Resuelto")).count();
        long pendientes = tickets.stream().filter(t -> t.getEstado().equals("Pendiente")).count();
        
        System.out.println("Tickets resueltos: " + resueltos);
        System.out.println("Tickets pendientes: " + pendientes);
        
        tickets.stream()
            .filter(t -> t.getEstado().equals("Resuelto"))
            .mapToInt(Ticket::getPrioridad)
            .average()
            .ifPresent(avg -> System.out.println("Promedio de prioridad resueltos: " + avg));
    }
}
