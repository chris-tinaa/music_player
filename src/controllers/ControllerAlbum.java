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
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import model.Album;
import model.DatabaseHandler;
import model.Song;

import view.ArtistFrame;
import view.AudienceFrame;
import view.CreateAlbumFrame;
import view.LoginFrame;
import view.RegisterFrame;

/**
 *
 * @author ASUS
 */
public class ControllerAlbum implements ActionListener, MouseListener{
    private ArtistFrame artistFrame;
    private DatabaseHandler db;
    
    public ControllerAlbum(String artistName){
        artistFrame = new ArtistFrame(artistName);
        artistFrame.addActionListener(this);
        artistFrame.addMouseListener(this);
        artistFrame.setVisible(true);
        db = new DatabaseHandler();
        artistFrame.setList_album(db.readAllAlbum(artistName));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(artistFrame.getBtn_repeat())){
            
            if ( artistFrame.getPlayerMusic().isRepeat()){
                artistFrame.getPlayerMusic().setRepeat(false);
                artistFrame.getBtn_repeat().setSelected(false);
            } else {
                artistFrame.getPlayerMusic().setRepeat(true);
                artistFrame.getBtn_repeat().setSelected(true);
            }
            
        } else if (s.equals(artistFrame.getBtn_shuffle())){
            
            if (artistFrame.getPlayerMusic().isShuffle()){
                artistFrame.getPlayerMusic().setShuffle(false);
                artistFrame.getBtn_shuffle().setSelected(false);
            } else{
                artistFrame.getPlayerMusic().setShuffle(true);
                artistFrame.getBtn_shuffle().setSelected(true);
            }

        } else if (s.equals(artistFrame.getBtn_add_album())){
            
            new ControllerNewAlbum(artistFrame.getTv_nama(), artistFrame);
            
            
        } else if (s.equals(artistFrame.getBtn_logout())){
            
            artistFrame.dispose();
            new ControllerLogin();
            
        } else if (s.equals(artistFrame.getBtn_add_lagu())){
            
            String album = artistFrame.getList_album().getSelectedValue();
            String singer = artistFrame.getTv_nama();
            Album a = new Album();
            
            Song song = a.addSong(artistFrame);
            song.setArtist(singer);
            song.setAlbum(album);
            
            db.addSong(song);
            
            ArrayList ls = db.readSongsFromAlbum(album);
            artistFrame.setList_song_album(ls);
            artistFrame.setFileList(ls);
            
        } else if (s.equals(artistFrame.getBtn_play())){
            
            artistFrame.getPlayerMusic().play(artistFrame);
            
        } else if (s.equals(artistFrame.getBtn_next())){
            
            artistFrame.getPlayerMusic().next(artistFrame);
            
        } else if (s.equals(artistFrame.getBtn_pause())){
            
            artistFrame.getPlayerMusic().pause(artistFrame);
            
        } else if (s.equals(artistFrame.getBtn_prev())){
            
            artistFrame.getPlayerMusic().prev(artistFrame);
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object s = e.getSource();
        if (s.equals(artistFrame.getList_album())){
            String currentAlbum = artistFrame.getList_album().getSelectedValue();
            artistFrame.setTv_current_album(currentAlbum);
            
            ArrayList ls = db.readSongsFromAlbum(currentAlbum);
            artistFrame.setList_song_album(ls);
            artistFrame.setFileList(ls);
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
