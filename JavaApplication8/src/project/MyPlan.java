package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class MyPlan extends JFrame implements ActionListener {

    private JButton editBtn;
    private JButton deleteBtn;
    private JButton detailListBtn;
    private JButton addListBtn;
    private JButton startBtn;
    private JButton backBtn;
    private JTextArea txtDes;
    private JLabel lbldl; //dl = delete
    private JLabel lblMyP;
    
    private ArrayList<JButton> buttons1; //เก็บปุ่ม buttons1 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้ 
    private ArrayList<JButton> buttons2; //เก็บปุ่ม buttons2 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้ 
    private ArrayList<JButton> buttons3; //เก็บปุ่ม buttons3 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้
    private ArrayList<JButton> buttons4; //เก็บปุ่ม buttons4 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้
    private ArrayList<JButton> buttons5; //เก็บปุ่ม buttons4 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้
    private ArrayList<JButton> buttons6; //เก็บปุ่ม buttons4 เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้
    private ArrayList<Integer> planId;
    private ArrayList<String> planName, descrip; //เก็บ planName เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้
    private ArrayList<String> totaldays, dayperweek; //เก็บ planName เป็น arraylist เพราะไม่รู้จำนวนที่แน่นอนเลยเลือกเก็บเป็นแบบนี้

    public JButton getBackBtn() {
        return backBtn;
    }
    
    public JLabel getLblMyP() {
        return lblMyP;
    }

 
    public JButton getEditBtn() {
        return editBtn;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public JButton getDetailListBtn() {
        return detailListBtn;
    }

    public JButton getAddListBtn() {
        return addListBtn;
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JTextArea getTxtDes() {
        return txtDes;
    }

    public JLabel getLbldl() {
        return lbldl;
    }

    public ArrayList<JButton> getButtons1() {
        return buttons1;
    }

    public ArrayList<JButton> getButtons2() {
        return buttons2;
    }

    public ArrayList<JButton> getButtons3() {
        return buttons3;
    }

    public ArrayList<JButton> getButtons4() {
        return buttons4;
    }

    public ArrayList<JButton> getButtons5() {
        return buttons5;
    }

    public ArrayList<JButton> getButtons6() {
        return buttons6;
    }

    public ArrayList<String> getPlanName() {
        return planName;
    }

    public ArrayList<String> getDescrip() {
        return descrip;
    }

    public ArrayList<String> getTotaldays() {
        return totaldays;
    }

    public ArrayList<String> getDayperweek() {
        return dayperweek;
    }

    public MyPlan() throws ClassNotFoundException, SQLException {

        //Plan p1 = new Plan();
        //ปุ่มและข้อความด้านบน
        backBtn = new JButton("<");
        lblMyP = new JLabel("My Plan");

        //
        txtDes = new JTextArea(5, 20);

        //ปุ่มด้านขวา
        editBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");
        startBtn = new JButton("Start");

        //ปุ่มด้านล่างคำอธิบาย
        detailListBtn = new JButton("Detail List");
        addListBtn = new JButton("Edit List");

        //.txtsetText(txtDes);
        JPanel bigLayer = new JPanel(new BorderLayout());
        setTitle("My Plan");

        int i = 0;
        int j = 0;
        int l = 0;
        int k = 0;
        int m = 0;
        int n = 0;

        buttons1 = new ArrayList<JButton>();
        buttons2 = new ArrayList<JButton>();
        buttons3 = new ArrayList<JButton>();
        buttons4 = new ArrayList<JButton>();
        buttons5 = new ArrayList<JButton>();
        buttons6 = new ArrayList<JButton>();

        planId = new ArrayList<Integer>();
        planName = new ArrayList<String>();
        descrip = new ArrayList<String>();
        totaldays = new ArrayList<String>();
        dayperweek = new ArrayList<String>();

        JButton[] editBtn = new JButton[100];
        JButton[] deleteBtn = new JButton[100];
        JButton[] detailListBtn = new JButton[100];
        JButton[] addListBtn = new JButton[100];
        JButton[] startBtn = new JButton[100];
        JButton[] blankBtn = new JButton[100];

        JPanel topBack = new JPanel();
        topBack.setLayout(new GridLayout(1, l));
        topBack.add(backBtn);

        JPanel topLabel = new JPanel();
        topLabel.setLayout(new GridLayout(1, l));
        topLabel.add(lblMyP);

        JPanel allTop = new JPanel();
        allTop.add(topBack, FlowLayout.LEFT);
        allTop.add(topLabel, BorderLayout.CENTER);
        add(allTop, BorderLayout.NORTH);

        JPanel planLayer = new JPanel(new GridLayout(0, 1,0,10));
        Plan p = new Plan();
        ResultSet rs = p.show();
        while (rs.next()) {

            //เก็บ planId,planName,descrip,totaldays ในทุกๆช่องลงในตัวแปร planId ทีเป็นArrayList เพราะเราไม่รู้จำนวนที่แน่นอน
            planId.add(rs.getInt("planID")); 
            planName.add(rs.getString("planName"));
            descrip.add(rs.getString("descriptionPlan"));
            totaldays.add(rs.getString("totaldays"));
                     
            JTextArea all = new JTextArea(5,20);
            all.append("Plan name: "+rs.getString("planName")+"\n"); //ต่อข้อความเพื่อไม่ให้มันทับกัน ให้มันต่อกันไป
            all.append("Description: "+rs.getString("descriptionPlan")+"\n");
            all.append("Total days: "+rs.getString("totaldays")+"\n");
            all.append("Days per week: "+rs.getString("dayperweek")+"\n");
            planLayer.add(all);
        }

        //เก็บในฝั่งของปุ่มด้านขวา
        JPanel btnLayer = new JPanel(new GridLayout(0, 2));
        rs = p.show();
        while (rs.next()) {
            editBtn[i] = new JButton("Edit" + i); //กำหนดชื่อให้กับปุ่ม
            editBtn[i].addActionListener(this); //เพิ่ม action ให้มันเวลาเรากดให้ไปทำที่ method ด้านล่าง
            btnLayer.add(editBtn[i]); //เพิ่มลงไปใน layer
            buttons1.add(editBtn[i]); //เก็บเพื่อรู้ว่ามีกี่ปุ่ม ไล่ไปเรื่อยๆ
            i++; //เพิ่มขึ้นเรื่อยๆทีละ 1

            deleteBtn[j] = new JButton("Delete" + j);
            deleteBtn[j].addActionListener(this);
            btnLayer.add(deleteBtn[j]);
            buttons2.add(deleteBtn[j]);
            j++;

            detailListBtn[k] = new JButton("Detail List" + k);
            detailListBtn[k].addActionListener(this);
            btnLayer.add(detailListBtn[k]);
            buttons3.add(detailListBtn[k]);
            k++;

            addListBtn[l] = new JButton("Add List" + l);
            addListBtn[l].addActionListener(this);
            btnLayer.add(addListBtn[l]);
            buttons4.add(addListBtn[l]);
            l++;

            startBtn[m] = new JButton("Start" + m);
            startBtn[m].addActionListener(this);
            btnLayer.add(startBtn[m]);
            buttons5.add(startBtn[m]);
            m++;

            //เก็บเพื่อใหช่องมันพอดี ปุ่มว่าง
            blankBtn[n] = new JButton(" ");
            btnLayer.add(blankBtn[n]);
            buttons6.add(blankBtn[n]);
            n++; 
        }

        //เป็นการจัดรูปแบบของการแสดงผล
        bigLayer.add(planLayer, BorderLayout.WEST);
        bigLayer.add(btnLayer, BorderLayout.EAST); //old-> CENTER
        //     add(Bank1,BorderLayout.WEST);
        add(bigLayer, BorderLayout.CENTER);

        //เป็น action ของการกดปุ่ม back
        backBtn.addActionListener(new ActionListener() {
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

    //เป็น method เก็บ action ที่ออบเจกต์สามารถเรียกใช้ได้
    public void actionPerformed(ActionEvent e) {
        //ลูปของปุ่ม edit
        
        //ลูปทำงานของปุ่ม edit
        for (int i = 0; i < buttons1.size(); i++) { //buttons1.size() จำนวนปุ่มทั้งหมดที่สร้าง
            if (e.getSource() == buttons1.get(i)) { //เช็คว่าปุ่มที่เรากด

                System.out.println("edit");
                System.out.println("Plan Id : " + planId.get(i));
                System.out.println("Plan Name : " + planName.get(i));
                System.out.println("Description : " + descrip.get(i));
                System.out.println("Total days : " + totaldays.get(i));
                EditPlan1 eplan = new EditPlan1(planId.get(i), planName.get(i), descrip.get(i), totaldays.get(i));
                eplan.pack();
                eplan.setSize(400, 400);
                eplan.setVisible(true);
                eplan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                eplan.setLocationRelativeTo(null);
                this.setVisible(false);
            }

        }
        //ลูปของปุ่ม delete
        for (int i = 0; i < buttons2.size(); i++) {
            if (e.getSource() == buttons2.get(i)) {
                Object[] options = {"Yes", "No"}; //เป็นปุ่มที่ให้เลือกว่าจะกดอะไร
                int n = JOptionPane.showOptionDialog(deleteBtn, //1.เป็นชนิดของปุ่ม
                        "Do you want delete plan?", //2.เป็นข้อความโชว์บนกล่อง message
                        "Delete Plan!!!", //3.title ของ message box
                        JOptionPane.YES_NO_CANCEL_OPTION, //4.ชนิดของ optionPane ว่าเป็น yes/no
                        JOptionPane.QUESTION_MESSAGE, 
                        null, //ไม่ใช้ไอคอน do not use a custom Icon
                        options, //ชื่อของในแต่ละปุ่ม the titles of button ที่มี yes no
                        options[0]); //default button title
                
                // ถ้ากด yes จะทำให้ n มีค่าเป็น 0
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
                        //ให้มันแสดงเฉยๆว่าแพลนนั้นถูกลบออกไปแล้วแต่กดเลือกอะไรไม่ได้นอกจากแค่กด ok หรือปิดหน้าจอไป
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
        
        //ลูปของปุ่ม start
        for (int i = 0; i < buttons5.size(); i++) {
            if (e.getSource() == buttons5.get(i)) {
                System.out.println("Start");
                System.out.println("Plan Name : " + planName.get(i));
                StartPlan stp = new StartPlan();
                stp.setPlanId(planId.get(i));
                stp.setPlanName(planName.get(i));
                stp.pack();
                stp.setSize(400, 400);
                stp.setVisible(true);
                stp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                stp.setLocationRelativeTo(null);
                this.setVisible(false);
            }

        }
    }

    public static void main(String[] args) {

        try {
            MyPlan sp = new MyPlan();
            sp.setSize(400, 400);
            sp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sp.setVisible(true);
            sp.setLocationRelativeTo(null);
            sp.pack();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyPlan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getPlanId() {
        return planId;
    }

    public void setPlanId(ArrayList<Integer> planId) {
        this.planId = planId;
    }
}
