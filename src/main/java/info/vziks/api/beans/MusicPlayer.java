package info.vziks.api.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MusicPlayer
 * Project appcontext
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class MusicPlayer {

    private List<Music> playList = new ArrayList<>();
    private Music music;


    private int volume;
    private String name;


    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer() {
    }

    public String playSong() {
        return this.music.play();
    }

    public info.vziks.api.beans.MusicPlayer setMusic(Music music) {
        this.music = music;
        return this;
    }

    public void setMusicList(List<Music> musicList) {
        this.playList = musicList;
    }


    public void playMusicList() {
        for(Music music : playList) {
            System.out.println("Playing: " + music.play());
        }
    }

    public int getVolume() {
        return volume;
    }

    public info.vziks.api.beans.MusicPlayer setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "playList=" + playList +
                ", music=" + music +
                ", volume=" + volume +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
