/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class AddList1 extends java.awt.Dialog {
    private static int planId = 0;
    MyPlan2 mp;
    Connection conn = null;
    PreparedStatement pstm = null;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }
    
    

    /**
     * Creates new form AddList1
     */
    public AddList1(java.awt.Frame parent, boolean modal, MyPlan2 mp,int planId) {
        super(parent, modal);
        try {
            this.planId = planId;
            initComponents();
            this.mp = mp;
            conn = MySQLConnect.getMySQLConnection();
            tt();
            txtListPlanId.setText(this.planId + "");
            txtListPlanId.setVisible(false);
            
            System.out.println(mp.getPlanName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddList1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddList1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addList = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        lblReps = new javax.swing.JLabel();
        txtList = new javax.swing.JTextField();
        txtDes = new javax.swing.JTextField();
        txtReps = new javax.swing.JTextField();
        txtSet = new javax.swing.JTextField();
        lblday = new javax.swing.JLabel();
        lblList = new javax.swing.JLabel();
        lblSet = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        boxChooseDay = new javax.swing.JComboBox<>();
        txtListPlanId = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        addList.setText("Add List");

        lblDes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDes.setText("Description");

        lblReps.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblReps.setText("Reps");

        txtList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListActionPerformed(evt);
            }
        });

        txtDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesActionPerformed(evt);
            }
        });

        txtReps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepsActionPerformed(evt);
            }
        });

        lblday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblday.setText("Day");

        lblList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblList.setText("List name");

        lblSet.setText("Set");

        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        boxChooseDay.setModel(new javax.swing.DefaultComboBoxModel<>());
        boxChooseDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxChooseDayActionPerformed(evt);
            }
        });

        txtListPlanId.setText("jTextField1");
        txtListPlanId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtListPlanIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDes)
                            .addComponent(lblday, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblList)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReps)
                            .addComponent(lblSet))))
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addList, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtListPlanId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveBtn))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(boxChooseDay, javax.swing.GroupLayout.Alignment.LEADING, 0, 183, Short.MAX_VALUE)
                                    .addComponent(txtList, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSet, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtReps, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblList)
                    .addComponent(txtList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblday, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxChooseDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtDes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblDes)))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReps))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSet)
                    .addComponent(txtSet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtListPlanId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtListActionPerformed

    private void txtDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesActionPerformed

    private void txtRepsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepsActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        try {
            String sql = "insert into LIST(listName,descriptionList,reps,`set`,list_planID) values (?,?,?,?,?)";
            pstm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, txtList.getText());
            pstm.setString(2, txtDes.getText());
            pstm.setString(3, txtReps.getText());
            String r = txtReps.getText();
            int reps = Integer.parseInt(r);
            pstm.setString(4, txtSet.getText());
            String s = txtSet.getText();
            int set = Integer.parseInt(s);
            pstm.setString(5, txtListPlanId.getText());
            String l = txtListPlanId.getText();
            int listPlanId = Integer.parseInt(l);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Add list successfully");
            MyPlan2 frame = new MyPlan2();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AddList1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void boxChooseDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxChooseDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxChooseDayActionPerformed

    private void txtListPlanIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtListPlanIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtListPlanIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddList1 dialog = new AddList1(new java.awt.Frame(), true, new MyPlan2(),planId);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void tt() throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnect.getMySQLConnection();
        System.out.println("selecting..");
        PreparedStatement pstm = conn.prepareStatement("SELECT nameDay,dayperweek from PLAN where planID = " + planId);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String days = rs.getString("nameDay");
            int start=0;
            for (int i = 1; i <= rs.getInt("dayperweek"); i++) {
                String eachDay=days.substring(start, days.indexOf(" ", start));
                start=days.indexOf(" ", start)+1;
                boxChooseDay.addItem(eachDay);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addList;
    private javax.swing.JComboBox<String> boxChooseDay;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblList;
    private javax.swing.JLabel lblReps;
    private javax.swing.JLabel lblSet;
    private javax.swing.JLabel lblday;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField txtDes;
    private javax.swing.JTextField txtList;
    private javax.swing.JTextField txtListPlanId;
    private javax.swing.JTextField txtReps;
    private javax.swing.JTextField txtSet;
    // End of variables declaration//GEN-END:variables
}
