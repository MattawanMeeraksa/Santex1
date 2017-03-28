/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
    
    public ExercisePlan(){
        JPanel frame = new JPanel();
        setTitle("Home");
        GridLayout top = new GridLayout(1, 2, 10,0);
        
        lblExP = new JLabel("Exercise Plan");
        lblTDL = new JLabel("To do list");
       
        frame.add(lblExP);
        frame.add(lblTDL);
        
        getContentPane().add(frame);
    }
    
    public static void main(String[] args) {
        ExercisePlan ep = new ExercisePlan();
        ep.setSize(300, 400);
        ep.pack();
        ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ep.setVisible(true);
        ep.setLocationRelativeTo(null);
    }
}
