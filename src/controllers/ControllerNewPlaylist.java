/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Album;
import model.DatabaseHandler;
import model.Playlist;
import view.ArtistFrame;
import view.AudienceFrame;
import view.CreateAlbumFrame;
import view.CreatePlaylistFrame;

/**
 *
 * @author ASUS
 */
class ControllerNewPlaylist implements ActionListener{

    private CreatePlaylistFrame createPlaylistView;
    private DatabaseHandler db;
    private String nama, creator;
    private AudienceFrame frame;
    
    public ControllerNewPlaylist(String creator, AudienceFrame frame){
         
        this.creator = creator;
        this.frame = frame;
        createPlaylistView = new CreatePlaylistFrame();
        createPlaylistView.addActionListener(this);
        createPlaylistView.setVisible(true);
        db = new DatabaseHandler();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(createPlaylistView.getBtn_ok())){
            
            nama = createPlaylistView.getTf_nama();
            
            Playlist p = new Playlist(nama, creator);
            db.addPlaylist(p);
            
            frame.setList_playlist(db.readAllPlaylist(creator));
            frame.setPlaylistList(db.readAllPlaylist(creator));
            createPlaylistView.dispose();
        } 
    }
    
}
