/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Audience extends User{
    
    private ArrayList<Playlist> playlist;

    public Audience(String name, String email, String password) {
        super(name, email, password);
    }
    
    public void createPlaylist(String playlistName){
        
    }
    
    public void deletePlaylist(String playlistName){
        
    }
}
