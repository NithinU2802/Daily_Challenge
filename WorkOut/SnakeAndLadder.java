import java.util.*;

class Player{
    
    int current=0,ladder=0,slider=0;
    String name;
    Player(String name){
        current=0;
        ladder=0;
        this.name=name;
    }
    
    void changeName(String name){
        this.name=name;
    }
    
    void changeCurrent(int current){
        this.current=current;
    }
    
    void sliderCount(){
        slider++;
    }
    
    void ladderCount(){
        ladder++;
    } 
}

public class SnakeAndLadder
{
	public static void main(String[] args) {
	Scanner x=new Scanner(System.in);
	HashMap<String, Player> board=new HashMap<String,Player>();
	HashMap<Integer,Integer> slider=new HashMap<Integer,Integer>();
	HashMap<Integer,Integer> ladder=new HashMap<Integer,Integer>();
	
	slider.put(13,2);
	slider.put(29,20);
	slider.put(25,14);
	
	ladder.put(4,9);
	ladder.put(7,19);
	ladder.put(8,28);
	ladder.put(15,26);
	
	int n=x.nextInt();
	x.nextLine();
	String[] s=new String[n];
	Player player;
	for(int i=0;i<n;i++){
	    s[i]=x.nextLine();
	    player=new Player(s[i]);
	    board.put(s[i],player);
	}
	String current=x.nextLine();
	int index=0;
	for(int i=0;i<n;i++){
	    if(current.equals(s[i])){
	        index=i;
	        break;
	    }
	}
	
	   // player=board.get(s[0]);
	   // System.out.println("First: "+player.name);
	   // for(int j=0;j<n;j++){
	   //     Player player1=board.get(s[j]);
	   //     player1.changeName("Nithin");
	   // }
	   // System.out.println("First: "+player.name);
	int m=x.nextInt();
	for(int i=0;i<m;i++){
	    int point=x.nextInt();
	    player=board.get(s[index]);
	    int d=player.current+point;
	    System.out.println("Point: "+d);
	    if(d==30){
	        player.changeCurrent(30);
	        break;
	    }
	    if(player.current==0 && point!=1){
	        index++;
	        if(index==n)
	            index=0;
	        continue;
	    }
	    if(player.current==0 && point==1){ 
	        for(int j=0;j<n;j++){
	            Player temp=board.get(s[j]);
	            if(temp.current==d){
	                temp.changeCurrent(0);
	                break;
	            }
	        }
	        if(ladder.containsKey(1))
	            player.changeCurrent(1+ladder.get(1));
	        else
	            player.current=1;
	    }else if(player.current+point>30){
	        index++;
	        if(index==n)
	            index=0;
	        continue;
	    }else{
	        int p=player.current+point;
	        while(slider.containsKey(p) || ladder.containsKey(p)){
	        if(slider.containsKey(p)){
	            player.changeCurrent(slider.get(p));
	            p=slider.get(p);
	            player.sliderCount();
	        }
	        if(ladder.containsKey(p)){
	            player.changeCurrent(ladder.get(p));
	            player.ladderCount();
	            p=ladder.get(p);
	        }
	        }
	    }
	    index++;
	    if(index==n)
	        index=0;
	}
	for(int i=0;i<n;i++){
	    player=board.get(s[i]);
	    System.out.println(player.name+" | "+player.current+" | "+(30-player.current)+" | "+player.ladder+" | "+player.slider);
	}
	}
}
