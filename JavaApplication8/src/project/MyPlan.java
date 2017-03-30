/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

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
    ArrayList<JButton> buttons1;
    ArrayList<JButton> buttons2;
    ArrayList<JButton> buttons3;
    ArrayList<JButton> buttons4;
    ArrayList<String> planName;

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
            //
            planName.add(rs.getString("planName"));
            //Bank1.add(new JTextArea());
            Bank1.add(new JLabel("Plan name"));
            Bank1.add(new JLabel(rs.getString("planName")));
            Bank1.add(new JLabel("Description"));
            Bank1.add(new JLabel(rs.getString("descriptionPlan")));
            Bank1.add(new JLabel("Total days"));
            Bank1.add(new JLabel(rs.getString("totaldays")));
            Bank1.add(new JLabel("Days per week"));
            Bank1.add(new JLabel(rs.getString("dayperweek")));
            //Bank1.add(new JLabel("----------------------------\n"));
        }

        JPanel Bank2 = new JPanel(new GridLayout(4, 2));
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

            detailbtn[k] = new JButton("Detal List" + k);
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
                cp.setDefaultCloseOperation(cp.EXIT_ON_CLOSE);
                setVisible(false);
                cp.setLocationRelativeTo(null);
            }
        }
        );
//            editbtn.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent evt) {
//                    EditPlan eplan = new EditPlan();
//                    eplan.setVisible(true);
//                    setVisible(false);
//                    eplan.setSize(400, 400);
//                    eplan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    eplan.setLocationRelativeTo(null);
//                }
//            });
//            deletebtn.addActionListener(new ActionListener() {
//                public void actionPerformed(ActionEvent e) {
//                    CreatePlan cp = new CreatePlan();
//                    cp.setSize(400, 400);
//                    cp.setVisible(true);
//                    cp.setDefaultCloseOperation(cp.EXIT_ON_CLOSE);
//                    setVisible(false);
//                    cp.setLocationRelativeTo(null);
//                }
//            }
//            );

    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons1.size(); i++) {
            if (e.getSource() == buttons1.get(i)) {
                System.out.println("edit");
                System.out.println(planName.get(i));
            }
        }
        for (int i = 0; i < buttons2.size(); i++) {
            if (e.getSource() == buttons2.get(i)) {
                Object[] options = {"Yes", "No"};
                int n = JOptionPane.showOptionDialog(deletebtn, "Do you want delete plan?", "Delete Plan!!!",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        options,options[0]);
                if(n==0){
                    System.out.println("Delete");
                    Plan p1= new Plan();
                    try {
                        p1.delete(planName.get(i));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    System.out.println("No Delete");
                }
            }
            //JOptionPane.showMessageDialog(deletebtn, "Do you want delete plan?");

        }
    }

    /*  if(e.getSource()==buttons.get(0)){
                
            }else if(e.getSource()==buttons.get(1)){
                
            }                
            System.out.println(buttons.get(0));
             System.out.println(e.getSource());
             System.out.println(buttons.get(0) == e.getSource());*/
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        MyPlan sp = new MyPlan();
        sp.pack();
        sp.setSize(400, 400);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
        sp.setLocationRelativeTo(null);

    }
}
