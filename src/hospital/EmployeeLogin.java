package hospital;
import municipal.NewHos;
import hospital.HosCon;
import javax.swing.JOptionPane;
public class EmployeeLogin extends javax.swing.JFrame {
    String eid,pswd,hid;
    String ss;
    HosCon mycon;
    
    public EmployeeLogin() {
        this.setUndecorated(true);
        initComponents();
        mycon=new HosCon();
        this.setBounds(300,50,626,626);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/12.jpg")));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/login.png")));
         }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("EID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 180, 133, 32);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 270, 133, 37);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 460, 186, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(300, 180, 157, 32);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(300, 267, 157, 40);

        jLabel3.setText("HID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 100, 93, 32);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(300, 100, 157, 32);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 630, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eid=jTextField1.getText().toString();
        pswd=jPasswordField1.getText().toString();
        hid=jTextField2.getText().toString();
        String s="SELECT * FROM employee WHERE eid="+eid+" AND epass='"+pswd+"'";
        try{
            mycon.rs=mycon.stm.executeQuery(s);
                if(mycon.rs.next()==true)
                {   
                    this.setVisible(false);
                    new HosHome(this,true,hid).setVisible(true);
                    
                }else
                {
                    JOptionPane.showMessageDialog(null,"Invalid EID or Password");
                }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
