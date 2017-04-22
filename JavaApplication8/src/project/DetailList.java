/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.glass.ui.Cursor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.UIManager.getString;
import static javax.xml.ws.Endpoint.create;

/**
 *
 * @author user
 */
public class DetailList extends JFrame {
    private JButton back;
    private JLabel detail;
    private JButton delete;
    int planId = 0;
    

    private ArrayList<JButton> buttons1; //เก็บปุ่ม buttons1 เป็น arraylist 
    private ArrayList<JButton> buttons2; //เก็บปุ่ม buttons2 เป็น arraylist 
    private ArrayList<String> listPlanName,description,reps,set; //เก็บ ตัวแปร เป็น arraylist 
    
    public DetailList(){
        
    }
    
    public DetailList(int planId) throws ClassNotFoundException, SQLException{
        this.planId = planId ;
        ListPlan lp1 = new ListPlan();
        back = new JButton("<");
        detail = new JLabel("Detail List");
        
       
        JPanel j1 = new JPanel(new BorderLayout());
        setTitle("Detail List");
       
        int i = 0;
        int j = 0;
        
        buttons1 = new ArrayList<JButton>();
        buttons2 = new ArrayList<JButton>();
       
        
        listPlanName = new ArrayList<String>();
        description = new ArrayList<String>();
        reps = new ArrayList<String>();
        set = new ArrayList<String>();
        
        JButton[] editbtn = new JButton[100];
        JButton[] deletebtn = new JButton[100];
        
        JPanel top = new JPanel(new GridLayout(1, 1));
        top.add(back);

        JPanel top2 = new JPanel(new GridLayout(1, 1));
        top.add(detail);
        
        JPanel alltop = new JPanel();
        alltop.add(top, BorderLayout.WEST);
        alltop.add(top2, BorderLayout.CENTER);
        add(alltop, BorderLayout.NORTH);

        JPanel j2 = new JPanel(new GridLayout(0, 1));
        ListPlan lp = new ListPlan();
        ResultSet rs = lp.show(planId);
        while (rs.next()) { //เพื่อเช็คว่า กดปุ่มของ List plan ใด
            listPlanName.add(rs.getString("listName"));
            description.add(rs.getString("descriptionList")); 
            reps.add(rs.getString("reps"));
            set.add(rs.getString("set"));
            
            j2.add(new JLabel("List Plan : "+rs.getString("listName")+"\n"));
            j2.add(new JLabel("Description : "+rs.getString("descriptionList")+"\n"));
            j2.add(new JLabel("Reps : "+rs.getString("reps")+"\n"));
            j2.add(new JLabel("Set : "+rs.getString("set")+"\n"));
            j2.add(new JLabel("----------------------------------------------------"));
            
                    
        }
            JPanel j3 = new JPanel(new GridLayout(0, 2));
            rs = lp.show(planId);
            while (rs.next()) {
                editbtn[i] = new JButton("Edit");
                editbtn[i].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < buttons1.size(); i++) {
                            if (e.getSource() == buttons1.get(i)) { 
                                try { // i ช่วยบอกว่ากำลังแก้ของแพลนไหนอยู่
                                EditListPlan ep = new EditListPlan(listPlanName.get(i),description.get(i),reps.get(i),set.get(i));
                                ep.setVisible(true);
                                ep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                ep.setLocationRelativeTo(null);
                                ep.setResizable(false);
                                setVisible(false);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }

                });
                
                j3.add(editbtn[i]);
                buttons1.add(editbtn[i]);
                i++;

                deletebtn[j] = new JButton("Delete");
                deletebtn[j].addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int j = 0; j < buttons2.size(); j++) { // j บอกว่ากำลัง delete แพลนไหนอยู่
                            if (e.getSource() == buttons2.get(j)) {
                                try {
                                    Object[] options = {"Yes", "No"}; // pop-up เด้งขึ้นมาถาม มี yes,no ให้เลือก
                                    int n = JOptionPane.showOptionDialog(delete, "Delete plan?", "Delete",
                                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                                            options, options[0]); // //กด yes n จะมีค่าเป็น 0 ถ้ากดปุ่มอื่นจะเป็น 1
                                    if (n == 0) {
                                        try {
                                            System.out.println("Deleted");
                                            ListPlan lp = new ListPlan();
                                            lp.delete(listPlanName.get(j));
                                        } catch (ClassNotFoundException ex) {
                                            Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    DetailList dl = new DetailList(planId);
                                    dl.pack();
                                    dl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    dl.setVisible(true);
                                    dl.setLocationRelativeTo(null);
                                    setVisible(false);
                                    dl.setResizable(false);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (SQLException ex) {
                                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    } 
                });
                j3.add(deletebtn[j]);
                buttons2.add(deletebtn[j]);
                j++;
            }
        
        j1.add(j2, BorderLayout.WEST);
        j1.add(j3, BorderLayout.EAST);
        add(j1, BorderLayout.CENTER);
        
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MyPlan mp = new MyPlan();
                    mp.setVisible(true);
                    mp.setSize(600, 600);
                    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(false);  
                    mp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
    }
       
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DetailList dl = new DetailList();
        dl.pack();
        dl.setSize(400, 400);
        dl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dl.setVisible(true);
        dl.setLocationRelativeTo(null);
        
    }
}
