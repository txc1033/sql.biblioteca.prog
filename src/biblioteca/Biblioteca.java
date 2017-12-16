/* Autor @Javifast | @Txc1033 */
package biblioteca;

import java.sql.*;
import javax.swing.JOptionPane;

public class Biblioteca {

    static Connection cn = null;

    public static Connection Enlace(Connection cn) throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:Biblioteca.sqlite");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }

}
