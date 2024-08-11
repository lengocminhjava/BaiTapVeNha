package baitapcolection.bai3;
import java.time.Duration;
import java.util.*;

public class Song {
private int id;
private String title;
private String artist;
private int duration;
private Set<Song> songs = new HashSet<>();
    public Song() {
    }
    public Song(int id, String title, String artist, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                '}';
    }
    public Set<Song> addObj(Song obj) {
        for (Song song : songs) {
            if (song.getId() == obj.getId() || Objects.equals(song.getTitle(), obj.getTitle())) {
               return songs;
            }
        }
        songs.add(obj);
        return songs;
    }
    public Set<Song> displaySong(){
        Set<Song> listSong = new HashSet<>();
        for(Song song:songs){
            listSong.add(song);
        }
        return listSong;
    }

}

