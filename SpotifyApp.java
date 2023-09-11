/******************************************************************************

    Write a Java program to create a class called "Spotify" with a collection 
of songs and methods to add and remove songs, and to play a random song.

*******************************************************************************/
import java.util.*;

class Song{
    private String title;
    private String artist;
    
    Song(String title,String artist){
        this.title=title;
        this.artist=artist;
    }
    
    String getTitle(){
        return title;
    }
    
    String getArtist(){
        return artist;
    }
    
    void setTitle(String title){
        this.title=title;
    }
    
    void setArtist(String artist){
        this.artist=artist;
    }
    
}

class Spotify{
    
    private List<Song> songs;
    
    Spotify(){
        songs=new ArrayList<>();    
    }
    
    public void addSong(Song s){
        songs.add(s);
    }
    
    public void removeSong(Song s){
        songs.remove(s);
    }
    
    public Song playSong(){ 
        
        int n=songs.size();
        
        if(n==0){
            System.out.println("No songs");
            return null;
        }
        
        Random ran=new Random();
        int s=ran.nextInt(n);
        System.out.println("Now Playing: ");
        System.out.println("Title: "+songs.get(s).getTitle());
        System.out.println("Artist: "+songs.get(s).getArtist());
        return songs.get(s);
    }
}

public class SpotifyApp
{
	public static void main(String[] args) {
	Spotify spotify =new Spotify();
	Scanner x=new Scanner(System.in);
	int n=x.nextInt();
	for(int i=0;i<n;i++){
	    System.out.println("Song Name: ");
	    String songName=x.next();
	    System.out.println("Song Artist: ");
	    String songArtist=x.next();
	    spotify.addSong(new Song(songName,songArtist));
	}
	int choice=-1;
	Song currentSong=null;
	do{
	    currentSong=spotify.playSong();
	    try{
	    System.out.println("Change Song Enter '1' : ");
	    n=x.nextInt();
	    
	    if(choice==1)
	        spotify.playSong();
	    else{
	        System.out.println("Enter Valid Input...!");
	        System.out.println("Currently..");
	        if(currentSong==null){
	            System.out.println("No Song is Available...!");
	            break;
	        }
	        System.out.println("Title: "+currentSong.getTitle());
            System.out.println("Artist: "+currentSong.getArtist());
	    }
	    }catch(Exception e){
	        System.out.println("Enter a Digit please...!");
	        choice=1;
	        continue;
	    }
	}while(choice!=0);
	}
}
