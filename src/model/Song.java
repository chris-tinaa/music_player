/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Song {
    private String id;
    private String title;
    private String artist;
    private String album;
    private String path;

    public Song(String title) {
        this.title = title;
    }
    
    

    public Song(String title, String artist, String album, String path) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.path = path;
    }

    Song() {
    }

    
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    

    public String getAlbum(){
        return album;
    }

    public void setAlbum(String album){
        this.album = album;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    

}
