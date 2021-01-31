/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Javier
 * 
 * Aquí tenemos nuestro método main desde donde ponemos la vista visible e inicíamos la conexión
 */
public class ConexionBBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Vista _vista = new Vista();
             
        //Ponemos la vista visible
        _vista.setVisible(true);
        
        //Cerramos la conexión al cerrar la aplicación
        _vista.addWindowListener(new WindowAdapter() {
            
            @Override
            
            public void windowClosing(WindowEvent e) {
                
                _vista.gbbdd.cerrar_conexion();
                
                System.exit(0);
                
            }
        });
    }   

}
