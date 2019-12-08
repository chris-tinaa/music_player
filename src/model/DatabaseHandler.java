/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    private void connect(){
        try{
            String url = "jdbc:mysql://localhost/music_player";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addAudience(Audience a){
        connect();
        try{
            String query = "INSERT INTO audience(nama,email,password) VALUES ('" + a.getName()+ 
                    "','" + a.getEmail() +
                    "','" + a.getPassword() +
                    "')";
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void addArtist(Artist a){
        connect();
        try{
            String query = "INSERT INTO artis(nama,email,password) VALUES ('" + a.getName()+ 
                    "','" + a.getEmail() +
                    "','" + a.getPassword() +
                    "')";
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String loginValidity(String userType, String email, String password){
        
        connect();
        try {
            String query = "SELECT * FROM " + userType + " WHERE email='" + email + "' AND password='" + password + "'";
            rs = stmt.executeQuery(query);
            if(rs.next()){
                if (email.equals(rs.getString("email")) && password.equals(rs.getString("password"))){
                    return rs.getString("nama").toString();
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    

    public void addAlbum(Album a){
        connect();
        try{
            String query = "INSERT INTO album(judul,artis) VALUES ('" + a.getAlbumTitle()+ 
                    "','" + a.getArtisName() +
                    "')";
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void addSong(Song s){
        connect();
        try{
            String query = "INSERT INTO song(singer_name, judul, album, path) VALUES ('" + s.getArtist()+ 
                    "','" + s.getTitle() +
                    "','" + s.getAlbum()+
                    "','" + s.getPath()+
                    "')";
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<String> readAllAlbum(String singer){
        connect();
        try{
            String query = "SELECT * FROM album WHERE artis = '" + singer + "'";
            
            rs = stmt.executeQuery(query);
            ArrayList<String> album = new ArrayList<>();
            while(rs.next()){
                //System.out.println(rs.getString(2)); //here you can get data, the '1' indicates column number based on your query
                album.add(rs.getString(2));
            }

            return album;
        }catch(Exception e){
            System.out.println("Error in getData"+e);
        }
        
        return null;
    }
    
    public ArrayList<Song> readSongsFromAlbum(String albumName){
        connect();
        ArrayList<Song> ls = new ArrayList<Song>();
        try{
            String query = "SELECT * FROM song WHERE album = '" + albumName + "'";
            
            rs = stmt.executeQuery(query);
            while(rs.next()){
                //System.out.println(rs.getString(2)); //here you can get data, the '1' indicates column number based on your query
                Song song = new Song(rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6));
                ls.add(song);
            }

            return ls;
        }catch(Exception e){
            System.out.println("Error in getData"+e);
        }
        
        return null;
    }
    
    public void addPlaylist(Playlist p){
        connect();
        try{
            String query = "INSERT INTO playlist(nama, creator) VALUES ('" + p.getPlaylistTitle()+ 
                    "','" + p.getCreatorName()+
                    "')";
            stmt.executeUpdate(query);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Playlist> readAllPlaylist(String creator){
        connect();
        try{
            String query = "SELECT * FROM playlist WHERE creator = '" + creator + "'";
            
            rs = stmt.executeQuery(query);
            ArrayList<Playlist> playlist = new ArrayList<>();
            playlist.add(new Playlist("Semua Lagu", "anyone"));
            while(rs.next()){
                Playlist p = new Playlist();

                //System.out.println(rs.getString(2)); //here you can get data, the '1' indicates column number based on your query
                p.setId(rs.getString(1));
                p.setPlaylistTitle(rs.getString(2));
                p.setCreatorName(rs.getString(3));
                playlist.add(p);
            }

            return playlist;
        }catch(Exception e){
            System.out.println("Error in getData"+e);
        }
        
        return null;
    }
    
    public void addSongToPlaylist(String songId, String playlistId){
        connect();
        try{
            //String table = " playlist p join relasi_song_playlist r on (p.id = r.playlistId) join song s on (r.songId = s.id) ";
            String query = "INSERT INTO relasi_song_playlist(songId, playlistId) VALUES ('" + songId+ 
                    "','" + playlistId +
                    "')";
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Song> readAllSongs(){
        connect();
        try{
            String query = "SELECT * FROM song";
            
            rs = stmt.executeQuery(query);
            ArrayList<Song> songs = new ArrayList<>();
            while(rs.next()){
                
                Song s = new Song();
                s.setId(rs.getString(1));
                s.setArtist(rs.getString(3));
                s.setTitle(rs.getString(4));
                s.setAlbum(rs.getString(5));
                s.setPath(rs.getString(6));
                songs.add(s);
            }

            return songs;
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ArrayList<Song> readSongsFromPlaylist(String playlistName){
        connect();
        ArrayList<Song> ls = new ArrayList<Song>();
        
        if (playlistName.equals("Semua Lagu")){
            
            try{
                String query = "SELECT * FROM song";

                rs = stmt.executeQuery(query);
                while(rs.next()){
                    Song song = new Song(rs.getString(4), rs.getString(3), rs.getString(5), rs.getString(6));
                    ls.add(song);
                }

                return ls;
            }catch(Exception e){
                System.out.println("Error in getData"+e);
            }
            
        }
        
        try{
            String table = " playlist p join relasi_song_playlist r on (p.id = r.playlistId) join song s on (r.songId = s.id) ";

            String query = "SELECT * FROM" + table +  "WHERE p.nama = '" + playlistName + "'";
            
            rs = stmt.executeQuery(query);
            while(rs.next()){
                //System.out.println(rs.getString(2)); //here you can get data, the '1' indicates column number based on your query
                Song song = new Song(rs.getString(9), rs.getString(8), rs.getString(10), rs.getString(11));
                ls.add(song);
            }

            return ls;
        }catch(Exception e){
            System.out.println("Error in getData"+e);
        }
        
        return null;
    }
}
