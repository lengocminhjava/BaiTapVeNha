package baitapcolection.bai3;

import java.awt.*;
import java.time.Duration;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Song songs = new Song();
        Song obj1 =new Song(1,"cơn mưa tình yêu","hà anh tuấn",4);
        Song obj2 = new Song(2,"cơn mưa ngang qua","Sơn Tùng",3);
        Song obj5 = new Song(5,"Mây","Jank",2);
        Song obj3 = new Song(3,"cơn mưa tình yêu","hà anh tuấn",4);
        Song obj4 = new Song(4,"cơn mưa tình yêu","hà anh tuấn",4);
        songs.addObj(obj1);
        songs.addObj(obj2);
        songs.addObj(obj3);
        songs.addObj(obj4);
        songs.addObj(obj5);
       Set<Song> listSong = new HashSet<>();
        listSong = songs.displaySong();
        for(Song song:listSong){
            System.out.println(song);
        }
        // Tìm kiếm theo tên
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên muốn tìm kiếm");
        String title = sc.nextLine();
        System.out.println("Bài hát sau khi tìm kiếm");
        searchForTitle(listSong,title);
        //Hiển thị bài hát của 1 nhạc sĩ cho trước
        System.out.println("Nhập tên nhạc sĩ");
        String artist = sc.nextLine();
        System.out.println("Bài hát là");
        boolean isNs = false;
        for(Song song:listSong){
            if(song.getArtist().toLowerCase().contains(artist)){
                System.out.println(song);
                isNs=true;
            }
        }
        if(!isNs){
            System.out.println("Không có nhạc sĩ nào");
        }
        // Sắp xếp bài hát theo duration
        List<Integer> listDur = new ArrayList<>();
         for(Song song:listSong){
             listDur.add(song.getDuration());
         }
         Collections.sort(listDur);
      Map<Integer,Integer> sortDur = new HashMap<>();
         for(Song song:listSong){
             sortDur.put(song.getDuration(),song.getId());
         }
        System.out.println("Sau khi sắp xếp theo duration");
       for(int dur:listDur){
           searchForId(listSong,sortDur.get(dur));
       }

        System.out.println("Nhập id muốn xóa");
       int id = sc.nextInt();
       removeId(listSong,id);
        System.out.println("Sau khi xóa");
        for (Song song:listSong){
            System.out.println(song);
        }

    }
    public static void searchForTitle(Set<Song> songs ,String title){
        boolean isNs = false;
        for(Song song:songs){
            if(song.getTitle().toLowerCase().contains(title)){
                System.out.println(song);
                isNs=true;
            }
        }
        if(!isNs){
            System.out.println("Không có tên tìm kiếm");
        }
    }
    public static void searchForId(Set<Song> songs ,int id){
        boolean isNs = false;
        for(Song song:songs){
            if(id == song.getId()){
                System.out.println(song);
                isNs=true;
            }
        }
        if(!isNs){
            System.out.println("Không có id tìm kiếm");
        }
    }
    public static void removeId(Set<Song> songs ,int id){
        boolean isNs = false;
        List<Song> songForid = new ArrayList<>();
        for(Song song:songs){
            if(id == song.getId()){
                songForid.add(song);
                isNs=true;
            }
        }
        songs.removeAll(songForid);
        if(!isNs){
            System.out.println("Không có id tìm kiếm");
        }
    }

}
