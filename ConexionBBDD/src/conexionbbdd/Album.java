/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Javier
 * 
 * Esta clase nos permite crear objetos que tienen los datos de un álbum
 */
public class Album {

    private String id, nombre, grupo;
    
    private int publicacion;

    /**
     * 
     * @param _id: id del álbum
     * @param _nombre: Nombre del álbum
     * @param _grupo: Nombre del grupo
     * @param _publicacion: Año de publicación 
     */
    public Album(String _id, String _nombre, String _grupo, int _publicacion) {

        this.id = _id;
        this.nombre = _nombre;
        this.grupo = _grupo;
        this.publicacion = _publicacion;
    }
    
    public String getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getGrupo(){
        return grupo;
    }
    
    public int getPublicacion(){
        return publicacion;
    }

}
