/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import model.Album;
import model.DatabaseHandler;
import model.Playlist;
import model.Song;
import view.AudienceFrame;

/**
 *
 * @author ASUS
 */
public class ControllerPlaylist implements ActionListener, MouseListener{
    private AudienceFrame audienceFrame;
    private DatabaseHandler db;
    
    public ControllerPlaylist(String creatorName){
        audienceFrame = new AudienceFrame(creatorName);
        audienceFrame.addActionListener(this);
        audienceFrame.addMouseListener(this);
        audienceFrame.setVisible(true);
        db = new DatabaseHandler();
        
        audienceFrame.setPlaylistList(db.readAllPlaylist(creatorName));
        audienceFrame.setList_playlist(db.readAllPlaylist(creatorName));
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(audienceFrame.getBtn_repeat())){
            
            if ( audienceFrame.getPlayerMusic().isRepeat()){
                audienceFrame.getPlayerMusic().setRepeat(false);
                audienceFrame.getBtn_repeat().setSelected(false);
            } else {
                audienceFrame.getPlayerMusic().setRepeat(true);
                audienceFrame.getBtn_repeat().setSelected(true);
            }
            
        } else if (s.equals(audienceFrame.getBtn_shuffle())){
            
            if (audienceFrame.getPlayerMusic().isShuffle()){
                audienceFrame.getPlayerMusic().setShuffle(false);
                audienceFrame.getBtn_shuffle().setSelected(false);
            } else{
                audienceFrame.getPlayerMusic().setShuffle(true);
                audienceFrame.getBtn_shuffle().setSelected(true);
            }

        } else if (s.equals(audienceFrame.getBtn_add_playlist())){
            
            new ControllerNewPlaylist(audienceFrame.getTv_nama(), audienceFrame);
            
            
        } else if (s.equals(audienceFrame.getBtn_logout())){
            
            audienceFrame.dispose();
            new ControllerLogin();
            
        } else if (s.equals(audienceFrame.getBtn_add_lagu())){
            ArrayList<Song> songs = db.readAllSongs();
            
            int iAktif = audienceFrame.getList_playlist().getSelectedIndex();
            Playlist p = audienceFrame.getPlaylistList().get(iAktif);
            new ControllerChoosingSong(songs, p, audienceFrame);
            
//            ArrayList ls = db.readSongsFromPlaylist(p.getCreatorName());
//            audienceFrame.setList_playlist(ls);
//            audienceFrame.setFileList(ls);
            
        } else if (s.equals(audienceFrame.getBtn_play())){
            
            audienceFrame.getPlayerMusic().play(audienceFrame);
            
        } else if (s.equals(audienceFrame.getBtn_next())){
            
            audienceFrame.getPlayerMusic().next(audienceFrame);
            
        } else if (s.equals(audienceFrame.getBtn_pause())){
            
            audienceFrame.getPlayerMusic().pause(audienceFrame);
            
        } else if (s.equals(audienceFrame.getBtn_prev())){
            
            audienceFrame.getPlayerMusic().prev(audienceFrame);
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object s = e.getSource();
        if (s.equals(audienceFrame.getList_playlist())){
            
            String currentPlaylist = audienceFrame.getList_playlist().getSelectedValue();
            ArrayList<Song> ls = null;
            audienceFrame.getBtn_add_lagu().setVisible(true);
            if (currentPlaylist != null){
                if (currentPlaylist.equals("Semua Lagu")){
                    audienceFrame.getBtn_add_lagu().setVisible(false);
                }
                
                audienceFrame.setLb_daftar_lagu(currentPlaylist);
            
                ls = db.readSongsFromPlaylist(currentPlaylist);
                
            audienceFrame.setList_song_playlist(ls);
            audienceFrame.setFileList(ls);
            }
           
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
