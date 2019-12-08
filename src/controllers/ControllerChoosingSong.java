/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.DatabaseHandler;
import model.Playlist;
import model.Song;
import view.AudienceFrame;
import view.ChoosingSongFrame;
import view.CreatePlaylistFrame;

/**
 *
 * @author ASUS
 */
public class ControllerChoosingSong implements ActionListener{
    private ChoosingSongFrame choosingSongView;
    private DatabaseHandler db;
    private String nama, creator;
    private AudienceFrame frame;
    private ArrayList<Song> songs;
    private Playlist playlist;
    
    public ControllerChoosingSong(ArrayList<Song> songs, Playlist playlist, AudienceFrame frame){
        this.songs = songs;
        this.creator = creator;
        this.frame = frame;
        this.playlist = playlist;
        choosingSongView = new ChoosingSongFrame();
        choosingSongView.addActionListener(this);
        choosingSongView.setVisible(true);
        db = new DatabaseHandler();
        choosingSongView.setList_all_song(songs);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(choosingSongView.getBtn_ok())){
            
            int i = choosingSongView.getList_all_song().getSelectedIndex();
            String songId = choosingSongView.getSongId().get(i);
            String playlistId = playlist.getId();
            db.addSongToPlaylist(songId, playlistId);
            
//            ArrayList<Playlist> playlistList = db.readAllPlaylist(creator);
//            frame.setList_playlist(db.readAllPlaylist(creator));
//            frame.setList_playlist(playlistList);
            frame.setList_song_playlist(db.readSongsFromPlaylist(playlist.getPlaylistTitle()));
            frame.setFileList(db.readSongsFromPlaylist(playlist.getPlaylistTitle()));
            choosingSongView.dispose();
        } 
    }
}
