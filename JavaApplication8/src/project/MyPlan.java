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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

    public MyPlan() {
        back = new JButton("<");
        lblMyP = new JLabel("My Plan");
        lblMyP1 = new JLabel("My Plan");
        lblMyP2 = new JLabel("My Plan");
        editbtn = new JButton("Edit");
        deletebtn = new JButton("Delete");

        JPanel frame = new JPanel();
        setTitle("Show Plan");
        //FlowLayout top = new FlowLayout();
        //BorderLayout bl = new BorderLayout(10, 10);
        frame.setLayout(new GridLayout(1, 2, 5, 5));
        
        
        frame.add(back);
        
        frame.add(lblMyP);
        frame.add(editbtn);
        frame.add(deletebtn);
        
         getContentPane().add(frame);
         
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
