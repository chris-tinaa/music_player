/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.Album;
import model.DatabaseHandler;
import view.ArtistFrame;
import view.CreateAlbumFrame;
import view.LoginFrame;

/**
 *
 * @author ASUS
 */
public class ControllerNewAlbum implements ActionListener{
    private CreateAlbumFrame createAlbumView;
    private DatabaseHandler db;
    private String judul, artis;
    private ArtistFrame frame;
    
    public ControllerNewAlbum(String artis, ArtistFrame frame){
        this.artis = artis;
        this.frame = frame;
        createAlbumView = new CreateAlbumFrame();
        createAlbumView.addActionListener(this);
        createAlbumView.setVisible(true);
        db = new DatabaseHandler();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object s = ae.getSource();
        
        if (s.equals(createAlbumView.getBtn_ok())){
            
            judul = createAlbumView.getTf_judul_baru();
            
            Album a = new Album(judul, artis);
            db.addAlbum(a);
            
            createAlbumView.dispose();
            frame.setList_album(db.readAllAlbum(artis));
        } 
    }
}
