/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DatabaseConnection {
    public static Connection getConnection() {
        String konString = "jdbc:mysql://localhost:3306/32_db_inventaris";
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(konString,"root","");
            System.out.println("Database Connected");
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Connected error");
        }
        return connection;
    }
    
    private void delete(String id, String query) {
        try {
            int berhasil = Database.DatabaseConnection.getConnection().createStatement().executeUpdate(query);
            if(berhasil==1){
                JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
