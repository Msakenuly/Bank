package com.example.okno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Config {
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
      String connectionString = "jdbc:mysql://127.0.0.1:3306/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) throws SQLException, ClassNotFoundException {

        String insert = "INSERT INTO`bbb`.`table1`(`firstname`,`fullname`,`username`,`password`,`gender`)VALUES('"+
                        user.getFirstname()+"','"+user.getFullname()+"','"+user.getUsername()+"','"+user.getPassword()
                +"','"+user.getGender()+"');";
          PreparedStatement prSt=getDbConnection().prepareStatement(insert);
        int status =prSt.executeUpdate();
        if(status!=0){
            System.out.println("Database was Con");
        }
    }
   public ResultSet getUser(User user){
        ResultSet resSet;
        String select = "SELECT * FROM `bbb`.`table1` WHERE username=? AND password=?";
       PreparedStatement prSt;
       try {
           prSt = getDbConnection().prepareStatement(select);
           prSt.setString(1,user.getUsername());
           prSt.setString(2,user.getPassword());
       } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException(e);
       }
       try {
           resSet=prSt.executeQuery();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return resSet; }
}
