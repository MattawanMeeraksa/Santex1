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
public class EditPlan1 extends JFrame {
    private String editName;
    private String editDes;
    private int edittotal;
    private int editDPW;
    private int planId;
    
    private JButton savebtn;
    private JButton backbtn;
    private JButton startbtn;
    private JLabel lblPName;
    private JTextField txtPName;
    private JLabel lblDescribe;
    private JTextArea txtDescribe;
    private JLabel lblTtDays;
    private JTextField txtTtDays;
    private JLabel lblDPW; //DPW : Days Per Week
    private JTextField txtDPW;

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


    public int getEditDPW() {
        return editDPW;
    }

    public void setEditDPW(int editDPW) {
        this.editDPW = editDPW;
    }
    
    public EditPlan1(int planId, String planName,String description,String totaldays){
        this();
        this.planId = planId;
        editName=planName;
        editDes=description;
        int Total=Integer.parseInt(totaldays);
        edittotal=Total;


        //เอาข้อมูลที่เราต้องการแก้ไขใส่ลงไปในช่องต่างๆ
        txtPName.setText(this.editName);
        txtDescribe.setText(this.editDes);
        txtTtDays.setText(this.edittotal+"");
    }


    public EditPlan1() {
        lblPName = new JLabel("Plan Name");
        txtPName = new JTextField(3);
        lblDescribe = new JLabel("Description");
        txtDescribe = new JTextArea();
        lblTtDays = new JLabel("Total Days");
        txtTtDays = new JTextField(2);
        savebtn = new JButton("Save");
        backbtn = new JButton("Back");
        startbtn = new JButton("Start");

        JPanel frame = new JPanel();

        frame.setLayout(new GridLayout(4, 2, 20, 10));
        setTitle("Edit Plan");

        frame.add(lblPName);
        frame.add(txtPName);

        frame.add(lblDescribe);
        frame.add(txtDescribe);
        frame.add(lblTtDays);
        frame.add(txtTtDays);
        frame.add(savebtn);
        frame.add(backbtn);

        add(frame, BorderLayout.CENTER);

        savebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Plan p = new Plan();
                    ResultSet rs = p.show();   
                        p.editPlanName(planId, txtPName.getText());
                        p.editDescription(planId, txtDescribe.getText());
                        String tTDays = txtTtDays.getText();
                        int totalDays = Integer.parseInt(tTDays);
                        p.editTotalDay(planId, totalDays);
                        MyPlan mp = new MyPlan();
                        mp.setVisible(true);
                        mp.setDefaultCloseOperation(mp.EXIT_ON_CLOSE);
                        setVisible(false);
                        mp.pack();

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );

        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MyPlan mp = new MyPlan();
                    mp.setSize(600, 600);
                    mp.setVisible(true);
                    mp.setDefaultCloseOperation(mp.EXIT_ON_CLOSE);
                    setVisible(false);
                    mp.setLocationRelativeTo(null);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditPlan1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }

    public static void main(String[] args) {
        EditPlan1 eplan = new EditPlan1();
        eplan.pack();
        eplan.setSize(400, 400);
        eplan.setVisible(true);
        eplan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eplan.setLocationRelativeTo(null);
        eplan.pack();
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }
}

