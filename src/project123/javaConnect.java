/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project123;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
/**
 *
 * @author Ruhi ÇELİK
 */

public class javaConnect {
    Connection conn=null;
    
    public static Connection ConnectDb() {
        try{
        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Ruhi ÇELİK\\Documents\\NetBeansProjects\\Projec123JPA\\Project123.sqlite");
          
        return conn;
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
            return null;
        }
            
    }
    public void baglanJPA(){
        EntityManager em=Persistence.createEntityManagerFactory("projec123JPAPU").createEntityManager();
    }
    
    public static String normTablo;
    public static int sicil;
    public static String odDis;
    public static int frameid;
}
