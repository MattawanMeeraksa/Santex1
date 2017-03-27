/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class ShowPlan extends JFrame {

    JFrame jf = new JFrame();
    JLabel myP;
    JPanel headMyP;

    public ShowPlan() {
        headMyP = new JPanel();
        myP = new JLabel("My Plan");
        setTitle("My Plan");
    }

    public static void main(String[] args) {
        ShowPlan sp = new ShowPlan();
        sp.pack();
        sp.setSize(300, 400);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);

    }
}
