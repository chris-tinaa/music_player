/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import model.Song;

/**
 *
 * @author ASUS
 */
public class ChoosingSongFrame extends javax.swing.JFrame {

    ArrayList<Song> songs;
    ArrayList<String> songId = new ArrayList<>();
    /**
     * Creates new form ChoosingSongFrame
     */
    public ChoosingSongFrame() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        list_all_song = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        btn_ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(list_all_song);

        jLabel1.setText("Pilih lagu yang ingin ditambahkan : ");

        btn_ok.setText("Ok");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_ok)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ok)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_okActionPerformed


    public JButton getBtn_ok() {
        return btn_ok;
    }

    public void setBtn_ok(JButton btn_ok) {
        this.btn_ok = btn_ok;
    }

    public JList getList_all_song() {
        return list_all_song;
    }

    public void setList_all_song(ArrayList<Song> songs) {
        this.songs = songs;
        // declaration and initialise String Array 
        String artistAndTitles[] = new String[songs.size()]; 
  
        // ArrayList to Array Conversion 
        for (int j = 0; j < songs.size(); j++) { 
  
            // Assign each value to String array 
            
            artistAndTitles[j] = songs.get(j).getArtist() + " - " +songs.get(j).getTitle(); 
            songId.add(songs.get(j).getId());
        } 
        
        this.list_all_song.setListData(artistAndTitles);
    }

    public ArrayList<String> getSongId() {
        return songId;
    }

    public void setSongId(ArrayList<String> songId) {
        this.songId = songId;
    }
    
    
    public void addActionListener(ActionListener a){
        btn_ok.addActionListener(a);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list_all_song;
    // End of variables declaration//GEN-END:variables
}