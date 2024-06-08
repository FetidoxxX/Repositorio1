/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael Carvajal 
 */
public class ConexionBD {
  private Connection conexion;
  private String bd,usuario, clave,mensaje;
    public ConexionBD(Connection conexion, String bd, String usuario, String clave, String mensaje) {
        this.conexion = conexion;
        this.bd = bd;
        this.usuario = usuario;
        this.clave = clave;
        this.mensaje = mensaje;
    }
   public ConexionBD() {
        this.conexion = null;
        this.bd = "multiprod";
        this.usuario = "root";
        this.clave = "Maicol11271127"; 
        this.mensaje = "";
    }
public void conectar(){
    boolean resp=true;
      try {
          Class.forName("com.mysql.jdbc.Driver");// SE CONFIGURA DRIVER  
          String ruta="jdbc:mysql://localhost:3306/"+bd;// ENS ASA FUNCIONARIA POR LO QUE ES LOCAL  
          //String ruta="jdbc:mysql://10.28.0.49:33150/"+bd;// RUTA CON EL SERVIDOR  
          System.out.println(ruta);
          conexion= DriverManager.getConnection(ruta,usuario,clave);
          if (conexion!=null){
          mensaje="Conexion establecida con éxito...";}
          else
          mensaje="No se pudo establecer conexion...";
      } catch (ClassNotFoundException ex) {
          mensaje="No se pudo establecer conexion...";
      } catch (SQLException ex) {
           mensaje=" No se puede conectar con MySQL...";// LO GENERA  conexion= DriverManager.getConnection( INTENTANDO ESTABLECER EL USO DE LA BASE DE DATOS  
      }
     
}  
    @Override
    public String toString() {
        return "\n Conexion: " + conexion + "\n bd: " + bd + "\n usuario: " + usuario + "\n clave: " + clave + "\n mensaje: " + mensaje;
    }
    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    public String getBd() {
        return bd;
    }
    public void setBd(String bd) {
        this.bd = bd;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }  
}
