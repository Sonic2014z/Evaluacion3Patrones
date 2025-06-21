package app;

import java.util.Scanner;
import model.AdaptadorCatalogoJSON;
import model.AdaptadorCatalogoTexto;
import model.Catalogo;
import model.CatalogoIterator;
import model.FormatoCatalogo;
import model.GestorCatalogo;
import model.Videojuego;


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = GestorCatalogo.getInstance();
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Agregar videojuego nuevo");
            System.out.println("2. Agregar edición especial de juego existente (Prototype)");
            System.out.println("3. Mostrar catálogo (Texto)");
            System.out.println("4. Mostrar catálogo (JSON)");
            System.out.println("5. Recorrer catálogo (Iterator)");
            System.out.println("6. Salir del programa");
            System.out.println("\n Seleccione una de las opciones: ");
            
            String opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.println("Plataforma: ");
                    String plataforma = scanner.nextLine();
                    
                    System.out.println("Genero: ");
                    String genero = scanner.nextLine();
                    
                    System.out.println("Precio: ");
                    int precio = Integer.parseInt(scanner.nextLine());
                    
                    Videojuego nuevo = new Videojuego(nombre, plataforma, genero, precio);
                    catalogo.agregarVideojuego(nuevo);
                    System.out.println("Videojuego "+ nombre +" agregado al catálogo.");
                    break;
                    
                case "2":
                    if (catalogo.obtenerVideojuegos().isEmpty()) {
                        System.out.println("No hay videojuegos registrados en el catálogo.");
                        break;
                    }
                    
                    System.out.println("Elija el número del videojuego para agregar una edición especial:");
                    int index = 1;
                    for (Videojuego juego : catalogo.obtenerVideojuegos()) {
                        System.out.println(index +". " + juego.getNombre());
                        index++;
                    }
                    int seleccion = Integer.parseInt(scanner.nextLine()) - 1;
                    
                    if (seleccion < 0 || seleccion >= catalogo.obtenerVideojuegos().size()) {
                        System.out.println("Opción inválida.");
                        break;
                    }
                    
                    Videojuego base = catalogo.obtenerVideojuegos().get(seleccion);
                    Videojuego edicion = base.clonar();
                    
                    System.out.println("Nombre de la edición del videojuego: ");
                    System.out.println("Ejemplo: [Nombre del juego] | --> [Nombre de la edicion] <-- Lo que editarás.");
                    edicion.setNombre(base.getNombre() + " | " + scanner.nextLine());
                    
                    System.out.println("Precio de la edición: ");
                    edicion.setPrecio(Integer.parseInt(scanner.nextLine()));
                    
                    catalogo.agregarVideojuego(edicion);
                    System.out.println(edicion.getNombre() + " agregado correctamente.");
                    break;
                 
                case "3":
                    FormatoCatalogo texto = new AdaptadorCatalogoTexto();
                    System.out.println(texto.mostrarCatalogo(catalogo));
                    break;
                    
                case "4":
                    FormatoCatalogo json = new AdaptadorCatalogoJSON();
                    System.out.println(json.mostrarCatalogo(catalogo));
                    break;
                    
                case "5":
                    CatalogoIterator iterator  = catalogo.crearIterator();
                    System.out.println("Recorriendo catálogo:");
                    while (iterator.hasNext()) {
                        System.out.println("- " + iterator.next());
                    }
                    break;
                    
                case "6":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción inválida.");
            }
        }
        
        scanner.close();
    } 
}
