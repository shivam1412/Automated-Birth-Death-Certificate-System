package hospital;

import javax.swing.ImageIcon;

public class HosHome extends javax.swing.JDialog {
String hid;
    public HosHome(java.awt.Frame parent, boolean modal,String hid) {
        super(parent, modal);
        initComponents();
        this.setBounds(0, 0, 1378, 768); 
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Hospital.jpg")));
        this.hid=hid;
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("BIRTH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 330, 196, 70);

        jButton2.setText("DEATH");
        getContentPane().add(jButton2);
        jButton2.setBounds(820, 330, 196, 67);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new BirthForm(hid).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
