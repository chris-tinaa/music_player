/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Song;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SongList {
    protected String name;
    protected String id;
    protected String title;

    public SongList() {
    }

    public SongList(String title, String name) {
        this.name = name;
        this.title = title;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return title;
    }

    public void setAlbumTitle(String albumTitle) {
        this.title = albumTitle;
    }

    public String getArtisName() {
        return name;
    }
    public void setArtisName(String artisName) {
        this.name = artisName;
    }
    
    public String getPlaylistTitle() {
        return title;
    }
    public void setPlaylistTitle(String playlistTitle) {
        this.title = playlistTitle;
    }
    public String getCreatorName() {
        return name;
    }
    public void setCreatorName(String creatorName) {
        this.name = creatorName;
    }
}
