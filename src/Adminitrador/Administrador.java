/* Autor @Javifast */
package Adminitrador;
import biblioteca.Biblioteca;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Administrador {
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo= new DefaultTableModel();
    DefaultTableModel modelo1= new DefaultTableModel();

  
    public DefaultTableModel lista(){
        
    try{
    cn = Biblioteca.Enlace(cn);
    Statement s= cn.createStatement();
    
    String SQL = "select * from LIBROS";
    rs = s.executeQuery(SQL);
   ResultSetMetaData rsmd=rs.getMetaData();
   
   int CanColumns = rsmd.getColumnCount();
   
   for(int i=1;i<=CanColumns;i++){
    
   modelo.addColumn(rsmd.getColumnLabel(i));
   }
   while (rs.next()){
   
       Object[] fila=new Object[CanColumns];
   
   for(int i=0;i<CanColumns;i++){
   fila[i] = rs.getObject(i+1);
   }
   modelo.addRow(fila);
   }
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
    return modelo;
    
    }
    
    
    public void AgregarConsulta(int id,String nombre,String autor){
    
        try
        {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            cn.setAutoCommit(false);
            
            s = cn.createStatement();
            
            String SQL = "INSERT INTO libros (id,nombre,autor) " +
                    "VALUES ('"+id+"','"+nombre+"','"+autor+"')";
            s.executeUpdate(SQL);
            s.close();
            cn.commit();
            cn.close();
        JOptionPane.showMessageDialog(null, "AGREGADO");
        }catch(Exception e){JOptionPane.showMessageDialog(null, "No se a podido agregar");}
    }
        
        public void EliminarConsulta(String id){
       try{
       Statement s=cn.createStatement();
       String SQL="DELETE FROM libros WHERE id="+id+"";
       s.executeUpdate(SQL);
       s.close();
       cn.close();
       JOptionPane.showMessageDialog(null, "ELIMINADO");
       }catch(Exception e){JOptionPane.showMessageDialog(null, "No se a podido eliminar");}
        
        }
        

            public DefaultTableModel lista1(){
        
    try{
    cn = Biblioteca.Enlace(cn);
    Statement s= cn.createStatement();
    
    String SQL = "select * from clientes";
    rs = s.executeQuery(SQL);
   ResultSetMetaData rsmd=rs.getMetaData();
   
   int CanColumns = rsmd.getColumnCount();
   
   for(int i=1;i<=CanColumns;i++){
    
   modelo1.addColumn(rsmd.getColumnLabel(i));
   }
   while (rs.next()){
   
       Object[] fila=new Object[CanColumns];
   
   for(int i=0;i<CanColumns;i++){
   fila[i] = rs.getObject(i+1);
   }
   modelo1.addRow(fila);
   }
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
    return modelo1;
    
    }
    
    
    public void AgregarConsulta1(int id,String nombre,String apellido,String rut,String edad){
    
        try
        {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            cn.setAutoCommit(false);
            
            s = cn.createStatement();
            
            String SQL = "INSERT INTO clientes (id,nombre,apellido,rut,edad) " +
                    "VALUES ('"+id+"','"+nombre+"','"+apellido+"','"+rut+"','"+edad+"')";
            s.executeUpdate(SQL);
            s.close();
            cn.commit();
            cn.close();
        JOptionPane.showMessageDialog(null, "AGREGADO");
        }catch(Exception e){JOptionPane.showMessageDialog(null, "No se a podido agregar");}
    }
        
        public void EliminarConsulta1(String id){
       try{
       Statement s=cn.createStatement();
       String SQL="DELETE FROM clientes WHERE id="+id+"";
       s.executeUpdate(SQL);
       s.close();
       cn.close();
       JOptionPane.showMessageDialog(null, "ELIMINADO");
       }catch(Exception e){JOptionPane.showMessageDialog(null, "No se a podido eliminar");}
        
        }
        
           public void crearl()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            s = cn.createStatement();
            String SQL = "CREATE TABLE libros(id INT PRIMARY KEY AUTOINCREMENT NOT NULL,nombre VARCHAR NULL,autor VARCHAR  NULL);" ;
            s.executeUpdate(SQL);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Tabla Libros Creada");
        }catch(Exception e){JOptionPane.showMessageDialog(null, "ya esta creada");}
 
        }
  
                   public void crearc()
    {
        
        try
        {
            Class.forName("org.sqlite.JDBC");
            cn = DriverManager.getConnection("jdbc:sqlite:biblioteca.sqlite");
            s = cn.createStatement();
            String SQL = "CREATE TABLE clientes" + 
                    "(id        INT     PRIMARY KEY AUTOINCREMENT NOT NULL,nombre    VARCHAR   NULL,apellido    VARCHAR    NULL,rut VARCHAR UNIQUE NULL,edad  VARCHAR NULL);" ;
            s.executeUpdate(SQL);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Tabla Clientes Creada");
        }catch(Exception e){JOptionPane.showMessageDialog(null, "ya esta creada");}
 
        }
    }

