/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class EditPlan extends JFrame{
    JButton savebtn;
    JButton canclebtn;
    JLabel lblPName;
    JTextField txtPName;
    JLabel lblDescribe;
    JTextArea txtDescribe;
    JLabel lblTtDays;
    JTextField txtTtDays;
    JLabel lblDPW; //DPW : Days Per Week
    JTextField txtDPW;
    
    public EditPlan() {
        
        lblPName = new JLabel("Plan Name");
        txtPName = new JTextField(3);
        lblDescribe = new JLabel("Description");
        txtDescribe = new JTextArea();
        lblTtDays = new JLabel("Total Days");
        txtTtDays = new JTextField(2);
        lblDPW = new JLabel("Days Per Week");
        txtDPW = new JTextField(2);
        savebtn = new JButton("Save");
        //canclebtn = new JButton("Cancle");
        
        JPanel frame = new JPanel();
        
        
        frame.setLayout(new GridLayout(5, 2, 20, 10));
        setTitle("Edit Plan");
        
        frame.add(lblPName);
        frame.add(txtPName);
        
        frame.add(lblDescribe);
        frame.add(txtDescribe);
        frame.add(lblTtDays);
        frame.add(txtTtDays);
        frame.add(lblDPW);
        frame.add(txtDPW);
        frame.add(savebtn);
        //frame.add(canclebtn);
        
        add(frame, BorderLayout.CENTER);
        
        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    MyPlan mp = new MyPlan();
                    mp.setVisible(true);
                    setVisible(true);
                    mp.setSize(400, 400);
                    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
}
     public static void main(String[] args) {
        EditPlan eplan = new EditPlan();
        eplan.pack();
        eplan.setSize(400, 400);
        eplan.setVisible(true);
        eplan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eplan.setLocationRelativeTo(null);      
    }
}
