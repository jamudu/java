//clase para trabajar con la BBDD

package dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pelicula;

/**
 *
 * @author usu21
 */
public class PeliculaJDBC {   
    private Connection conexion;
    
    //funcion insertar pelicula
    public boolean insertarPelicula(Pelicula p){
        conectar();
        if (conexion != null){
            boolean ok = false;
            try {
                String insertar = "insert into pelicula values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(insertar);
                ps.setString(1, p.getCodigo());
                ps.setString(2, p.getTitulo());
                ps.setInt(3, p.getDuracion());
                ps.setString(4, p.getGenero());
                ps.setInt(5, p.getValoracion());
                ps.setBoolean(6, p.isVisto());
                ps.executeUpdate();     //ejecuta la consulta
                ps.close();             //liberamos recursos
                ok = true;
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al insertar: " +ex.getMessage());
                ok = false;
            }finally{
                desconectar();
            }
            return ok;
        }else{
            return false;
        }
    }
    
    //funcion abrir conexion SQL
    private void conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/videoclub";
            String user="root";
            String password = "jeveris";
            Connection con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }
    
   //funcion para desconectar conexion SQL
    private void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}
