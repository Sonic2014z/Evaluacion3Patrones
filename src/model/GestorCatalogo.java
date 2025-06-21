/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author juego
 */
public class GestorCatalogo {
    private static Catalogo instanciaCatalogo = null;

    public GestorCatalogo() {
    }
    
    public static Catalogo getInstance() {
        if (instanciaCatalogo == null) {
            instanciaCatalogo = new Catalogo();
        }
        return instanciaCatalogo;
    }
}
