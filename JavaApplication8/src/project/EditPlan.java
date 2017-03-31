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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class EditPlan extends JFrame {
    private String editName;
    private String editDes;
    private int edittotal;
    private int editDPW;
    
    JButton savebtn;
    JButton backbtn;
    JLabel lblPName;
    JTextField txtPName;
    JLabel lblDescribe;
    JTextArea txtDescribe;
    JLabel lblTtDays;
    JTextField txtTtDays;
    JLabel lblDPW; //DPW : Days Per Week
    JTextField txtDPW;

    public String getEditName() {
        return editName;
    }

    public void setEditName(String editName) {
        this.editName = editName;
    }

    public String getEditDes() {
        return editDes;
    }

    public void setEditDes(String editDes) {
        this.editDes = editDes;
    }

    public int getEdittotal() {
        return edittotal;
    }

    public void setEdittotal(int edittotal) {
        this.edittotal = edittotal;
    }

//    public int getEditDPW() {
//        return editDPW;
//    }
//
//    public void setEditDPW(int editDPW) {
//        this.editDPW = editDPW;
//    }
//    
    public EditPlan(String planName,String des,String totaldays){
        this();
        editName=planName;
        editDes=des;
        int Total=Integer.parseInt(totaldays);
        edittotal=Total;
//        int DPW=Integer.parseInt(dPW);
//        editDPW = DPW;
        txtPName.setText(this.editName);
        txtDescribe.setText(this.editDes);
        txtTtDays.setText(this.edittotal+"");
        txtDPW.setText(this.editDPW+"");
    }

    public EditPlan() {
        lblPName = new JLabel("Plan Name");
        txtPName = new JTextField(3);
        lblDescribe = new JLabel("Description");
        txtDescribe = new JTextArea();
        lblTtDays = new JLabel("Total Days");
        txtTtDays = new JTextField(2);
        lblDPW = new JLabel("Days Per Week");
        txtDPW = new JTextField();
        savebtn = new JButton("Save");
        backbtn = new JButton("Back");

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
        frame.add(backbtn);

        add(frame, BorderLayout.CENTER);

        savebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Plan p = new Plan();
                    ResultSet rs = p.show();
                        p.editPlanName(editName, txtPName.getText());
                        p.editDescription(editDes, txtDescribe.getText());
                        String tTDays = txtTtDays.getText();
                        int totalDays = Integer.parseInt(tTDays);
                        p.editTotalDay(edittotal, totalDays);
                        String dayper = txtDPW.getText();
                        int DPW = Integer.parseInt(dayper);
                        p.editDayPerWeek(editDPW,DPW);
                        MyPlan mp = new MyPlan();
                        mp.setSize(400, 400);
                        mp.setVisible(true);
                        mp.setDefaultCloseOperation(mp.EXIT_ON_CLOSE);
                        setVisible(false);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MyPlan mp = new MyPlan();
                    mp.setSize(400, 400);
                    mp.setVisible(true);
                    mp.setDefaultCloseOperation(mp.EXIT_ON_CLOSE);
                    setVisible(false);
                    mp.setLocationRelativeTo(null);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
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
