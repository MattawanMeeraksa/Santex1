/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.MySQLConnect;

/**
 *
 * @author user
 */
public class ListPlan {
    private String listPlanName;
    private String description;
    private int reps;
    private int set;
    
    public String show() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from test");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.print("List plan : ");
            System.out.println(rs.getString("username"));
            System.out.print("Description : ");
            System.out.println(rs.getString("password"));
        }
        return "";
    }
    
    public String create(String listPlanName, String description,int reps) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("insert into test(username,password,reps) values (?,?,?)");
        pstm.setString(1, listPlanName);
        pstm.setString(2, description);
        pstm.setInt(3, reps);
        int rs = pstm.executeUpdate();
        System.out.println(rs);

        return "--------------List plan : " + listPlanName + "--------------"
                + "\nHow many reps do you want to do : " + reps + " reps";
    }
     public void editListPlanName(String oldListPlanName,String newListPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set username='" + newListPlanName + "'where username ='"
                                                        + oldListPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDescription(String listPlanName,String oldDescription,String newDescription, int reps) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set password='" + newDescription + "'where password ='" 
                                                        + oldDescription+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editReps(String listPlanName,String description ,int oldReps,int newReps) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update test set reps='" + newReps + "'where reps ='" 
                                                        + oldReps+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void delete(String ListplanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("delete from test where username=?");
        pstm.setString(1, ListplanName);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
}
