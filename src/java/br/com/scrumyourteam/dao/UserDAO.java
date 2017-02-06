package br.com.scrumyourteam.dao;

import br.com.scrumyourteam.bean.User;
import br.com.scrumyourteam.persistence.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcella
 * Date: 02/06/2017
 * Objective: Create a Crud for a User
 */

public class UserDAO
{
    private Connection conn;
    
    public UserDAO()
    {
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void addUser(User user) throws SQLException 
    {
        try {
            String sql = "insert into User (idUser ,nameUser ,login ,password)"
                    + "values (?      ,?        ,?     ,?       );";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, user.getIdUser());
            psmt.setString(2, user.getNameUser());
            psmt.setString(3, user.getLogin());
            psmt.setString(4, user.getPassword());
            
            psmt.execute();
            psmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error to execute addUser in UserDAO: " + ex);
        }finally{
            conn.close();
        }
    }
    
    public void updateUser(User user) throws SQLException 
    {
        try {
            String sql = "update User set"
                            + "nameUser = ?"
                            + ",login    = ?"
                            + ",password = ?"
                        + "where idUser = ?;";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getNameUser());
            psmt.setString(2, user.getLogin());
            psmt.setString(3, user.getPassword());
            psmt.setInt(4, user.getIdUser());
            
            psmt.execute();
            psmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error to execute updateUser in UserDAO: " + ex);
        }finally{
            conn.close();
        }
    }
    
    public void removeUser(int idUser) throws SQLException 
    {
        try {
            String sql = "delete from User "
                        + "where idUser = ?;";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1, idUser);
            
            psmt.execute();
            psmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException("Error to execute removeUser in UserDAO: " + ex);
        }finally{
            conn.close();
        }
    }
    
    public User getUser (int idUser) throws SQLException
    {
        try {
            String sql = "select * from User"
                    + "where idUser = ?;";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            User user = new User();
            while(rs.next())
            {
                user.setIdUser(rs.getInt("idUser"));
                user.setNameUser(rs.getString("nameUser"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException("Error to execute getUser in UserDAO: " + ex);
        }finally{
            conn.close();
        }
    }
    
    public List<User> getUserList (int idUser) throws SQLException
    {
        try {
            String sql = "select * from User;";
            
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            ArrayList<User> userList = new ArrayList<User>();
            while(rs.next())
            {
                User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNameUser(rs.getString("nameUser"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException ex) {
            throw new RuntimeException("Error to execute getUserList in UserDAO: " + ex);
        }finally{
            conn.close();
        }
    }
    
}
