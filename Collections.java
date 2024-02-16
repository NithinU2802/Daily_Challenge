/******************************************************************************

    Training with Collections

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    
	// HashSet 
	Set<Integer> set=new HashSet<Integer>();
	set.add(-1);
	set.add(-2);
	System.out.println(set);

	ArrayList<String> list = new ArrayList<>(set);
	System.out.println(list);
	    
	// ArrayList
	List<Integer> s=new ArrayList<Integer>();
	s.add(9);
	s.add(10);
	s.add(1,1);
	s.addAll(set);
	s.addAll(1,set);
	System.out.println("ArrayList: "+s);
	ArrayList<Integer> d = (ArrayList<Integer>) ((ArrayList<Integer>) s).clone();
	s.clear();
	s=(ArrayList<Integer>)d.clone();
	System.out.println("Clear List: "+s);
	List<Object> a=new ArrayList<Object>();
	a.add(9);
	a.add(10);
	a.add(1,1);
	a.addAll(set);
	a.add("Nithin");
	a.remove(10);
	System.out.println("contains: "+s.contains(a));
	Object[] an=s.toArray();
	System.out.println(an.length);
	System.out.println("List: "+a);


	//Stack
	Stack<Integer> stack=new Stack<>();
	stack.push(4);
	stack.push(5);
	System.out.println(stack.poll());
	System.out.println(stack.peeek());

	// Queue
	Queue<Integer> queue=new LinkedList<Integer>();
	queue.add(20);
	queue.add(30);
	System.out.println(queue.remove());
	System.out.println(queue.peek());
		
	// Linked List
	LinkedList<Integer> linkedlist=new LinkedList<Integer>();
	linkedlist.add(89);
	linkedlist.add(8);
	linkedlist.add(192);
	linkedlist.add(849);
	System.out.println(linkedlist.poll());
	linkedlist.push(6);
	linkedlist.add(9);
	System.out.println(linkedlist.peek());
	System.out.println(linkedlist);


	// Pair
	Pair x = new Pair(3, 4); 
	Pair y = new Pair(3, 4); 
	System.out.println(p1.equals(p2));


	// HashMap
	Map<Integer,Integer> map=new HashMap<>();
	map.put(9,4);
	map.put(6,7);
	map.put(4,6);
	System.out.println("The set is: " + map.keySet()); 

		
	}
}
