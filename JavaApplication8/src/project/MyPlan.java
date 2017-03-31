/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.glass.ui.Cursor;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import static javax.swing.UIManager.getString;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author Administrator
 */
public class MyPlan extends JFrame implements ActionListener {

    JButton back;
    JLabel lblMyP;
    JLabel lblMyP1;
    JLabel lblMyP2, Show;
    JButton editbtn;
    JButton deletebtn;
    JButton detailbtn;
    JButton addbtn;
    JTextArea txtDes;
    JLabel lbldl; //dl = delete

    ArrayList<JButton> buttons1; //เก็บปุ่ม buttons1 เป็น arraylist เพราะไม่รู้ว่าจะมีทั้งหมดกี่ปุ่มเลยเลือกเก็บเป็นแบบนี้ 
    ArrayList<JButton> buttons2; //เก็บปุ่ม buttons2 เป็น arraylist เพราะไม่รู้ว่าจะมีทั้งหมดกี่ปุ่มเลยเลือกเก็บเป็นแบบนี้ 
    ArrayList<JButton> buttons3; //เก็บปุ่ม buttons3 เป็น arraylist เพราะไม่รู้ว่าจะมีทั้งหมดกี่ปุ่มเลยเลือกเก็บเป็นแบบนี้
    ArrayList<JButton> buttons4; //เก็บปุ่ม buttons4 เป็น arraylist เพราะไม่รู้ว่าจะมีทั้งหมดกี่ปุ่มเลยเลือกเก็บเป็นแบบนี้
    ArrayList<String> planName, descrip; //เก็บ planName เป็น arraylist เพราะไม่รู้ว่าจะมีทั้งหมดกี่อันเลยเลือกเก็บเป็นแบบนี้
    ArrayList<String> totaldays, dayperweek;

    public MyPlan() throws ClassNotFoundException, SQLException {
        Plan p1 = new Plan();

        back = new JButton("<");
        lblMyP = new JLabel("My Plan");

        editbtn = new JButton("Edit");
        deletebtn = new JButton("Delete");
        txtDes = new JTextArea(5, 20);
        Show = new JLabel("");
        detailbtn = new JButton("Detail List");
        addbtn = new JButton("Edit List");

        //.txtsetText(txtDes);
        JPanel Bank = new JPanel(new BorderLayout());
        setTitle("My Plan");
        JPanel Bank1 = new JPanel(new GridLayout(0, 2));
        Plan p = new Plan();
        ResultSet rs = p.show();
        int i = 0;
        int j = 0;
        int l = 0;
        int k = 0;
        buttons1 = new ArrayList<JButton>();
        buttons2 = new ArrayList<JButton>();
        buttons3 = new ArrayList<JButton>();
        buttons4 = new ArrayList<JButton>();
        planName = new ArrayList<String>();
        descrip = new ArrayList<String>();
        totaldays = new ArrayList<String>();
        dayperweek = new ArrayList<String>();
        JButton[] editbtn = new JButton[100];
        JButton[] deletebtn = new JButton[100];
        JButton[] detailbtn = new JButton[100];
        JButton[] addbtn = new JButton[100];

        JPanel top = new JPanel();
        top.add(back);

        JPanel top2 = new JPanel();
        top.add(lblMyP);

        JPanel alltop = new JPanel(new GridLayout(1, 1));
        alltop.add(top, BorderLayout.WEST);
        alltop.add(top2, BorderLayout.EAST);

        add(alltop, BorderLayout.NORTH);

        while (rs.next()) {

            //เราทำเพื่อเพิ่ม planName เข้าไปเพื่อใช้งานและเมื่อเราเอา
            //ไปทำงานจะได้รู้ว่าเรากดปุ่มของ planName ไหน
            planName.add(rs.getString("planName"));
            descrip.add(rs.getString("descriptionPlan"));
            totaldays.add(rs.getString("totaldays"));
            dayperweek.add(rs.getString("dayperweek"));
            Bank1.add(new JLabel("Plan name"));
            Bank1.add(new JTextField(rs.getString("planName")));
            Bank1.add(new JLabel("Description"));
            Bank1.add(new JTextArea(rs.getString("descriptionPlan")));

            Bank1.add(new JLabel("Total days"));
            Bank1.add(new JTextField(rs.getString("totaldays")));
            Bank1.add(new JLabel("Days per week"));
            Bank1.add(new JTextField(rs.getString("dayperweek")));
            Bank1.add(new JLabel("Name day"));
            Bank1.add(new JTextArea(rs.getString("dayperweek")));

        }

        JPanel Bank2 = new JPanel(new GridLayout(0,2));
        rs = p.show();
        while (rs.next()) {
            editbtn[i] = new JButton("Edit" + i);
            editbtn[i].addActionListener(this);
            Bank2.add(editbtn[i]);
            buttons1.add(editbtn[i]);
            i++;

            deletebtn[j] = new JButton("Delete" + j);
            deletebtn[j].addActionListener(this);
            Bank2.add(deletebtn[j]);
            buttons2.add(deletebtn[j]);
            j++;

            detailbtn[k] = new JButton("Detail List" + k);
            detailbtn[k].addActionListener(this);
            Bank2.add(detailbtn[k]);
            buttons3.add(detailbtn[k]);
            k++;

            addbtn[l] = new JButton("Add List" + l);
            addbtn[l].addActionListener(this);
            Bank2.add(addbtn[l]);
            buttons4.add(addbtn[l]);
            l++;

        }

        Bank.add(Bank1, BorderLayout.WEST);
        Bank.add(Bank2, BorderLayout.CENTER);
        //     add(Bank1,BorderLayout.WEST);
        add(Bank, BorderLayout.CENTER);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreatePlan cp = new CreatePlan();

                cp.setSize(400, 400);
                cp.setVisible(true);
                cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false);
                cp.setLocationRelativeTo(null);
                
            }
        }
        );

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons1.size(); i++) {
            if (e.getSource() == buttons1.get(i)) {
                System.out.println("edit");
                System.out.println("Plan Name : " + planName.get(i));
                EditPlan eplan = new EditPlan(planName.get(i), descrip.get(i), totaldays.get(i), dayperweek.get(i));
                eplan.pack();
                eplan.setSize(400, 400);
                eplan.setVisible(true);
                eplan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                eplan.setLocationRelativeTo(null);
                this.setVisible(false);
            }

        }
        for (int i = 0; i < buttons2.size(); i++) {
            if (e.getSource() == buttons2.get(i)) {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(deletebtn, "Do you want delete plan?", "Delete Plan!!!",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options, options[0]);
                //กด yes n จะมีค่าเป็น 0 ถ้ากดปุ่มอื่นจะเป็น 1
                if (n == 0) {
                    try {
                        System.out.println("Deleted");
                        Plan p1 = new Plan();
                        try {
                            p1.delete(planName.get(i));
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(lbldl, "Your plan is deleted");
                        MyPlan sp = new MyPlan();
                        sp.pack();
                        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        sp.setVisible(true);
                        sp.setLocationRelativeTo(null);
                        setVisible(false);

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    System.out.println("Canceled");
                }

            }

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MyPlan sp = new MyPlan();
        sp.pack();
        sp.setSize(400, 400);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
        sp.setLocationRelativeTo(null);

    }
}
