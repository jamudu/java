//clase para trabajar con la BBDD

package dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ListaPelicula;
import modelo.Pelicula;

/**
 *
 * @author usu21
 */
public class PeliculaJDBC {   
    private Connection conexion;
    
    public ListaPelicula selectAllpeliculas(){
        ListaPelicula ListaPeliculas=new ListaPelicula();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from pelicula";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Pelicula pe=new Pelicula();
                    pe.setCodigo(rs.getString("codigo"));  // =  rs.getString(1)
                    pe.setTitulo(rs.getString("titulo"));
                    pe.setDuracion(rs.getInt("duracion"));
                    pe.setGenero(rs.getString("genero"));
                    pe.setValoracion(rs.getInt("valoracion"));
                    pe.setVisto(rs.getBoolean("visto"));
                    ListaPeliculas.altaPelicula(pe);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la consulta "+ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return ListaPeliculas;
    }
    
    //funcion que comprueba si una pelicula existe, no recogemos el resultado de la busqueda
    public boolean existePelicula(String codigo){
        conectar();
        if (conexion !=null){
            try {
                String query = "select *from pelicula where codigo='" + codigo + "'";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean existe=false;
                if (rs.next()){
                    existe= true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al consultar"+ex.getMessage());
                return false;
            }finally {
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcion insertar pelicula
    public boolean insertarPelicula(Pelicula p){
        conectar();
        if (conexion != null){
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
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al insertar: " +ex.getMessage());
                return false;
            }finally{
                desconectar();
            }
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
            conexion = DriverManager.getConnection(url, user, password);
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
