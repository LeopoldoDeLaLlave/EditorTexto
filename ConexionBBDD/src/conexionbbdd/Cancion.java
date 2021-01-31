/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;

/**
 *
 * @author Javier
 * 
 * Esta clase nos permite crear objetos que tienen los datos de una canción
 */
public class Cancion {

    private String id, nombre, album, duracion;
    
    /**
     * 
     * @param _id: id de la canción
     * @param _nombre: Nombre de la canción
     * @param _album: ID del álbum al que pertenece la canción
     * @param _duracion: Duración de la canción
     */
    public Cancion(String _id, String _nombre, String _album, String _duracion) {

        this.id = _id;
        this.nombre = _nombre;
        this.album = _album;
        this.duracion = _duracion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlbum() {
        return album;
    }

    public String getDuracion() {
        return duracion;
    }
}
