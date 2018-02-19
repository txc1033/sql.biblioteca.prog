/* Autor @Javifast | @Txc1033 */
package com.javifast.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {

    public static Connection Enlace(Connection conection) throws SQLException {
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/biblioteca?&useSSL=false",
                                                    "test", "12345");    
        } catch (ClassNotFoundException e) {                               
            JOptionPane.showMessageDialog(null, e);
        }
        return conection;
    }
}

