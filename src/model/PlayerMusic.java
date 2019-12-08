package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import javax.swing.JFrame;
import model.SongList;
import model.Song;
import view.ArtistFrame;
import view.AudienceFrame;

/**
 *
 * @author ASUS
 */
public class PlayerMusic<E> {
    private boolean shuffle;
    private boolean repeat;
    private SongList songL;
    private Song currentPlaying;
    private int a = 0;
    javazoom.jl.player.Player player;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public javazoom.jl.player.Player getPlayer() {
        return player;
    }

    public void setPlayer(javazoom.jl.player.Player player) {
        this.player = player;
    }
    
    

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public SongList getSongL() {
        return songL;
    }

    public void setSongL(SongList songL) {
        this.songL = songL;
    }

    public Song getCurrentPlaying() {
        return currentPlaying;
    }

    public void setCurrentPlaying(Song currentPlaying) {
        this.currentPlaying = currentPlaying;
    }

    
    
    
    public void play(E frame){
        
        if (frame instanceof ArtistFrame){
        
            ArtistFrame f = (ArtistFrame) frame;
            
            if ( f.getPlayerMusic().getA() == 0 ){
                try{
                    int i = f.getList_song_album().getSelectedIndex();
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    f.getPlayerMusic().setPlayer(new javazoom.jl.player.Player(bis));
                    f.getPlayerMusic().setA(1);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            f.getPlayerMusic().getPlayer().play();

                        }catch (Exception e){
                    
                        }
                    }
                   
                }.start();
                
            }else{
                f.getPlayerMusic().getPlayer().close();
                f.getPlayerMusic().setA(0);
                f.getPlayerMusic().play(f);
            }
        } else if (frame instanceof AudienceFrame){
            
            AudienceFrame f = (AudienceFrame) frame;
            
            if ( f.getPlayerMusic().getA() == 0 ){
                try{
                    int i = f.getList_song_playlist().getSelectedIndex();
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    f.getPlayerMusic().setPlayer(new javazoom.jl.player.Player(bis));
                    f.getPlayerMusic().setA(1);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            f.getPlayerMusic().getPlayer().play();

                        }catch (Exception e){
                    
                        }
                    }
                   
                }.start();
                
            }else{
                f.getPlayerMusic().getPlayer().close();
                f.getPlayerMusic().setA(0);
                f.getPlayerMusic().play(f);
            }
            
        }
    }
    
    private int getRandomNumberInRange(int min, int max) {

	if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
    
    public void pause(E frame){
        if (frame instanceof ArtistFrame){
        
            ArtistFrame f = (ArtistFrame) frame;
            if (f.getPlayerMusic().getA() != 0){
                f.getPlayerMusic().getPlayer().close();
                f.getPlayerMusic().setA(0);
            }
        } else if (frame instanceof AudienceFrame){
        
            AudienceFrame f = (AudienceFrame) frame;
            if (f.getPlayerMusic().getA() != 0){
                f.getPlayerMusic().getPlayer().close();
                f.getPlayerMusic().setA(0);
            }
        }
    }
    
    public void next(E frame){
        if (frame instanceof ArtistFrame){
        
            ArtistFrame f = (ArtistFrame) frame;
            
            if( a == 0 ){
                try{
                    int i = f.getList_song_album().getSelectedIndex() + 1;
                    if (f.getPlayerMusic().isShuffle()){
                        i = getRandomNumberInRange(0, f.getList_song_album().getModel().getSize()-1);
                    }
                    
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new javazoom.jl.player.Player(bis);
                    a =1;
                    f.getList_song_album().setSelectedIndex(i);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            player.play();

                        }catch (Exception e){
                        }
                    }
                }.start();
            }else{
                player.close();
                a=0;
                f.getPlayerMusic().next(f);
            }
        } else if (frame instanceof AudienceFrame){
        
            AudienceFrame f = (AudienceFrame) frame;
            
            if( a == 0 ){
                try{
                    int i = f.getList_song_playlist().getSelectedIndex() + 1;
                    if (f.getPlayerMusic().isShuffle()){
                        i = getRandomNumberInRange(0, f.getList_song_playlist().getModel().getSize()-1);
                    }
                    
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new javazoom.jl.player.Player(bis);
                    a =1;
                    f.getList_song_playlist().setSelectedIndex(i);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            player.play();

                        }catch (Exception e){
                        }
                    }
                }.start();
            }else{
                player.close();
                a=0;
                f.getPlayerMusic().next(f);
            }
        }

    }
    
    public void prev(E frame){
        if (frame instanceof ArtistFrame){
        
            ArtistFrame f = (ArtistFrame) frame;
            
            if( a == 0 ){
                try{
                    int i = f.getList_song_album().getSelectedIndex() - 1;
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new javazoom.jl.player.Player(bis);
                    a =1;
                    f.getList_song_album().setSelectedIndex(i);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            player.play();

                        }catch (Exception e){
                        }
                    }
                }.start();
            }else{
                player.close();
                a=0;
                f.getPlayerMusic().prev(f);
            }
        } else if (frame instanceof AudienceFrame){
        
            AudienceFrame f = (AudienceFrame) frame;
            
            if( a == 0 ){
                try{
                    int i = f.getList_song_playlist().getSelectedIndex() - 1;
                    f.setTv_judul_lagu(((Song)f.getFileList().get(i)).getTitle());
                    File file = new File( ((Song)f.getFileList().get(i)).getPath());
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    player = new javazoom.jl.player.Player(bis);
                    a =1;
                    f.getList_song_playlist().setSelectedIndex(i);
                }catch(Exception e){
                    System.out.println("Problem playing file");
                    System.out.println(e);
                }

                new Thread(){
                    @Override
                    public void run(){
                        try{
                            player.play();

                        }catch (Exception e){
                        }
                    }
                }.start();
            }else{
                player.close();
                a=0;
                f.getPlayerMusic().prev(f);
            }
        }

    }
   

    public PlayerMusic() {
    }
    
    
}
