/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class TestPlan {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MySQLConnect connection = new MySQLConnect();
        Scanner sc = new Scanner(System.in);
        Plan p = new Plan();
        ResultSet rs = p.show();
        while (rs.next()) {
            System.out.println(rs.getString("planName"));
        }

        //p.create("Strong together","Abs workout",11,11);
//        
//        try{
//            MySQLConnect.getMySQLConnection();
//            System.out.println("connect success");
//        }catch(SQLException | ClassNotFoundException e){
//            System.out.println("error");
//        }
    }
}
