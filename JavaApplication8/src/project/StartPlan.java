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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class StartPlan extends JFrame {

    JLabel message;
    JTextField txtday;
    JLabel lblday;
    JButton startbtn;
    JLabel blank1;
    JLabel blank2;
    JButton cancelbtn;
    JLabel blank3;
    JLabel blank4;
    JLabel blank5;
    JLabel blank6;
    private int planId;
    private String planName;
    public StartPlan() {
        message = new JLabel("How many days per week");
        txtday = new JTextField(2);
        lblday = new JLabel("Days");
        startbtn = new JButton("Start");
        cancelbtn = new JButton("Cancel");
        blank1 = new JLabel(" ");
        blank2 = new JLabel(" ");
        blank3 = new JLabel(" ");
        blank4 = new JLabel(" ");
        blank5 = new JLabel(" ");
        blank6 = new JLabel(" ");

        JPanel frame1 = new JPanel();
        frame1.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame1.add(message);

        JPanel frame2 = new JPanel();
        frame2.setLayout(new GridLayout(5, 1));
        frame2.add(txtday);
        frame2.add(lblday);

        JPanel frame3 = new JPanel();
        frame3.setLayout(new GridLayout(2, 2));
        frame3.add(startbtn);
        frame3.add(cancelbtn);
        frame3.add(blank5);
        frame3.add(blank6);

        add(frame1, BorderLayout.NORTH);
        add(frame2, BorderLayout.CENTER);
        frame2.add(frame3, BorderLayout.CENTER);

        startbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    System.out.println("Started Plan " + getPlanName());
                    Plan p = new Plan();
                    ResultSet rs = p.show();
                    String dayperweek = txtday.getText();
                    int DPW = Integer.parseInt(dayperweek);
                    p.start(DPW, getPlanId());
                    Calendargui frame = new Calendargui(DPW);
                    frame.pack();
                    frame.setSize(500, 350);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    setVisible(false);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    System.out.println("Canceled");
                    MyPlan mp = new MyPlan();
                    mp.setVisible(true);
                    setVisible(false);
                    mp.setSize(400, 400);
                    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StartPlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StartPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    public static void main(String[] args) {
        StartPlan sp = new StartPlan();
        sp.pack();
        sp.setSize(400, 400);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
        sp.setLocationRelativeTo(null);
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }
    
    
}
