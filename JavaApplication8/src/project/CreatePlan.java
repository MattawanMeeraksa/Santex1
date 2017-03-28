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


public class CreatePlan extends JFrame {
    
    JButton createbtn;
    JButton canclebtn;
    JLabel lblPName;
    JTextField txtPName;
    JLabel lblDescribe;
    JTextArea txtDescribe;
    JLabel lblTtDays;
    JTextField txtTtDays;
    JLabel lblDPW; //DPW : Days Per Week
    JTextField txtDPW;
    
    public CreatePlan() {
        
        lblPName = new JLabel("Plan Name");
        txtPName = new JTextField(3);
        lblDescribe = new JLabel("Description");
        txtDescribe = new JTextArea();
        lblTtDays = new JLabel("Total Days");
        txtTtDays = new JTextField(2);
        lblDPW = new JLabel("Days Per Week");
        txtDPW = new JTextField(2);
        createbtn = new JButton("Create");
        canclebtn = new JButton("Cancle");
        
        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(5, 3, 20, 10));
        setTitle("Create Plan");
        
        frame.add(lblPName);
        frame.add(txtPName);
        
        frame.add(lblDescribe);
        frame.add(txtDescribe);
        frame.add(lblTtDays);
        frame.add(txtTtDays);
        frame.add(lblDPW);
        frame.add(txtDPW);
        frame.add(createbtn);
        frame.add(canclebtn);
        
        getContentPane().add(frame, BorderLayout.CENTER);
        
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MyPlan sp = new MyPlan();
                sp.setVisible(true);
                System.out.println("Plan created");
                setVisible(false);
                sp.setSize(300, 400);
                sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                sp.setLocationRelativeTo(null);
            }
        });
        
        canclebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ExercisePlan ep = new ExercisePlan();
                ep.setVisible(true);
                setVisible(false);
                ep.setSize(300, 400);
                ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ep.setLocationRelativeTo(null);
            }
        });
    }
    
    public static void main(String[] args) {
        CreatePlan plan = new CreatePlan();
        plan.pack();
        plan.setSize(300, 400);
        plan.setVisible(true);
        plan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plan.setLocationRelativeTo(null);      
    }
}
