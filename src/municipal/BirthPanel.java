/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipal;

import hospital.HosCon;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author xplatypus07
 */
public class BirthPanel extends javax.swing.JFrame implements Runnable {
    MunCon mycon,mycon2,mycon3;
    HosCon mycon1;
    LocalDate date;
    Thread th;
    DefaultTableModel dtm1;
    String pid;
    /**
     * Creates new form BirthPanel
     */
    public BirthPanel() {
        initComponents();
        this.setBounds(300,0,748,720);
         date=LocalDate.now();
   jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.jpg")));
        
    mycon=new MunCon();
    mycon1=new HosCon();
    mycon2=new MunCon();
    mycon3=new MunCon(); 
    dtm1=(DefaultTableModel)jTable1.getModel();
    th=new Thread(this);    
    String x="SELECT DISTINCT hstate FROM hospital ";
        try
        {
            mycon.rs=mycon.stm.executeQuery(x);
           while(mycon.rs.next())
           {
               String c=mycon.rs.getString("hstate");
               jComboBox1.addItem(c);
           }
           }catch(Exception e)
        {
                e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(420, 30, 106, 38);

        jLabel1.setText("State :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 30, 105, 38);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PID", "Hospital Name", "Date of birth", "Time of birth", "Gender", "Name", "Father's Name", "Mother's Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 220, 700, 350);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(420, 80, 106, 38);

        jLabel2.setText("City :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 80, 105, 38);

        jButton1.setText("ISSUE CERTIFICATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 610, 174, 37);

        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(150, 610, 127, 37);

        jButton3.setText("GO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 160, 99, 41);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 770, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            int i=jTable1.getSelectedRow();
            String x=jTable1.getValueAt(i,0).toString();
            String qq="SELECT * FROM patient WHERE pid='"+x+"'";
            System.out.println(qq);
            try{
            mycon1.rs=mycon1.stm.executeQuery(qq);
            mycon1.rs.next();
            String a[]=mycon1.rs.getString("name").split("\\s");   
            String s=mycon1.rs.getString("sex");
            String f=mycon1.rs.getString("fatherfullname");
            String m=mycon1.rs.getString("motherfullname");
            String d=mycon1.rs.getString("dob");
            String p=mycon1.rs.getString("cityofbirth");
            String q="INSERT INTO citizen(fname,mname,lname,gender,uid,age,fathername,mothername,dob,placeofbirth,dod,placeofdeath) VALUES ('"+a[0]+"','"+a[1]+"','"+a[2]+"','"+s+"',NULL,'0','"+f+"','"+m+"',"+d+",'"+p+"',NULL,NULL)";
            mycon.stm.executeUpdate(q);
            String q1="SELECT MAX(cid) FROM citizen";
            mycon2.rs=mycon2.stm.executeQuery(q1);
            mycon2.rs.next();
            String q3="INSERT INTO certificate (dcno,cid) VALUES (NULL,'"+mycon2.rs.getString("MAX(cid)")+"')";
            mycon3.stm.executeUpdate(q3);
            String q4="UPDATE patient SET status='Y' WHERE pid="+x+"";
            mycon1.stm.executeUpdate(q4);
            this.setVisible(false);        
            new BirthCertificate().setVisible(true);
            }catch(Exception r)
            {
                r.printStackTrace();
            }
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.setVisible(false);
       new MunicipalHome().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      jComboBox2.removeAllItems();

        String x="SELECT DISTINCT hcity FROM hospital WHERE hstate='"+jComboBox1.getSelectedItem().toString()+"' ";
        try
        {
            mycon.rs=mycon.stm.executeQuery(x);
            while(mycon.rs.next())
            {
                String c=mycon.rs.getString("hcity");
                jComboBox2.addItem(c);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
       
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        th.start();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void run()
    {   
        while(true)
        {
        dtm1.setRowCount(0);
        String q="SELECT * FROM patient WHERE cityofbirth='"+jComboBox2.getSelectedItem().toString()+"' AND status='N'";
        try{
            mycon1.rs=mycon1.stm.executeQuery(q);
            while(mycon1.rs.next())
            {
                dtm1.addRow(new Object[]{mycon1.rs.getString("pid"),mycon1.rs.getString("hname"),mycon1.rs.getString("dob"), mycon1.rs.getString("tob"),mycon1.rs.getString("sex"),mycon1.rs.getString("name"),mycon1.rs.getString("fatherfullname"),mycon1.rs.getString("motherfullname")});
            }
            jTable1.setModel(dtm1);
            
            th.sleep(15000);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        }
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
