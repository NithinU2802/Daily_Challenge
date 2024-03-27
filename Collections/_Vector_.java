import java.util.*;

class _Vector_.java {

	public static void main(String[] args)
	{
		Vector<Integer> v = new Vector<Integer>();
	
		v.add(7);
		v.add(50);
		v.add(0);
		v.add(67);
		v.add(98);
	
		System.out.println(Collections.max(v));
		System.out.println(Collections.min(v));
	}
}
