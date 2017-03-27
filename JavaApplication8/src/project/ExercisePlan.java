/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class ExercisePlan extends JFrame{
    JFrame jf = new JFrame();
    
    public static void main(String[] args) {
        ExercisePlan ep = new ExercisePlan();
        ep.setSize(300, 400);
        ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ep.setVisible(true);
        
    }
}
