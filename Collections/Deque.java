import java.util.*;

public class Deque
{
	public static void main(String[] args) {
		ArrayDeque<Integer> q= new ArrayDeque<Integer>(10);
 
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q);

        q.clear();
 
        q.addFirst(4);
        q.addFirst(5);
        q.addLast(6);
        q.addLast(7);
        System.out.println(q);
	}
}
