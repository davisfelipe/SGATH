package DB;

import Sesion.Sesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author davis
 */
public class AccesoUsuarios {
    private final Oracle database;
    private PreparedStatement preparar;
    private ResultSet resultado;

    public AccesoUsuarios() {
        this.database = new Oracle();
    }
    public boolean buscarUsuario(String usuario, String contraseña){
        boolean respuesta=false;
        try {
            preparar=database.abrirConexion().prepareStatement("select password from empleado where usuario=?");
            preparar.setString(1, usuario);
            resultado=preparar.executeQuery();
            resultado.next();
            if(resultado.getString(1).equals(contraseña)){
                respuesta=true;
            }else{
                respuesta=false;
            }
        } catch (SQLException ex) {
        }
        return respuesta;
    }
    public String buscarIdentificacion(String usuario){
        String respuesta=null;
        try {
            preparar=database.abrirConexion().prepareStatement("select nomemp||' '||apelemp from empleado where usuario=?");
            preparar.setString(1, usuario);
            resultado=preparar.executeQuery();
            resultado.next();
            respuesta=resultado.getString(1);
        } catch (SQLException ex) {
        }
        return respuesta;
    }
    public void asignarIdentificacion(String user) {
        Sesion sesion = Sesion.getInstance();
        try {
            preparar=database.abrirConexion().prepareStatement("select nomemp, apelemp from empleado where usuario=?");
            preparar.setString(1, user);
            resultado=preparar.executeQuery();
            resultado.next();
            sesion.iniciarSesion(resultado.getString(1), resultado.getString(2));
//To change body of generated methods, choose Tools | Templates.
        } catch (SQLException ex) {
        }
    }
    public String obtenerCargo(String user){
        String respuesta=null;
        try {
            preparar=database.abrirConexion().prepareStatement("select c.descargo from empleado e, cargo c where c.idcargo=e.idcargo_fk and e.usuario=?");
            preparar.setString(1, user);
            resultado=preparar.executeQuery();
            resultado.next();
            respuesta=resultado.getString(1);
        } catch (SQLException ex) {
        }
        return respuesta;
    }
}
