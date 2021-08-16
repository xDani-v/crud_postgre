/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Daniel Jazmany Villano Escobar
 * @correo danielvillanoescobar@outlook.com
 * @fecha 13 ago. 2021
 * @version 1.0v
 */
public class Coneccion {

    private static String user = "postgres";
    private static String password = "estudiante2000";
    private static String url = "jdbc:postgresql://localhost:5432/empleados";
    private static Connection con;
    
    public static Connection initConnection() {
        try {
        
             con = DriverManager.getConnection(url, user, password);
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
  
}
