/******************************************************************************

    Pattern printing within given frame as a Compiler

*******************************************************************************/
import java.util.*;

public class CompilerWidth{
    
    public static String[] solution(String text, int width) {
        List<String> res = new ArrayList<>();
        String s="";
        for(int i=0;i<width;i++)
            s+='*';
        res.add(s);
        String[] list=text.split("(?<=[.!?])\\s+");

        for (String i : list) {
            StringBuilder t = new StringBuilder("  ");
            String[] words = i.trim().split("\\s+");

            for (String word : words) {
                if (t.length() + word.length() + 1 <= width)
                    t.append(word).append(" ");
                else {
                    String m=t.toString();
                    m='*'+m;
                    while(m.length()<width-1)
                        m+=' ';
                    m+='*';
                    res.add(m);
                    t = new StringBuilder( word+" "); 
                }
            }
            String m=t.toString();
            m='*'+m;
            while(m.length()<width-1)
                m+=' ';
            m+='*';
            res.add(m);

        }
        res.add(s);
        return res.toArray(new String[0]);
    }
    
	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		String s = "Hi! This is the article you have to format properly. Could you do that for me, please?";
        int w = 16;
		for(String i:solution(s,w))
		    System.out.println(i);
	}
}
