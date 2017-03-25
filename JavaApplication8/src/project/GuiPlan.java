/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Administrator
 */
public class GuiPlan extends JFrame {

    JButton createbtn = new JButton("Create");
    JButton canclebtn = new JButton("Cancle");
    
    //JFrame frame = new JFrame("Create Plan");

    public GuiPlan() {
        setLayout(new GridLayout(5, 3, 30, 0));
        setTitle("Create Plan");
        add(new JLabel("Plan name"));
        add(new JTextField(1));
        add(new JLabel("Description"));
        add(new JTextField(1));
        add(new JLabel("Total days"));
        add(new JTextField(1));
        add(new JLabel("days"));
        add(new JLabel("Days per week"));
        add(new JTextField(1));
        add(new JButton("Create"), BorderLayout.SOUTH);
        add(new JButton("Cancle"), BorderLayout.SOUTH);
        

        createbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        }
        );

    }

    public static void main(String[] args) {
        GuiPlan plan = new GuiPlan();
        plan.setSize(300, 400);
        plan.setVisible(true);
        plan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plan.setLocationRelativeTo(null);

    }
}
