
package model;


public class Videojuego implements Cloneable{
    private String nombre;
    private String plataforma;
    private String genero;
    private int precio;

    public Videojuego(String nombre, String plataforma, String genero, int precio) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.genero = genero;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public Videojuego clonar() {
        try {
            return (Videojuego) this.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Error al clonar el videojuego.");
            return null;
        }
    }
    
    @Override
    public String toString() {
        return nombre + " (" + plataforma + ") - " + genero + " - $" + precio;
    }
}
