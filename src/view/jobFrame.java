/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import project123.javaConnect;

/**
 *
 * @author Ruhi ÇELİK
 */
public class jobFrame extends javax.swing.JFrame {
 Connection conn=null;
ResultSet rs=null;
PreparedStatement ps=null;
    DateFormat dateFormat=new SimpleDateFormat("dd.MMM.yyyy");
 DecimalFormat df=new DecimalFormat();
 /**
     * Creates new form jobFrame
     */
    public jobFrame() {
        initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        int sicil=javaConnect.sicil;
        jLabel5.setText(String.valueOf(sicil));
        conn=javaConnect.ConnectDb();
     bilgiGetir();
     fillCombos();
     updateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jobpane = new javax.swing.JDesktopPane();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ekleButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jobpane.setBackground(new java.awt.Color(153, 153, 0));
        jobpane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("sil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jobpane.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 210, 73, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Görevlendirme Girişi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel5.setText(" ");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 0), null, null));

        jLabel2.setText("Sicil");

        jLabel4.setText("Soyisim");

        jLabel7.setText(" ");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 0), null, null));

        jLabel10.setText("Gün");

        jLabel12.setText("Süre");

        jLabel14.setText("Görev");

        jLabel15.setText("Görev Şekli");

        jLabel3.setText("isim ");

        jLabel8.setText(" ");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 0), null, null));

        jLabel11.setText("Başlangıç");

        jLabel9.setText("Birim");

        jLabel13.setText("Bitiş");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interFace/AG00092_.png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseReleased(evt);
            }
        });
        jDateChooser1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDateChooser1ComponentShown(evt);
            }
        });
        jDateChooser1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jDateChooser1ComponentAdded(evt);
            }
        });
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
        });
        jDateChooser1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jDateChooser1VetoableChange(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jDateChooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser2MouseReleased(evt);
            }
        });
        jDateChooser2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jDateChooser2ComponentHidden(evt);
            }
        });
        jDateChooser2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jDateChooser2ComponentRemoved(evt);
            }
        });
        jDateChooser2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooser2FocusLost(evt);
            }
        });
        jDateChooser2.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jDateChooser2HierarchyChanged(evt);
            }
        });
        jDateChooser2.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jDateChooser2İnputMethodTextChanged(evt);
            }
        });
        jDateChooser2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jDateChooser2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                jDateChooser2AncestorRemoved(evt);
            }
        });

        jLabel16.setText("Kayıt Sıra");

        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setText("Senesi");

        jLabel19.setText("      ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15))
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel10))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(11, 11, 11)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                .addContainerGap())
        );

        jobpane.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        jDesktopPane1.setBackground(new java.awt.Color(0, 155, 157));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jobpane.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(631, 11, -1, -1));

        jButton3.setText("Değiştir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jobpane.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, 41));

        jButton1.setText("Güncelle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jobpane.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 181, -1, -1));

        ekleButton.setText("ekle");
        ekleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButtonActionPerformed(evt);
            }
        });
        jobpane.add(ekleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 147, 73, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jobpane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 139, 389, 173));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jobpane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jobpane, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      /*  new employeSelect().setVisible(true);
       javaConnect.frameid=2;
        dispose();
*/selectEmployee se=new selectEmployee("job");
this.jobpane.add(se);
se.show();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jDateChooser1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseExited

    private void jDateChooser1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1MouseReleased

    private void jDateChooser1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDateChooser1ComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1ComponentShown

    private void jDateChooser1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jDateChooser1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1ComponentAdded

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jDateChooser1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDateChooser1VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1VetoableChange

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        gunTopla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jDateChooser2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser2MouseReleased

        gunAralik();// TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2MouseReleased

    private void jDateChooser2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDateChooser2ComponentHidden
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2ComponentHidden

    private void jDateChooser2ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jDateChooser2ComponentRemoved
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2ComponentRemoved

    private void jDateChooser2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser2FocusLost
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2FocusLost

    private void jDateChooser2HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jDateChooser2HierarchyChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2HierarchyChanged

    private void jDateChooser2İnputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDateChooser2İnputMethodTextChanged
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2İnputMethodTextChanged

    private void jDateChooser2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDateChooser2AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2AncestorAdded

    private void jDateChooser2AncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jDateChooser2AncestorRemoved
        gunAralik();
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser2AncestorRemoved

    private void ekleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButtonActionPerformed
