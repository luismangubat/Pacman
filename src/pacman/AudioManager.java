/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import audio.Playlist;
import audio.SoundManager;
import audio.Source;
import static audio.Source.RESOURCE;
import audio.Track;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class AudioManager {

    private SoundManager sm;
    private ArrayList<Track> music = new ArrayList<>();

    public static String BGMUSIC = "BGMUSIC";

    {
        music.add(new Track(BGMUSIC, Source.RESOURCE, "/pacman/Static2.wav"));
        
        sm = new SoundManager (new Playlist(music));
    }

    public void playAudio(String name, boolean loop) {
        if (loop) sm.play(name, Integer.MAX_VALUE);
        else sm.play(name);
    }
    public void stopAudio(String name) {
        sm.stop(name);
    }
    
}
