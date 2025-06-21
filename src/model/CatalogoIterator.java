
package model;

import java.util.Iterator;
import java.util.List;


public class CatalogoIterator implements Iterator<Videojuego>{
    private List<Videojuego> videojuegos;
    private int posicionActual = 0;

    public CatalogoIterator(List<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
    
    @Override
    public boolean hasNext() {
        return posicionActual < videojuegos.size();
    }
    
    @Override
    public Videojuego next() {
        return videojuegos.get(posicionActual++);
    }
}