String sql="insert into job (sicil, begin, end, sure, birim, gorev, gorevsekli) values(?,?,?,?,?,?,?)";
   try{  ps=conn.prepareStatement(sql);
   ps.setString(1, jLabel5.getText());
   ps.setString(2, ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText());
   ps.setString(3, ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText());
   ps.setString(4, jTextField1.getText());
   ps.setString(5,jComboBox1.getSelectedItem().toString());
   ps.setString(6,jComboBox2.getSelectedItem().toString());
   ps.setString(7,jComboBox3.getSelectedItem().toString());
   ps.execute();
           JOptionPane.showMessageDialog(null, "EKLENDİ");
        updateTable();
   }catch(Exception e){
       
   }finally{
    try{
            rs.close();
            ps.close();
            }
catch(Exception e){
    
}
} 
    }//GEN-LAST:event_ekleButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        String value10=jLabel17.getText();
        String value1=jLabel5.getText();
    String value2=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
    String value3=((JTextField)jDateChooser2.getDateEditor().getUiComponent()).getText();
    String value4= jTextField1.getText();
    String value5=jComboBox1.getSelectedItem().toString();
    String value6=jComboBox2.getSelectedItem().toString();
    String value7=jComboBox3.getSelectedItem().toString();
    try{ String sql="UPDATE jop set sira=?,sicil=?, begin=?, end=?, sure=?, birim=?, gorev=?, gorevsekli=? where sira=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1,value10);
        ps.setString(2,value1);
        ps.setString(3,value2);
        ps.setString(4,value3);
        ps.setString(5,value4);
        ps.setString(6,value5);
        ps.setString(7,value6);
        ps.setString(8,value7);
        ps.setString(9,value10);
        ps.execute();
 JOptionPane.showMessageDialog(null, "GÜNCELLENDİ");
    }catch(Exception e){
        
    }finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
updateUnvan();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void updateUnvan(){
        int Row=jTable1.getSelectedRow();
    String tableClick=(jTable1.getModel().getValueAt(Row, 0).toString());
        
    try{   
    String sql="select * from job where sira=?";
    ps=conn.prepareStatement(sql);
    ps.setString(1,tableClick);
    rs=ps.executeQuery();
    if(rs.next()){
       String add1=rs.getString("sira");
       jLabel17.setText(add1);
       String add2=rs.getString("sicil");
       jLabel5.setText(add2);
       String add13=rs.getString("begin");
        jDateChooser1.setDate(dateFormat.parse(add13));
        String add14=rs.getString("end");
      jDateChooser2.setDate(dateFormat.parse(add14)); 
      String add3=rs.getString("birim");
      jComboBox1.setSelectedItem(add3);
      String add4=rs.getString("gorev");
      jComboBox2.setSelectedItem(add4);
      String add5=rs.getString("gorevsekli");
      jComboBox3.setSelectedItem(add5);
    }
    }catch(Exception e){
    } finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
int p=JOptionPane.showConfirmDialog(null,"Silmek istediğinizden eminmisiniz","SİL",JOptionPane.YES_NO_OPTION);
        if (p==0){
       try{
     String sql="delete from job where sira=?";
           ps=conn.prepareStatement(sql);
    ps.setString(1, jLabel17.getText());
    ps.execute();
    JOptionPane.showMessageDialog(null, "sİLİNDİ");

}catch(Exception e){
 JOptionPane.showMessageDialog(null,"tablodan silmek isteğiniz veriyi seçiniz"+e.toString());
}finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
updateTable();

        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
 if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN){
            updateUnvan();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jobFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jobFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDesktopPane jobpane;
    // End of variables declaration//GEN-END:variables
 private void gunTopla(){
           Calendar c = Calendar.getInstance(); 
c.setTime(jDateChooser1.getDate()); 
int ek=Integer.parseInt(jTextField1.getText());
c.add(Calendar.DATE, ek);
jDateChooser2.setDate(c.getTime());
      
    }
       private void gunAralik(){
          try{
           Date begin=jDateChooser1.getDate();
    Date end=jDateChooser2.getDate();
    int days=Days.daysBetween(new LocalDate(begin),new LocalDate(end)).getDays();
jTextField1.setText(df.format(days));
       } catch(NumberFormatException e){
         jTextField1.setText(df.format(0));
         jDateChooser2.setDate(jDateChooser1.getDate());
       }}
       private void fillCombos(){
    try{
        String sql="select * from birim";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            String name=rs.getString("deger");
            jComboBox1.addItem(name);
        }
    }catch(Exception e){
        
    }finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
    try{
         String sql="select * from gorev";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            String name=rs.getString("deger");
            jComboBox2.addItem(name);
        }
    }catch(Exception e){
        
    }finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }try {
        String sql="select * from gorevsekli";
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while (rs.next()){
            String name=rs.getString("deger");
            jComboBox3.addItem(name);
        }}catch(Exception e){
            
        }finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
}
       private void bilgiGetir(){
    String sql="select * from employeeinfo where employeeid=?";
    try{
        ps=conn.prepareStatement(sql);
        ps.setString(1, jLabel5.getText());
        rs=ps.executeQuery();
        while(rs.next()){
            String add1=rs.getString("name");
            String add2=rs.getString("sirname");
            jLabel7.setText(add1);
            jLabel8.setText(add2);
          byte [] imagedata=rs.getBytes("image");
    format=new ImageIcon(imagedata);
    jLabel6.setIcon(format);
    
        }
            
    }catch(Exception e){
        
    }finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }}
       private void updateTable() {
    try{
        String sql="Select * from job where sicil=?";
        ps=conn.prepareStatement(sql);
        ps.setString(1, jLabel5.getText());
        rs=ps.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }   catch(Exception e){
        
    } finally{
        try{
            rs.close();
        ps.close();
        } catch(Exception e){
        
    }
    }
    }
    private ImageIcon format=null;
    private String path=null;
    int s=0;
    byte [] personimage=null;
}
