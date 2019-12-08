package model;

import java.io.File;
import javax.swing.JFrame;
import model.Song;


public interface SongListModifier {
    public Song addSong(JFrame frame);
    public void removeSong(Song s);
}
