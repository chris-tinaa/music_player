/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.Song;
import model.SongList;
import model.SongListModifier;
import view.AudienceFrame;

/**
 *
 * @author ASUS
 */
public class Playlist extends SongList implements SongListModifier{
    
    File file;
    ArrayList<String> artistAndTitle = new ArrayList<>();

    public Playlist() {
        super();
    }

    
    public Playlist (String playlistTitle, String creatorName){
        super(playlistTitle, creatorName);
    }

    @Override
    public Song addSong(JFrame frame) {
        AudienceFrame f = (AudienceFrame) frame;
        f.addSong(f.getTv_nama());
        Song s = new Song(f.getTv_nama());
        return s;
    }

    @Override
    public void removeSong(Song s) {
        
    }
    
    
    public ArrayList<String> getArtistTitleList(){
        return artistAndTitle;
    }
    
    public void setListArtistAndTitle(ArrayList<String> list){
        this.artistAndTitle = list;
    }
    
}
