package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");
        int nivel = ConsoleUtils.leerEntero("ingrese el nivel inicial del agente");

        Agente nuevoAgente = new Agente(id, nombre, habilidad, nivel);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Subir Nivel de un Agente");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1:
                    registrarAgente();
                    break;
                case 2:
                    mostrarAgentes();
                    break;
                case 3:
                    subirNivel();
                    break;
                case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            
        }
    }

    public void subirNivel() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente para subir de nivel: ");
        ConsoleUtils.limpiarBuffer();
        boolean encontrado = false;

        for (Agente agente : agentes) {
            if (agente.getId() == id) {
                int nivelActual = agente.getNivel(); // Supone que la clase Agente tiene un atributo nivel y su getter.
                agente.setNivel(nivelActual + 1); // Incrementa el nivel en 1.
                System.out.println("El agente " + agente.getNombre() + " ha subido de nivel. Nuevo nivel: " + agente.getNivel());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Agente no encontrado.");
        }
    }
}
