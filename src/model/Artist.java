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
public class Artist extends User{
    private ArrayList<Album> albums;

    public Artist(String name, String email, String password) {
        super(name, email, password);
    }
    
    public void createAlbum(String albumName){
        
    }
    
    public void deleteAlbum(String albumName){
        
    }
}
