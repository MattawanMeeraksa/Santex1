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
    private int list;
    
    public String show() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from LIST");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.print("List plan : ");
            System.out.println(rs.getString("listName"));
            System.out.print("Description : ");
            System.out.println(rs.getString("descriptionList"));
            System.out.print("Reps : ");
            System.out.println(rs.getString("reps"));
            System.out.print("Set : ");
            System.out.println(rs.getString("`set`"));
            System.out.println("--------------------------------------------------");
            
        }
        return "";
    }
    
    public String create(String listPlanName, String description,int reps, int set, int list) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("insert into LIST(listName,descriptionList,reps,`set`,list_planID) values (?,?,?,?,?)");
        pstm.setString(1, listPlanName);
        pstm.setString(2, description);
        pstm.setInt(3, reps);
        pstm.setInt(4, set);
        pstm.setInt(5, list);
        int rs = pstm.executeUpdate();
        System.out.println(rs);

        return "";
    }
     public void editListPlanName(String oldListPlanName,String newListPlanName,String description,int reps ,int set) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update LIST set listName='" + newListPlanName + "'where listName ='"
                                                        + oldListPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDescription(String listPlanName, String oldDescription,String newDescription, int reps, int set) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update LIST set descriptionList ='" + newDescription + "'where descriptionList  ='" 
                                                        + oldDescription+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editReps(String listPlanName, String description ,int newReps, int oldReps, int set) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update LIST set reps='" + newReps + "'where reps ='" 
                                                        + oldReps+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void edistSet(String listPlanName, String description ,int reps, int oldSet, int newSet) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        this.show();
        PreparedStatement pstm = conn.prepareStatement("update LIST set `set`='" + newSet + "'where `set` ='" 
                                                        + oldSet+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void delete(String listPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("delete from LSIT where listPlanName=?");
        pstm.setString(1, listPlanName);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
}
