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
    
    public ListPlan(){
        
    }
    
    public static void getDataFromDB(ResultSet rs , ListPlan lp) throws SQLException {
        lp.setListPlanName(rs.getString("listName"));
        lp.setDescription(rs.getString("descriptionList"));
        lp.setReps(rs.getInt("reps"));
        lp.setSet(rs.getInt("set"));
    }
            
            
    public ResultSet show(int planId) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from LIST where list_planID = "+planId);
        ResultSet rs = pstm.executeQuery();
        /*while (rs.next()) {
            System.out.print("List plan : ");
            System.out.println(rs.getString("listName"));
            System.out.print("Description : ");
            System.out.println(rs.getString("descriptionList"));
            System.out.print("Reps : ");
            System.out.println(rs.getString("reps"));
            System.out.print("Set : ");
            System.out.println(rs.getString("set"));
            System.out.println("--------------------------------------------------");
            
        }*/
        return rs;
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
     public void editListPlanName(String oldListPlanName,String newListPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update LIST set listName='" + newListPlanName + "'where listName ='"
                                                        + oldListPlanName + "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editDescription(String oldDescription,String newDescription) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update LIST set descriptionList ='" + newDescription + "'where descriptionList  ='" 
                                                        + oldDescription+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editReps(int oldReps, int newReps) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update LIST set reps='" + newReps + "'where reps ='" 
                                                        + oldReps+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }
    
    public void editSet(int oldSet, int newSet) throws ClassNotFoundException, SQLException {
       Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("update LIST set `set`='" + newSet + "'where `set` ='" 
                                                        + oldSet+ "'");
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void delete(String listPlanName) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        PreparedStatement pstm = conn.prepareStatement("delete from LIST where listName=?");
        pstm.setString(1, listPlanName);
        int rs = pstm.executeUpdate();
        System.out.println(rs);
    }

    public void setListPlanName(String listPlanName) {
        this.listPlanName = listPlanName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void setList(int list) {
        this.list = list;
    }

    public String getListPlanName() {
        return listPlanName;
    }

    public String getDescription() {
        return description;
    }

    public int getReps() {
        return reps;
    }

    public int getSet() {
        return set;
    }

    public int getList() {
        return list;
    }

    
}
