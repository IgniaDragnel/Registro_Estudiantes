package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
    private static Connection conn;
    private static final String driver= "com.mysql.jdbc.Driver";
    private static final String user= "";
    private static final String password= "";
    private static final String url = "j";
    
    //Metodo Constructor

    public Conectar() {
        conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Conexion establecida..");
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar"+e);
        }
    }
    //Este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    //Este metodo nos desconectamos de la base de datos
    public void desconectar(){
        conn= null;
        if(conn==null){
            System.out.println("Conexion terminada...");
        }
    }
}
