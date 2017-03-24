/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.AllTracks;
import data.CustomerTracks;
import data.TrackedTimeItem;
import java.awt.Color;
import java.awt.HeadlessException;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import logic.Export;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.TreeNode;

/**
 *
 * @author Lars
 */
public class MainFrame extends javax.swing.JFrame {

    private Date createdDate = new Date();
    private Timer timer;
    private JLabel jLTemplatePath = new JLabel();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        boolean readSaveState = readSaveState();
        if (readSaveState) {
            buildTree();
        }
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,
                        "Wollen sie Speicher und Schließen?",
                        "Wirklich schließen?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    if (save()) {
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Fehler beim Speichern", "Speichern", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.exit(0);
                }
            }
        });
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
        jBTamplate = new javax.swing.JButton();
        jBDeleteTreeleafs = new javax.swing.JButton();
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
        jBDeleteCustomer = new javax.swing.JButton();
        jPTrackItem = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTAction = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jcbKindOfAction = new javax.swing.JComboBox<>();
        jSStartTime = new javax.swing.JSpinner();
        jSStopTime = new javax.swing.JSpinner();
        jBSaveTaskChange = new javax.swing.JButton();
        jBDublicateTask = new javax.swing.JButton();
        jBDeleteTrack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Clienten Time Sheet Generator");
        setMinimumSize(new java.awt.Dimension(990, 640));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPMenue.setBackground(new java.awt.Color(169, 1, 0));
        jPMenue.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPMenue.setMaximumSize(new java.awt.Dimension(32767, 82));
        jPMenue.setPreferredSize(new java.awt.Dimension(960, 63));
        jPMenue.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jBnewCustomer.setBackground(new java.awt.Color(252, 252, 252));
        jBnewCustomer.setText("neuer Mandant");
        jBnewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnewCustomerActionPerformed(evt);
            }
        });
        jPMenue.add(jBnewCustomer);

        jBSave.setBackground(new java.awt.Color(252, 252, 252));
        jBSave.setText("Speichern");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });
        jPMenue.add(jBSave);

        jBExport.setBackground(new java.awt.Color(252, 252, 252));
        jBExport.setText("Export");
        jBExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExportActionPerformed(evt);
            }
        });
        jPMenue.add(jBExport);

        jBTamplate.setBackground(new java.awt.Color(252, 252, 252));
        jBTamplate.setText("Template");
        jBTamplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTamplateActionPerformed(evt);
            }
        });
        jPMenue.add(jBTamplate);

        jBDeleteTreeleafs.setBackground(new java.awt.Color(252, 252, 252));
        jBDeleteTreeleafs.setText("Formular leeren");
        jBDeleteTreeleafs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteTreeleafsActionPerformed(evt);
            }
        });
        jPMenue.add(jBDeleteTreeleafs);

        getContentPane().add(jPMenue);

        jPSeperator.setBackground(new java.awt.Color(169, 1, 0));
        jPSeperator.setMaximumSize(new java.awt.Dimension(32767, 10));

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 2));
        jSeparator1.setMinimumSize(new java.awt.Dimension(2, 2));

        javax.swing.GroupLayout jPSeperatorLayout = new javax.swing.GroupLayout(jPSeperator);
        jPSeperator.setLayout(jPSeperatorLayout);
        jPSeperatorLayout.setHorizontalGroup(
            jPSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSeperatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
        );
        jPSeperatorLayout.setVerticalGroup(
            jPSeperatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSeperatorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPSeperator);

        jPCustomers.setBackground(new java.awt.Color(204, 204, 204));
        jPCustomers.setBorder(javax.swing.BorderFactory.createTitledBorder("Mandant"));
        jPCustomers.setAutoscrolls(true);
        jPCustomers.setMinimumSize(new java.awt.Dimension(960, 540));
        jPCustomers.setPreferredSize(new java.awt.Dimension(960, 560));
        jPCustomers.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jScrollPane1.setMinimumSize(new java.awt.Dimension(19, 150));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(960, 350));

        jTreeCustomer.setBackground(new java.awt.Color(252, 252, 252));
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Mandanten");
        jTreeCustomer.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeCustomer.setVisibleRowCount(2000);
        jTreeCustomer.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeCustomerValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCustomer);

        jPCustomers.add(jScrollPane1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 140));

        jPCustomorMenue.setBackground(new java.awt.Color(204, 204, 204));
        jPCustomorMenue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPCustomorMenue.setToolTipText("");
        jPCustomorMenue.setAlignmentX(0.0F);
        jPCustomorMenue.setAlignmentY(0.0F);
        jPCustomorMenue.setMinimumSize(new java.awt.Dimension(960, 41));
        jPCustomorMenue.setPreferredSize(new java.awt.Dimension(960, 50));

        jLKlient.setText("Mandant: X");
        jPCustomorMenue.add(jLKlient);

        jBStartTimeTrack.setBackground(new java.awt.Color(252, 252, 252));
        jBStartTimeTrack.setText("Start");
        jBStartTimeTrack.setEnabled(false);
        jBStartTimeTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStartTimeTrackActionPerformed(evt);
            }
        });
        jPCustomorMenue.add(jBStartTimeTrack);

        jBStopTimeTrack.setBackground(new java.awt.Color(252, 252, 252));
        jBStopTimeTrack.setText("Stopp");
        jBStopTimeTrack.setEnabled(false);
        jBStopTimeTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBStopTimeTrackActionPerformed(evt);
            }
        });
        jPCustomorMenue.add(jBStopTimeTrack);

        jLTime.setText("Zeit: ");
        jPCustomorMenue.add(jLTime);

        jBDeleteCustomer.setBackground(new java.awt.Color(252, 252, 252));
        jBDeleteCustomer.setText("Lösche Mandanten");
        jBDeleteCustomer.setEnabled(false);
        jBDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteCustomerActionPerformed(evt);
            }
        });
        jPCustomorMenue.add(jBDeleteCustomer);

        jPTrackItem.setBackground(new java.awt.Color(204, 204, 204));
        jPTrackItem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPTrackItem.setAlignmentX(0.0F);
        jPTrackItem.setAlignmentY(0.0F);
        jPTrackItem.setMinimumSize(new java.awt.Dimension(14, 80));
        jPTrackItem.setPreferredSize(new java.awt.Dimension(960, 100));
        jPTrackItem.setLayout(new javax.swing.BoxLayout(jPTrackItem, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(960, 50));

        jTAction.setMinimumSize(new java.awt.Dimension(100, 26));
        jTAction.setPreferredSize(new java.awt.Dimension(200, 26));
        jTAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTActionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 956, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jTAction, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addComponent(jTAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE)))
        );

        jPTrackItem.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(960, 50));

        jcbKindOfAction.setBackground(new java.awt.Color(252, 252, 252));
        jcbKindOfAction.setEditable(true);
        jcbKindOfAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Büroorga", "Telefonat", "Email", "diverse Korrespondenz", "Besprechung", "Marketing", "Akquise", "Review", "Entwurf", "Review und Entwurf", "Recherche", "Verfügung" }));
        jcbKindOfAction.setPreferredSize(new java.awt.Dimension(200, 26));
        jPanel3.add(jcbKindOfAction);

        jSStartTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jPanel3.add(jSStartTime);

        jSStopTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));
        jPanel3.add(jSStopTime);

        jBSaveTaskChange.setBackground(new java.awt.Color(252, 252, 252));
        jBSaveTaskChange.setText("speichern");
        jBSaveTaskChange.setEnabled(false);
        jBSaveTaskChange.setMaximumSize(new java.awt.Dimension(80, 29));
        jBSaveTaskChange.setMinimumSize(new java.awt.Dimension(80, 29));
        jBSaveTaskChange.setPreferredSize(new java.awt.Dimension(90, 29));
        jBSaveTaskChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveTaskChangeActionPerformed(evt);
            }
        });
        jPanel3.add(jBSaveTaskChange);

        jBDublicateTask.setBackground(new java.awt.Color(252, 252, 252));
        jBDublicateTask.setText("duplizieren");
        jBDublicateTask.setEnabled(false);
        jBDublicateTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDublicateTaskActionPerformed(evt);
            }
        });
        jPanel3.add(jBDublicateTask);

        jBDeleteTrack.setBackground(new java.awt.Color(252, 252, 252));
        jBDeleteTrack.setText("löschen");
        jBDeleteTrack.setEnabled(false);
        jBDeleteTrack.setMaximumSize(new java.awt.Dimension(90, 29));
        jBDeleteTrack.setMinimumSize(new java.awt.Dimension(90, 29));
        jBDeleteTrack.setPreferredSize(new java.awt.Dimension(90, 29));
        jBDeleteTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteTrackActionPerformed(evt);
            }
        });
        jPanel3.add(jBDeleteTrack);

        jPTrackItem.add(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPCustomorMenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPTrackItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPCustomorMenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTrackItem, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPCustomers.add(jPanel1);

        getContentPane().add(jPCustomers);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnewCustomerActionPerformed
        String S = JOptionPane.showInputDialog("Bitte neuen Mandanten Eingeben!");
        AllTracks instance = AllTracks.getInstance();
        CustomerTracks get = instance.getAllCustomers().get(S);
        int bevor = instance.getAllCustomers().size();
        if (get == null) {
            CustomerTracks ct = new CustomerTracks(S);

            instance.getAllCustomers().put(ct.getCustomername(), ct);
            DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
            model.insertNodeInto(new DefaultMutableTreeNode(ct), root, root.getChildCount());
        } else {
            JOptionPane.showMessageDialog(null, "Mandant schon vorhanden!");
        }
        if (bevor == 0) {
            jTreeCustomer.expandRow(0);
            jTreeCustomer.setRootVisible(false);
            jTreeCustomer.collapseRow(0);
        }
    }//GEN-LAST:event_jBnewCustomerActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        if (save()) {
            JOptionPane.showMessageDialog(null, "Der Zustand wurde gespeichert.");
        } else {
            JOptionPane.showMessageDialog(null, "Fehler beim Speichern");
        }

    }//GEN-LAST:event_jBSaveActionPerformed
    private boolean save() {
        if (timer == null) {
            OutputStream fos = null;
            try {
                fos = new FileOutputStream(System.getProperty("user.dir") + "/saveState");
                ObjectOutputStream o = new ObjectOutputStream(fos);
                AllTracks instance = AllTracks.getInstance();
                o.writeObject(instance.getAllCustomers());
                o.writeObject(jLTemplatePath);
                return true;
            } catch (FileNotFoundException e) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, e);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fos.close();
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
    private void jTreeCustomerValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeCustomerValueChanged

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        String s = selectedNode.getUserObject().getClass().getName();// data.TrackedTimeItem
        Date now;
        try {
            switch (s) {
                case "data.CustomerTracks":
                    CustomerTracks userObject = (CustomerTracks) selectedNode.getUserObject();
                    jLKlient.setText("Mandant: " + userObject.getCustomername());
                    jTAction.setText("");
                    jcbKindOfAction.setSelectedIndex(0);
                    now = new java.util.Date();
                    jSStartTime.setValue(now);
                    jSStopTime.setValue(now);
                    jBDeleteTrack.setEnabled(false);
                    jBSaveTaskChange.setEnabled(false);
                    jBStartTimeTrack.setEnabled(true);
                    jBDeleteCustomer.setEnabled(true);
                    jBDublicateTask.setEnabled(false);
                    break;
                case "data.TrackedTimeItem":
                    TrackedTimeItem trackObject = (TrackedTimeItem) selectedNode.getUserObject();
                    jTAction.setText(trackObject.getKommand());
                    jcbKindOfAction.setSelectedItem(trackObject.getKindOfAction());
                    jSStartTime.setValue(trackObject.getStartTime());
                    jSStopTime.setValue(trackObject.getEndTime());
                    jBDeleteTrack.setEnabled(true);
                    jBSaveTaskChange.setEnabled(true);
                    jBDeleteCustomer.setEnabled(false);
                    jBStartTimeTrack.setEnabled(false);
                    jBStopTimeTrack.setEnabled(false);
                    jBDublicateTask.setEnabled(true);
                    break;
                case "java.lang.String":
                    jLKlient.setText("Mandant: ");
                    jTAction.setText("");
                    jcbKindOfAction.setSelectedIndex(0);
                    now = new java.util.Date();
                    jSStartTime.setValue(now);
                    jSStopTime.setValue(now);
                    jBDeleteTrack.setEnabled(false);
                    jBSaveTaskChange.setEnabled(false);
                    jBDeleteCustomer.setEnabled(false);
                    jBStartTimeTrack.setEnabled(false);
                    jBStopTimeTrack.setEnabled(false);
                    jBDublicateTask.setEnabled(false);
                    break;
            }
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(null, "Fehler:" + e.getMessage());
        }


    }//GEN-LAST:event_jTreeCustomerValueChanged

    private void jBStopTimeTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStopTimeTrackActionPerformed

        if (jTAction.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte einen Beschreibungstext eingeben und erneut Stopp betätigen");
            return;
        } else {
            jBStartTimeTrack.setEnabled(true);
            jBStopTimeTrack.setEnabled(false);
            jTreeCustomer.setEnabled(true);
            java.util.Date now = new java.util.Date();
            jSStopTime.setValue(now);
            TrackedTimeItem TTI;
            try {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
                String name = selectedNode.getUserObject().getClass().getName();
                if (name.equals("data.CustomerTracks")) {
                    CustomerTracks CT = (CustomerTracks) selectedNode.getUserObject();
                    DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
                    TTI = new TrackedTimeItem(createdDate, now, jTAction.getText(), jcbKindOfAction.getSelectedItem().toString());
                    model.insertNodeInto(new DefaultMutableTreeNode(TTI), selectedNode, selectedNode.getChildCount());
                    CT.getCustomeritems().add(TTI);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(TTI.getEndTime());

                } else if (name.equals("data.TrackedTimeItem")) {
                    DefaultMutableTreeNode selectedNodeParent = (DefaultMutableTreeNode) selectedNode.getParent();
                    CustomerTracks CT = (CustomerTracks) selectedNodeParent.getUserObject();
                    DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
                    TTI = new TrackedTimeItem(createdDate, now, jTAction.getText(), jcbKindOfAction.getSelectedItem().toString());
                    model.insertNodeInto(new DefaultMutableTreeNode(TTI), selectedNodeParent, selectedNodeParent.getChildCount());
                    CT.getCustomeritems().add(TTI);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(TTI.getEndTime());
                }
                jTAction.setText("");
                jLTime.setText("Zeit");
                jLTime.setForeground(Color.BLACK);
                timer.cancel();
                timer = null;

            } catch (ClassCastException e) {
                JOptionPane.showMessageDialog(this, "Fehler bitte an Programmierer wenden");
            }
        }
    }//GEN-LAST:event_jBStopTimeTrackActionPerformed

    private void jBStartTimeTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBStartTimeTrackActionPerformed
        jBStartTimeTrack.setEnabled(false);
        jBStopTimeTrack.setEnabled(true);
        jTreeCustomer.setEnabled(false);
        createdDate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(createdDate);
        jSStartTime.setValue(createdDate);
        jLTime.setText("Zeit ");
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                jLTime.setText("Zeit " + getAgeInSeconds());
            }
        }, 1000, 1000);
        jLTime.setForeground(Color.red);
    }//GEN-LAST:event_jBStartTimeTrackActionPerformed

    private void jTActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTActionActionPerformed

    private void jBExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExportActionPerformed
        if (jLTemplatePath.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fehler kein Tamplate gefunden", "Export", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter xlsxfilter = new FileNameExtensionFilter(
                "xlsx files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(xlsxfilter);
        fileChooser.setDialogTitle("Speicherort");
        fileChooser.showOpenDialog(this);

        fileChooser.setAcceptAllFileFilterUsed(false);

        if (fileChooser.getSelectedFile() != null) {
            Export exp = new Export(fileChooser, jLTemplatePath.getText());
            try {
                boolean convertXls = exp.convertXls();
                if (convertXls) {
                    JOptionPane.showMessageDialog(this, "Erfolgreich Exportiert unter: " + fileChooser.getSelectedFile().toString());
                    //export entity delete
                } else {
                    JOptionPane.showMessageDialog(this, "Leider nicht Erfolgreich Exportiert!");
                }
            } catch (HeadlessException | IOException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Fehler: " + ex.getMessage(), "Export", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBExportActionPerformed

    private void jBDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteCustomerActionPerformed
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        try {
            CustomerTracks CT = (CustomerTracks) selectedNode.getUserObject();
            AllTracks instance = AllTracks.getInstance();
            instance.getAllCustomers().remove(CT.getCustomername());
            buildTree();
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(null, "Fehler bitte einen Mandanten auswählen", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBDeleteCustomerActionPerformed

    private void jBTamplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTamplateActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".xlsx", "xlsx"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.showOpenDialog(this);
        if (fileChooser.getSelectedFile() != null) {
            jLTemplatePath.setText(fileChooser.getSelectedFile().toString());
            jLTemplatePath.setForeground(new java.awt.Color(252, 252, 252));
            jPMenue.add(jLTemplatePath);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }//GEN-LAST:event_jBTamplateActionPerformed

    private void jBDeleteTreeleafsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteTreeleafsActionPerformed
        AllTracks instance = AllTracks.getInstance();
        Set set = instance.getAllCustomers().entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            CustomerTracks cusomer = (CustomerTracks) mentry.getValue();
            ArrayList<TrackedTimeItem> customeritems = new ArrayList<TrackedTimeItem>();
            cusomer.setCustomeritems(customeritems);
        }
        buildTree();
    }//GEN-LAST:event_jBDeleteTreeleafsActionPerformed

    private void jBSaveTaskChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveTaskChangeActionPerformed
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        TrackedTimeItem TI = (TrackedTimeItem) selectedNode.getUserObject();
        TI.setKommand(jTAction.getText());
        TI.setKindOfAction(jcbKindOfAction.getSelectedItem().toString());
        TI.setStartTime((Date) jSStartTime.getModel().getValue());
        TI.setEndTime((Date) jSStopTime.getModel().getValue());
        selectedNode.setUserObject(TI);
        DefaultMutableTreeNode selectedNode2 = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        String s = selectedNode2.getUserObject().getClass().getName();
        DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
        model.reload((TreeNode) selectedNode2);

    }//GEN-LAST:event_jBSaveTaskChangeActionPerformed

    private void jBDeleteTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteTrackActionPerformed
        AllTracks instance = AllTracks.getInstance();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTreeCustomer.getLastSelectedPathComponent();
        DefaultMutableTreeNode selectedNodeParent = (DefaultMutableTreeNode) selectedNode.getParent();
        CustomerTracks CT = (CustomerTracks) selectedNodeParent.getUserObject();
        CustomerTracks get = instance.getAllCustomers().get(CT.getCustomername());
        TrackedTimeItem TI = (TrackedTimeItem) selectedNode.getUserObject();
        get.getCustomeritems().remove(TI);
        buildTree();
    }//GEN-LAST:event_jBDeleteTrackActionPerformed

    private void jBDublicateTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDublicateTaskActionPerformed
        jBStopTimeTrack.setEnabled(true);
        jTreeCustomer.setEnabled(false);

        createdDate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(createdDate);
        jSStartTime.setValue(createdDate);
        jLTime.setText("Zeit ");
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                jLTime.setText("Zeit " + getAgeInSeconds());
            }
        }, 1000, 1000);
        jLTime.setForeground(Color.red);

        // TODO add your handling code here:
    }//GEN-LAST:event_jBDublicateTaskActionPerformed
    public String getAgeInSeconds() {
        Calendar cal = Calendar.getInstance();
        java.util.Date now = new java.util.Date();
        cal.setTime(now);
        long diff = now.getTime() - createdDate.getTime();//as given
        String curTime = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(diff) % 24, TimeUnit.MILLISECONDS.toMinutes(diff) % 60, TimeUnit.MILLISECONDS.toSeconds(diff) % 60);
        return curTime;
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
    private javax.swing.JButton jBDeleteCustomer;
    private javax.swing.JButton jBDeleteTrack;
    private javax.swing.JButton jBDeleteTreeleafs;
    private javax.swing.JButton jBDublicateTask;
    private javax.swing.JButton jBExport;
    private javax.swing.JButton jBSave;
    private javax.swing.JButton jBSaveTaskChange;
    private javax.swing.JButton jBStartTimeTrack;
    private javax.swing.JButton jBStopTimeTrack;
    private javax.swing.JButton jBTamplate;
    private javax.swing.JButton jBnewCustomer;
    private javax.swing.JLabel jLKlient;
    private javax.swing.JLabel jLTime;
    private javax.swing.JPanel jPCustomers;
    private javax.swing.JPanel jPCustomorMenue;
    private javax.swing.JPanel jPMenue;
    private javax.swing.JPanel jPSeperator;
    private javax.swing.JPanel jPTrackItem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSStartTime;
    private javax.swing.JSpinner jSStopTime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTAction;
    private javax.swing.JTree jTreeCustomer;
    private javax.swing.JComboBox<String> jcbKindOfAction;
    // End of variables declaration//GEN-END:variables

    private boolean readSaveState() {
        File state = new File(System.getProperty("user.dir") + "/saveState");
        if (state.isFile()) {
            InputStream fis = null;
            try {
                fis = new FileInputStream(System.getProperty("user.dir") + "/saveState");
                ObjectInputStream o = new ObjectInputStream(fis);
                AllTracks instance = AllTracks.getInstance();
                HashMap<String, CustomerTracks> allCustomers = null;
                Object confObjekt = o.readObject();
                allCustomers = (HashMap<String, CustomerTracks>) confObjekt;
                confObjekt = o.readObject();
                jLTemplatePath = (JLabel) confObjekt;
                jPMenue.add(jLTemplatePath);
                SwingUtilities.updateComponentTreeUI(this);
                instance.setAllCustomers(allCustomers);
                return true;
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Fehler beim Laden der saveState Datei: \n" + e.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        return false;
    }

    private void buildTree() {
        AllTracks instance = AllTracks.getInstance();
        DefaultTreeModel model = (DefaultTreeModel) jTreeCustomer.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        Set set = instance.getAllCustomers().entrySet();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            CustomerTracks cusomer = (CustomerTracks) mentry.getValue();
            DefaultMutableTreeNode first = new DefaultMutableTreeNode(cusomer);
            model.insertNodeInto(first, root, root.getChildCount());
            for (TrackedTimeItem ti : cusomer.getCustomeritems()) {
                model.insertNodeInto(new DefaultMutableTreeNode(ti), first, first.getChildCount());
            }
        }
        if (instance.getAllCustomers().size() != 0) {
            jTreeCustomer.expandRow(0);
            jTreeCustomer.setRootVisible(false);
            jTreeCustomer.collapseRow(0);
        }
        jBDeleteTrack.setEnabled(false);
        jBSaveTaskChange.setEnabled(false);
        jBStartTimeTrack.setEnabled(false);
        jBStopTimeTrack.setEnabled(false);
        jBDeleteCustomer.setEnabled(false);
        jBDublicateTask.setEnabled(false);
        SwingUtilities.updateComponentTreeUI(this);
    }
}
