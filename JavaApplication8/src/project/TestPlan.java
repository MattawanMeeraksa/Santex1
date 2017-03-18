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

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        Scanner sc = new Scanner(System.in);
        Plan p = new Plan();
        System.out.println(".............");
        String newPassword = sc.nextLine();
        String oldUsername = sc.nextLine();
        System.out.println(p.edit(newPassword,oldUsername));
        //System.out.println(cep.create(,"Strong together","workout together"));
       
        
//        MySQLConnect connection = new MySQLConnect();
//        
//        try{
//            MySQLConnect.getMySQLConnection();
//            System.out.println("connect success");
//        }catch(SQLException | ClassNotFoundException e){
//            System.out.println("error");
//        }
        
    }
}
