package municipal;
import hospital.HosCon;
import java.awt.Color;
import javax.swing.JOptionPane;
public class EmployeeLogin extends javax.swing.JFrame {
    String eid,pswd;
    String ss;
    MunCon mycon;
    
    public EmployeeLogin() {
         this.setUndecorated(true);
        initComponents();
        mycon=new MunCon();
        this.setBounds(300,50,626,626);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.jpg")));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/login.png")));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/1.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("EID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 180, 127, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 270, 127, 37);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 400, 190, 60);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(300, 180, 174, 32);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(300, 270, 174, 37);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 540, 210, 60);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 630, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eid=jTextField1.getText();
        pswd=jPasswordField1.getText();
        String s="SELECT * FROM employee WHERE eid="+eid+" AND epass='"+pswd+"'";
        try{
            mycon.rs=mycon.stm.executeQuery(s);
                if(mycon.rs.next()==true)
                {   
                    this.setVisible(false);
                    new MunicipalHome().setVisible(true);
                   
                }else
                {
                    JOptionPane.showMessageDialog(null,"Invalid EID or Password");
                }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new NewHos().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeLogin dialog = new EmployeeLogin();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
