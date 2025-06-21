
package model;


public class AdaptadorCatalogoTexto implements FormatoCatalogo {
    @Override
    public String mostrarCatalogo(Catalogo catalogo) {
        StringBuilder sb = new StringBuilder();
        sb.append("Catalogo de Videojuegos:\n");
        
        CatalogoIterator iterator = catalogo.crearIterator();
        while (iterator.hasNext()) {
            Videojuego juego = iterator.next();
            sb.append("- ").append(juego.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
