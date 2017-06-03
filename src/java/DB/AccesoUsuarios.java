package DB;

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
            JOptionPane.showMessageDialog(null,"se puteo");
        }
        return respuesta;
    }
}
