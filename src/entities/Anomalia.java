package entities;

public class Anomalia extends Entidad {
    private int nivelSeveridad;
    private String ubicacion;

    public Anomalia(int id, String nombre, int nivelSeveridad, String ubicacion) {
        super(id, nombre);
        this.nivelSeveridad = nivelSeveridad;
        this.ubicacion = ubicacion;
    }

    public int getNivelSeveridad() {
        return nivelSeveridad;
    }

    public void setNivelSeveridad(int nivelSeveridad) {
        this.nivelSeveridad = nivelSeveridad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nivel de Severidad: " + nivelSeveridad + ", Ubicación: " + ubicacion;
    }
}
