package br.com.scrumyourteam.persistence;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcella
 * Date: 02/06/2017
 * Objective: Create a JDBC Connection with a MySQL Database
 */

public class ConnectionFactory 
{
    private String url = "jdbc:mysql://localhost/ScrumYourTeam";
    private String user = "root";
    private String password = "root";
    
    public Connection getConnection()
    {
    
        try {
            //this command register the driver, without it, it doesn't work
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return (Connection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get a new Connection: " + e);
        }
        
    }
    
}
