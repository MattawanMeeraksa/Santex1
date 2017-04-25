/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class ExercisePlan extends JFrame{
    JLabel lblExP;
    JLabel lblTDL; //TDl = to do list
    JButton myPlan;
    JButton createP;
    
    public ExercisePlan(){
        JPanel frame = new JPanel();
        setTitle("Home");
        frame.setLayout(new GridLayout(4,1, 10,0));
        
        lblExP = new JLabel("Exercise Plan");
        lblTDL = new JLabel("To do list");
        myPlan = new JButton("My Plan");
        createP = new JButton("Create Plan");
       
        frame.add(lblExP);
        frame.add(lblTDL);
        frame.add(myPlan);
        frame.add(createP);
         
        getContentPane().add(frame, BorderLayout.SOUTH);
       //getContentPane().add(frame);
       
       myPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    MyPlan mp = new MyPlan();
                    mp.setVisible(true);
                    System.out.println("Plan created");
                    setVisible(false);
                    mp.setSize(400, 400);
                    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ExercisePlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ExercisePlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        createP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                CreatePlan1 ep = new CreatePlan1();
                ep.setVisible(true);
                setVisible(false);
                ep.setSize(400, 400);
                ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ep.setLocationRelativeTo(null);
            }
        });
    }
    
    public static void main(String[] args) {
        ExercisePlan ep = new ExercisePlan();
        ep.setSize(400, 400);
        ep.pack();
        ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ep.setVisible(true);
        ep.setLocationRelativeTo(null);
    }
}
