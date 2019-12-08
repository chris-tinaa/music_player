/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.Song;

/**
 *
 * @author ASUS
 */
public class Album extends SongList implements SongListModifier{
    JFileChooser fc = new JFileChooser();
    File file;
    ArrayList<String> artistAndTitle = new ArrayList<>();

    public Album() {
        
    }

    
    public Album (String albumTitle, String artisName){
        super(albumTitle, artisName);
    }

    @Override
    public Song addSong(JFrame frame) {
        fc.setMultiSelectionEnabled(false);
        int fileValid = fc.showOpenDialog(frame);
        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION){
            return null;
        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION){
            String file = fc.getSelectedFile().getPath();
            file = file.replace("\\", "\\\\");
            System.out.println(file);
            String title = fc.getSelectedFile().getName();
            return new Song(title,"","", file );
        }
        return null;
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
