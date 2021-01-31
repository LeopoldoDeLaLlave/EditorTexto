/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbbdd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Javier
 *
 * Aquí tenemos todas las funciones que se comunican con la base de datos
 */
public class GestorBBDD {

    Connection connl;

    //Abre la conexión con la base de datos
    //Devolverá 1 si la conexión se ha establecido con exito y 0 si ha habido error
    public int abrir_conexion() {

        try {

            //Ponemos las credenciales de nuestra base de datos
            String urll = "jdbc:mysql://localhost:3306/discografica";
            String user = "ROOT";
            String password = "ROOT";

            connl = DriverManager.getConnection(urll, user, password);

            //Si la conexión ha tenido exito informamos de ello
            if (connl != null) {
                System.out.println("Conectado a discográfica");
                return 1;
            }
        } catch (SQLException ex) {
            //En caso de que haya algún error informamos
            System.out.println("Error en la conexión a la base de datos");
            ex.printStackTrace();
            return 0;
        }
        return 0;
    }

    //Cierra la conexión con la base de datos
    public void cerrar_conexion() {
        try {
            connl.close();
            System.out.println("Cerrado con exito");
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //Añade la columna de duración a la tabla canción
    public void addColumn() {

        //En caso de que ya esté creada no se ejecutará
        try {
            Statement st = connl.createStatement();
            st.executeUpdate("ALTER TABLE cancion ADD duracion VARCHAR(20)");
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Inserta un ábum en la base de satos con los datos que introduzca el usuario
    //Devolverá 1 si la inserción se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _nombre: nombre del nuevo álbum
     * @param _grupo: Grupo que publicado el álbum que se va a añadir
     * @param _year: Año de publicación del ábum que se va a añadir
     * @return
     */
    public int insertarAlbum(String _nombre, String _grupo, String _year) {

        try {
            Statement st = connl.createStatement();
            st.executeUpdate("INSERT INTO album VALUE (NULL,'" + _nombre + "' , '" + _grupo + "' , '" + _year + "')");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Inserta un ábum en la base de satos con los datos que introduzca el usuario
    //Devolverá 1 si la inserción se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _nombre: Nombre de la canción que se quiere añadir
     * @param _album: Id del ábum al que pertenece la canción
     * @param _duracion: Duración de la canción
     * @return
     */
    public int insertSong(String _nombre, String _album, String _duracion) {

        try {
            Statement st = connl.createStatement();
            st.executeUpdate("INSERT INTO cancion VALUE (NULL,'" + _nombre + "' , '" + _album + "' , '" + _duracion + "')");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Elimina un album elegido por el usuario de la base de datos
    //Devolverá 1 si lel borrado se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _id: id del álbum que se quiere borrar
     * @return
     */
    public int borrarAlbum(String _id) {

        try {
            Statement st = connl.createStatement();
            st.executeUpdate("DELETE FROM album WHERE ID = '" + _id + "'");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Elimina una canción de la base de datos
    //Devolverá 1 si el borrado se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _id: id de la canción que se quiere borrar
     * @return
     */
    public int borrarCancion(String _id) {

        try {
            Statement st = connl.createStatement();
            st.executeUpdate("DELETE FROM cancion WHERE ID = '" + _id + "'");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Cambia los datos elegidos por el usuario de un álbum
    //Devolverá 1 si la modificación se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _id: id del álbum que se quiere modificar
     * @param _nombre: Nombre que va a tener el álbum tras la modificación
     * @param _grupo: Grupo que va a tener el álbum tras la modificación
     * @param _publicacion: Año de publicación que va a tener el álbum tras la
     * modificación
     * @return
     */
    public int modificarAlbum(String _id, String _nombre, String _grupo, String _publicacion) {

        try {

            Statement st = connl.createStatement();
            st.executeUpdate("UPDATE album"
                    + "            SET Nombre = '" + _nombre + "', Grupo= '" + _grupo + "'" + ", Publicacion='" + _publicacion + "'"
                    + "            WHERE id = " + _id + ";");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Cambia los datos elegidos por el usuario de una canción
    //Devolverá 1 si la modificación se ha realizado con éxito y 0 si ha habido algún error
    /**
     *
     * @param _id: Id de la canción que se quiere modificar
     * @param _nombre: Nombre que va a tener la canción tras la modificación
     * @param _duracion: Duración que va a tener la canción tras la modificación
     * @param _album_id: Álbum al que va a pertenexer la canción tras la
     * modificación
     * @return
     */
    public int modificarCancion(String _id, String _nombre, String _duracion, String _album_id) {

        try {

            Statement st = connl.createStatement();
            st.executeUpdate("UPDATE `cancion` SET `nombre` = '" + _nombre + "', `duracion` = '" + _duracion + "', `_album`='"
                    + _album_id + "' WHERE `cancion`.`id` = " + _id + ";");
            st.close();
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 0;
        }
    }

    //Obtiene todos los álbumes que hay en nuestra base de datos y los devuelve
    //en un arraylist de objetos tipo álbum
    public ArrayList<Album> getEveryAlbum() {

        Statement sta;

        try {
            sta = connl.createStatement();

            String query = "SELECT * FROM album";

            ResultSet rs = sta.executeQuery(query);

            //Aquí vamos a guardar todos los álbumes de la base de datos
            ArrayList<Album> albumes = new ArrayList<Album>();

            //Recorremos todas las tuplas que devuelve la base de datos
            while (rs.next()) {

                //Obtenemos la fecha en la que se publicó el disco
                //y nos quedamos con el años
                Date fechaPublicacion = rs.getDate("Publicacion");
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
                cal.setTime(fechaPublicacion);
                int year = cal.get(Calendar.YEAR);
                //Añadimos los valores del álbum en el que nos encontramos al arraylist
                albumes.add(new Album(rs.getString("id"), rs.getString("Nombre"), rs.getString("Grupo"), year));
            }
            return albumes;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

    //Devuelve un arraylist con los álbumes que coinciden con una búsqueda concreta
    /**
     *
     * @param _nombre: Nombre que está buscando el usuario
     * @return
     */
    public ArrayList<Album> getAlbumByName(String _nombre) {

        try {

            String query = "SELECT * FROM album WHERE Nombre LIKE ?";
            PreparedStatement pst = connl.prepareStatement(query);

            pst.setString(1, _nombre + "%");

            ResultSet rs = pst.executeQuery();

            //Aquí vamos a guardar todos los álbumes de la base de datos que coinciden con la búsqueda
            ArrayList<Album> albumes = new ArrayList<Album>();

            //Recorremos todas las tuplas que devuelve la base de datos
            while (rs.next()) {

                //Obtenemos la fecha en la que se publicó el disco
                //y nos quedamos con el años
                Date fechaPublicacion = rs.getDate("Publicacion");
                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
                cal.setTime(fechaPublicacion);
                int year = cal.get(Calendar.YEAR);

                //Añadimos los valores del álbum en el que nos encontramos al arraylist
                albumes.add(new Album(rs.getString("id"), rs.getString("Nombre"), rs.getString("Grupo"), year));
            }
            return albumes;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

    //Devuelve un arraylist con todas las canciones de un álbum concreto
    /**
     *
     * @param _album: Id del álbum del que queremos obtener todas las canciones
     * @return
     */
    public ArrayList<Cancion> getEverySong(String _album) {

        Statement sta;

        try {
            sta = connl.createStatement();

            String query = "SELECT id, Nombre, duracion FROM cancion WHERE _album='" + _album + "';";

            ResultSet rs = sta.executeQuery(query);

            //Aquía guardamos los resultados de la búsqueda
            ArrayList<Cancion> canciones = new ArrayList<Cancion>();

            //Recorremos todas las tuplas que devuelve la base de datos
            while (rs.next()) {
                //Añadimos los valores de la canción en el que nos encontramos al arraylist
                canciones.add(new Cancion(rs.getString("id"), rs.getString("nombre"), _album, rs.getString("duracion")));
            }
            return canciones;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //Devuelve un arraylist con todas las canciones de un álbum concreto que 
    //coinciden con la búsqueda del usuario
    /**
     * 
     * @param _album: id del álbum del que queremos obtener las canciones
     * @param _nombre: búsqueda del usuario
     * @return 
     */
    public ArrayList<Cancion> getSongByName(String _album, String _nombre) {

        try {

            String query = "SELECT id, Nombre, duracion FROM cancion WHERE _album=? AND nombre LIKE ?;";
            PreparedStatement pst = connl.prepareStatement(query);

            pst.setString(1, _album);
            pst.setString(2, _nombre + "%");

            ResultSet rs = pst.executeQuery();

            //Aquía guardamos los resultados de la búsqueda
            ArrayList<Cancion> canciones = new ArrayList<Cancion>();

            //Recorremos todas las tuplas que devuelve la base de datos
            while (rs.next()) {
                //Añadimos los valores de la canción en el que nos encontramos al arraylist
                canciones.add(new Cancion(rs.getString("id"), rs.getString("nombre"), _album, rs.getString("duracion")));
            }
            return canciones;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }

}
