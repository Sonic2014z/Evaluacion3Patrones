package model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Videojuego> videojuegos;
    
    public Catalogo() {
        this.videojuegos = new ArrayList<>();
    }
    
    public void agregarVideojuego(Videojuego juego) {
        videojuegos.add(juego);
    }
    
    public List<Videojuego> obtenerVideojuegos() {
        return videojuegos;
    }
    
    public CatalogoIterator crearIterator() {
        return new CatalogoIterator(videojuegos);
    }
}
