/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class WelcomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeFrame
     */
    public WelcomeFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_mulai = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Petunjuk pemakaian :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, -1));

        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("1. Akun yang terdaftar sebagai artis dapat menambahkan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 370, -1));

        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("lagu ke database dan hanya bisa mengakses lagu miliknya");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 350, -1));

        jLabel4.setForeground(new java.awt.Color(255, 102, 0));
        jLabel4.setText("membuat dan memodifikasi playlist miliknya, serta dapat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 350, -1));

        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("2. Akun yang terdaftar sebagai pendengar dapat");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 320, -1));

        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("mengakses semua lagu yang ada di database, tetapi");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 339, -1));

        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("tidak bisa menambahkan lagu ke database");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 317, -1));

        btn_mulai.setBackground(new java.awt.Color(255, 255, 255));
        btn_mulai.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_mulai.setForeground(new java.awt.Color(255, 102, 0));
        btn_mulai.setText("Mulai");
        btn_mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mulaiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 277, 120, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Documents\\TUBES\\PBO\\Mulay\\assets\\beautiful-color-ui-gradients-backgrounds-peach.png")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-310, 0, 710, 60));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mulaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_mulaiActionPerformed

    public JButton getBtn_mulai() {
        return btn_mulai;
    }

    public void setBtn_mulai(JButton btn_mulai) {
        this.btn_mulai = btn_mulai;
    }

    public void setActionListener(ActionListener a){
        btn_mulai.addActionListener(a);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mulai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}