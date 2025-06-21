
package model;


public class AdaptadorCatalogoJSON implements FormatoCatalogo{
    @Override
    public String mostrarCatalogo(Catalogo catalogo) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        
        CatalogoIterator iterator = catalogo.crearIterator();
        while (iterator.hasNext()) {
            Videojuego juego = iterator.next();
            sb.append(" {\n")
                    .append("    \"nombre\": \"").append(juego.getNombre()).append("\",\n")
                    .append("    \"plataforma\": \"").append(juego.getPlataforma()).append("\",\n")
                    .append("    \"genero\": \"").append(juego.getGenero()).append("\",\n")
                    .append("    \"precio\": ").append(juego.getPrecio()).append("\n")
                    .append("  }");
            
            if (iterator.hasNext()) sb.append(",");
            sb.append("\n");
        }
        
        sb.append("]");
        return sb.toString();
    }
}
