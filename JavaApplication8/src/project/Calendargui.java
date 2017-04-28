/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TanGX
 */
public class Calendargui extends JPanel implements ActionListener {
  DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel label;
  String month;
  int year;
  JTextArea textArea;
  
  Calendargui() {

    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
 
    JButton b1 = new JButton("<-");
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, -1);
        updateMonth();
      }
    });
 
    JButton b2 = new JButton("->");
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, +1);
        updateMonth();
      }
    });
 
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(b1,BorderLayout.WEST);
    panel.add(label,BorderLayout.CENTER);
    panel.add(b2,BorderLayout.EAST);
 
 
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    model = new DefaultTableModel(null,columns);
    JTable table = new JTable(model);
    //table.setSize(250, 250);
    JScrollPane pane = new JScrollPane(table);
    //pane.setSize(200, 200);
    table.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            if(table.getValueAt(row, col) != null)
            textArea.setText(table.getValueAt(row, col) + " " + month + " " + year);
        }
    }
    });
    JPanel main1 = new JPanel(new BorderLayout());
    main1.add(panel,BorderLayout.NORTH);
    main1.add(pane,BorderLayout.CENTER);
    
    JPanel main2 = new JPanel(new BorderLayout());
    textArea = new JTextArea(5, 20);
    JScrollPane scrollPane = new JScrollPane(textArea);    
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    main2.add(scrollPane,BorderLayout.CENTER);
    
    this.add(main1,BorderLayout.CENTER);
    main1.add(main2,BorderLayout.SOUTH);
    
    this.updateMonth();
 
 
  }
 
  void updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
    month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    year = cal.get(Calendar.YEAR);
    label.setText(month + " " + year);
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
 
    model.setRowCount(0);
    model.setRowCount(weeks);
 
    int i = startDay-1;
    for(int day=1;day<=numberOfDays;day++){
      model.setValueAt(day, i/7 , i%7 );    
      i = i + 1;
    }
 
  }
 
  public static void main(String[] arguments) {
    JFrame f = new JFrame();
        Calendargui frame = new Calendargui();
        f.add(frame);
     
        //f.setSize(100, 100);
//        frame.pack();
        frame.setVisible(true);
        f.setVisible(true);
  }
  
    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
}
