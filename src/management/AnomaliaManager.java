package management;

import entities.Anomalia;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AnomaliaManager {
    private ArrayList<Anomalia> anomalias;

    public AnomaliaManager() {
        this.anomalias = new ArrayList<>();
    }

    public void registrarAnomalia() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID de la anomalía: ");
        ConsoleUtils.limpiarBuffer();

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre de la anomalía: ");
        int severidad = ConsoleUtils.leerEntero("Ingrese el nivel de severidad (1-10): ");
        String ubicacion = ConsoleUtils.leerTexto("Ingrese la ubicación de la anomalía: ");
        
        Anomalia nuevaAnomalia = new Anomalia(id, nombre, severidad, ubicacion);
        anomalias.add(nuevaAnomalia);
        System.out.println("Anomalía registrada con éxito.");
    }

    public void mostrarAnomalias() {
        if (anomalias.isEmpty()) {
            System.out.println("No hay anomalías registradas.");
            return;
        }
        System.out.println("=== Lista de Anomalías ===");
        for (Anomalia anomalia : anomalias) {
            System.out.println(anomalia);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Anomalías ===");
            System.out.println("1. Registrar Anomalía");
            System.out.println("2. Mostrar Anomalías");
            System.out.println("3. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer();

            switch (opcion) {
                case 1:
                    registrarAnomalia();
                    break;
                case 2:
                    mostrarAnomalias();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }            
        }
    }
}
