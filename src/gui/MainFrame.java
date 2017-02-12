/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.AllTracks;
import data.CustomerTrachs;
import data.TrackedTimeItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Lars
 */
public class MainFrame extends javax.swing.JFrame {

    private Date createdDate;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        readSaveState();
        buildTree();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMenue = new javax.swing.JPanel();
        jBnewCustomer = new javax.swing.JButton();
        jBSave = new javax.swing.JButton();
        jBExport = new javax.swing.JButton();
        jPSeperator = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPCustomers = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCustomer = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jPCustomorMenue = new javax.swing.JPanel();
        jLKlient = new javax.swing.JLabel();
        jBStartTimeTrack = new javax.swing.JButton();
        jBStopTimeTrack = new javax.swing.JButton();
        jLTime = new javax.swing.JLabel();
        jPTrackItem = new javax.swing.JPanel();
        jTAction = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLStartTime = new javax.swing.JLabel();
        jStopTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clienten Time Sheet Generator");
        setMinimumSize(new java.awt.Dimension(480, 280));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPMenue.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPMenue.setMaximumSize(new java.awt.Dimension(32767, 42));
        jPMenue.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jBnewCustomer.setText("neuer Kunde");
        jBnewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnewCustomerActionPerformed(evt);
            }
        });
        jPMenue.add(jBnewCustomer);

        jBSave.setText("Speichern");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });
        jPMenue.add(jBSave);

        jBExport.setText("Export");
        jPMenue.add(jBExport);

        getContentPane().add(jPMenue);

        jPSeperator.setMaximumSize(new java.awt.Dimension(32767, 10));

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 2));
        jSeparator1.setMinimumSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout jPSeperatorLayout = new javax.swing.GroupLayout(jPSeperator);
        jPSeperator.setLayout(jPSeperatorLayout);
        jPSeperatorLayout.setHorizontalGroup(
            jPSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSeperatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
        );
        jPSeperatorLayout.setVerticalGroup(
            jPSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSeperatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPSeperator);

        jPCustomers.setBorder(javax.swing.BorderFactory.createTitledBorder("Klienten"));
        jPCustomers.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(23, 40));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(120, 384));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Klient");
        jTreeCustomer.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeCustomer.setMaximumSize(new java.awt.Dimension(100, 30));
        jTreeCustomer.setPreferredSize(new java.awt.Dimension(150, 19));
        jTreeCustomer.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeCustomerValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCustomer);

        jPCustomers.add(jScrollPane1);

        jPCustomorMenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPCustomorMenue.setMinimumSize(new java.awt.Dimension(450, 41));
        jPCustomorMenue.setPreferredSize(new java.awt.Dimension(450, 50));

        jLKlient.setText("Klient: X");
        jPCustomorMenue.add(jLKlient);

        jBStartTimeTrack.setText("Start");
        jBStartTimeTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStartTimeTrackActionPerformed(evt);
            }
        });
        jPCustomorMenue.add(jBStartTimeTrack);

        jBStopTimeTrack.setText("Stopp");
        jBStopTimeTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStopTimeTrackActionPerformed(evt);
            }
        });
        jPCustomorMenue.add(jBStopTimeTrack);

        jLTime.setText("Zeit: ");
        jPCustomorMenue.add(jLTime);

        jTAction.setMinimumSize(new java.awt.Dimension(100, 26));
        jTAction.setPreferredSize(new java.awt.Dimension(200, 26));
        jTAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTActionActionPerformed(evt);
            }
        });
        jPTrackItem.add(jTAction);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Büroorga", "Bonny" }));
        jPTrackItem.add(jComboBox1);

        jLStartTime.setText("StartTime");
        jPTrackItem.add(jLStartTime);

        jStopTime.setText("Endtime");
        jPTrackItem.add(jStopTime);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPCustomorMenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPTrackItem, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPCustomorMenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jPTrackItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPCustomers.add(jPanel1);

        getContentPane().add(jPCustomers);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnewCustomerActionPerformed
        String S = JOptionPane.showInputDialog("Bitte neuen Klienten Eingeben!");
        CustomerTrachs ct = new CustomerTrachs(S);
        AllTracks instance = AllTracks.getInstance();
        instance.getAllCustomers().add(ct);
        DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.insertNodeInto(new DefaultMutableTreeNode(ct), root, root.getChildCount());
    }//GEN-LAST:event_jBnewCustomerActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(System.getProperty("user.dir") + "/saveState");
            System.out.println(System.getProperty("user.dir") + "/saveState");
            ObjectOutputStream o = new ObjectOutputStream(fos);
            AllTracks instance = AllTracks.getInstance();
            o.writeObject(instance.getAllCustomers());
            JOptionPane.showMessageDialog(this, "Der Zustand wurde gespeichert.");
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jTreeCustomerValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCustomerValueChanged
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        CustomerTrachs userObject = (CustomerTrachs) selectedNode.getUserObject();
        jLKlient.setText("Klient: " + userObject.getCustomername());

    }//GEN-LAST:event_jTreeCustomerValueChanged

    private void jBStopTimeTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStopTimeTrackActionPerformed
        if (createdDate == null) {
            return;
        } else {
            System.out.println(getAgeInSeconds());
            jLTime.setText("Zeit in Sekunden: " + getAgeInSeconds() + "s");

            jStopTime.setText("Endtime" + createdDate.getTime());

            java.util.Date now = new java.util.Date();
            TrackedTimeItem TTI = new TrackedTimeItem(createdDate, now, jTAction.getText());
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
            CustomerTrachs CT = (CustomerTrachs) selectedNode.getUserObject();
            CT.getCustomeritems().add(TTI);
        }


    }//GEN-LAST:event_jBStopTimeTrackActionPerformed

    private void jBStartTimeTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStartTimeTrackActionPerformed
        createdDate = new java.util.Date();

    }//GEN-LAST:event_jBStartTimeTrackActionPerformed

    private void jTActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTActionActionPerformed
    public int getAgeInSeconds() {

        java.util.Date now = new java.util.Date();
        return (int) ((now.getTime() - this.createdDate.getTime()) / 1000);
    }

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExport;
    private javax.swing.JButton jBSave;
    private javax.swing.JButton jBStartTimeTrack;
    private javax.swing.JButton jBStopTimeTrack;
    private javax.swing.JButton jBnewCustomer;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLKlient;
    private javax.swing.JLabel jLStartTime;
    private javax.swing.JLabel jLTime;
    private javax.swing.JPanel jPCustomers;
    private javax.swing.JPanel jPCustomorMenue;
    private javax.swing.JPanel jPMenue;
    private javax.swing.JPanel jPSeperator;
    private javax.swing.JPanel jPTrackItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jStopTime;
    private javax.swing.JTextField jTAction;
    private javax.swing.JTree jTreeCustomer;
    // End of variables declaration//GEN-END:variables

    private void readSaveState() {
        File state = new File(System.getProperty("user.dir") + "/saveState");
        if (state.isFile()) {
            String[] optionen = {"Ja", "Nein"};
            int n = JOptionPane.showOptionDialog(null,
                    "Das Programm wurde bei einem Nutzung unterbrochen."
                    + " Möchten Sie den Zustand wiederherstellen?", // question
                    "Zustand wiederherstellen", // title
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, // icon
                    null, optionen, optionen[0]);
            if (n == JOptionPane.YES_OPTION) {
                InputStream fis = null;
                try {
                    fis = new FileInputStream(System.getProperty("user.dir") + "/saveState");
                    ObjectInputStream o = new ObjectInputStream(fis);
                    AllTracks instance = AllTracks.getInstance();
                    ArrayList<CustomerTrachs> allCustomers = null;
                    Object confObjekt = o.readObject();

                    allCustomers = (ArrayList<CustomerTrachs>) confObjekt;
                    instance.setAllCustomers(allCustomers);
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println(e);
                } finally {
                    try {
                        fis.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    private void buildTree() {
        AllTracks instance = AllTracks.getInstance();
        DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (CustomerTrachs cusomer : instance.getAllCustomers()) {
            DefaultMutableTreeNode first = (DefaultMutableTreeNode) model.getRoot();
            model.insertNodeInto(new DefaultMutableTreeNode(cusomer), root, root.getChildCount());
            for (TrackedTimeItem ti : cusomer.getCustomeritems()) {
                model.insertNodeInto(new DefaultMutableTreeNode(ti.getStartTime()), first, first.getChildCount());
            }
        }

        /*
          for (CustomerTrachs cusomer : instance.getAllCustomers()) {
            DefaultMutableTreeNode first = (DefaultMutableTreeNode) model.getRoot();
            model.insertNodeInto(new DefaultMutableTreeNode(cusomer.getCustomername()), root, root.getChildCount());
            for (TrackedTimeItem ti : cusomer.getCustomeritems()) {
                model.insertNodeInto(new DefaultMutableTreeNode(ti.getStartTime()), first, first.getChildCount());
            }
        }
         */
    }
}
