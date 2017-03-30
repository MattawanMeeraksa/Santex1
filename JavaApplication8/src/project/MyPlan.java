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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author Administrator
 */
public class MyPlan extends JFrame {

    JButton back;
    JLabel lblMyP;
    JLabel lblMyP1;
    JLabel lblMyP2;
    JButton editbtn;
    JButton deletebtn;
    JTextArea txtDes;
    

    public MyPlan() {
        back = new JButton("<");
        lblMyP = new JLabel("My Plan");
        lblMyP1 = new JLabel("My Plan");
        lblMyP2 = new JLabel("My Plan");
        editbtn = new JButton("Edit");
        deletebtn = new JButton("Delete");
        txtDes = new JTextArea();
        
   
        //frame ใหญ่อันแรกเพื่อเก็บปุ่ม back กับ หัวข้อ My plan
        JPanel frame1 = new JPanel();
        setTitle("Show Plan"); 
        add(frame1);
        frame1.setLayout(new GridLayout(1, 1));
        
        frame1.add(back);
        frame1.add(lblMyP);
        
        JPanel frame2 = new JPanel();
        frame2.setLayout(new GridLayout(1, 2));
        //add.(frame1,new GridLayout(1,2));
        frame2.add(frame1);
        frame2.add(txtDes);
        frame2.add(editbtn);
        frame2.add(deletebtn);
        
//        JPanel frame3 = new JPanel();
//        frame3.setLayout(new FlowLayout());
//        frame3.add(lblMyP2);
//        bigFrame.add(frame3);
                
        
//        
//        JPanel frame4= new JPanel();
//        frame4.setLayout(new FlowLayout());
//        frame4.add(lblMyP2);
//        bigFrame.add(frame4);
         
        
        
       // getContentPane().add(frame);
        //JPanel frame1 = new JPanel(new BorderLayout());
        //Component add = frame1.add(new JTextField(rs.show()));
       // JPanel frame2 = new JPanel(new GridLayout(1,2,5,5));
        //frame2.add();
         
//        JPanel top = new JPanel();
//        top.add(editbtn,BorderLayout.WEST);
//        top.add(lblMyP,BorderLayout.CENTER);
//         getContentPane().add(top);

         
//        JPanel frame1 = new JPanel(new BorderLayout(10,10));
//        frame1.add(lblMyP1);
//        frame1.add(lblMyP2);
//
//       
//        getContentPane().add(frame1);

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
        
        editbtn.addActionListener(new ActionListener() {
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
        
        deletebtn.addActionListener(new ActionListener() {
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
    }

    public static void main(String[] args) {
        MyPlan sp = new MyPlan();
        sp.pack();

        sp.setSize(400, 400);
        sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sp.setVisible(true);
        sp.setLocationRelativeTo(null);

    }
}
