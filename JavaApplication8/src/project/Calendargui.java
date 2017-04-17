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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Calendargui extends JFrame implements ActionListener {

    private DefaultTableModel model;
    private Calendar cal = new GregorianCalendar();
    private JLabel label;
    private String month;
    private int year;
    private JTextArea textArea;
    private int dayperweek;
    private String nameDay;

    public Calendargui(String nameDay) {
        this();
        this.nameDay = nameDay;

    }

    public Calendargui(int dayperweek) {
        this();
        this.dayperweek = dayperweek;

    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public int getDayperweek() {
        return dayperweek;
    }

    public void setDayperweek(int dayperweek) {
        this.dayperweek = dayperweek;
    }

    public Calendargui() {

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
        panel.add(b1, BorderLayout.WEST);
        panel.add(label, BorderLayout.CENTER);
        panel.add(b2, BorderLayout.EAST);

        String[] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        JScrollPane pane = new JScrollPane(table);

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    for (int i = 1; i <= 31; i++) {
                        if (i % 7 == 1) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 0) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 2) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 3) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 4) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 5) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        }
                        if (i % 7 == 6) {
                            if (table.getValueAt(row, col).equals(i) == true) {
                                textArea.setText("" + i);
                            }
                        } else if (table.getValueAt(row, col) == null) {
                            textArea.setText("11" + getDayperweek());
                            textArea.setText("" + i);
                        }
                    }

                }
            }
        });

        JPanel main1 = new JPanel(new BorderLayout());
        main1.add(panel, BorderLayout.NORTH);
        main1.add(pane, BorderLayout.CENTER);

        JPanel main2 = new JPanel(new BorderLayout());
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton b3 = new JButton("My Plan");
        JButton b4 = new JButton("Create Plan");
        JPanel Bt = new JPanel(new GridLayout(1, 1));
        Bt.add(b3);
        Bt.add(b4);
        JPanel South = new JPanel(new GridLayout(2, 1));
        South.add(main2);
        South.add(Bt);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    System.out.println("Canceled");
                    MyPlan mp = new MyPlan();
                    mp.setVisible(true);
                    setVisible(false);
                    mp.setSize(400, 400);
                    mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mp.setLocationRelativeTo(null);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(StartPlan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(StartPlan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                CreatePlan cp = new CreatePlan();

                cp.setSize(400, 400);
                cp.setVisible(true);
                cp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(false);
                cp.setLocationRelativeTo(null);
            }
        });

        main2.add(scrollPane, BorderLayout.CENTER);

        this.add(main1, BorderLayout.CENTER);
        this.add(South, BorderLayout.SOUTH);

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

        int i = startDay - 1;
        for (int day = 1; day <= numberOfDays; day++) {
            model.setValueAt(day, i / 7, i % 7);
            i = i + 1;
        }

    }

    public static void main(String[] args) {
        Calendargui frame = new Calendargui();
        frame.pack();
        frame.setSize(500, 350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
