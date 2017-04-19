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
    JButton cancelbtn;
    JLabel lblPName;
    JTextField txtPName;
    JLabel lblDescribe;
    JTextArea txtDescribe;
    JLabel lblTtDays;
    JTextField txtTtDays;
    JButton backbtn;
    JLabel createplbl;
    //JLabel lblDPW; //DPW : Days Per Week
    //JTextArea txtDPW;

    public CreatePlan() {

        lblPName = new JLabel("Plan Name");
        txtPName = new JTextField(3);
        lblDescribe = new JLabel("Description");
        txtDescribe = new JTextArea();
        lblTtDays = new JLabel("Total Days");
        txtTtDays = new JTextField(2);
        //lblDPW = new JLabel("Days Per Week");
        //txtDPW = new JTextArea();
        createbtn = new JButton("Create");
        cancelbtn = new JButton("Cancel");
        backbtn = new JButton("Back");
        backbtn.setBounds(129, 49, 99, 23);
        createplbl = new JLabel("Create Plan");
        
        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(5, 2, 20, 10));
        setTitle("Create Plan");
        frame.add(createplbl); 
        frame.add(backbtn);
        frame.add(lblPName);
        frame.add(txtPName);
        frame.add(lblDescribe);
        frame.add(txtDescribe);
        frame.add(lblTtDays);
        frame.add(txtTtDays);
        //frame.add(lblDPW);
        //frame.add(txtDPW);
        frame.add(createbtn);
        frame.add(cancelbtn);

        getContentPane().add(frame, BorderLayout.CENTER);

        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    Plan p = new Plan();
                    String planName = txtPName.getText();
                    String description = txtDescribe.getText();
                    String tTDays = txtTtDays.getText();
                    int totalDays = Integer.parseInt(tTDays);
                    //String DPW = txtDPW.getText();
                    //int daysPerWeek = Integer.parseInt(DPW);
                    try {
                        p.create(planName, description, totalDays);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    MyPlan sp = new MyPlan();
                    sp.setVisible(true);
                    System.out.println("Plan created");
                    setVisible(false);
                    sp.setSize(400, 400);
                    sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    sp.setLocationRelativeTo(null);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Calendargui frame = new Calendargui();
                frame.pack();
                frame.setSize(500, 350);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                setVisible(false);
            }
        });

        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MyPlan cp = new MyPlan();
                    cp.setSize(400, 400);
                    cp.setVisible(true);
                    cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(false);
                    cp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CreatePlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }

    public static void main(String[] args) {
        CreatePlan plan = new CreatePlan();
        plan.pack();
        plan.setSize(400, 400);
        plan.setVisible(true);
        plan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plan.setLocationRelativeTo(null);
    }
}
