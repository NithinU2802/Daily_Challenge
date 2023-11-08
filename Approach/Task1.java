import java.util.*;

class Task1 {
    public static void main(String[] arg) {
        Scanner x = new Scanner(System.in);
        String[] s = x.nextLine().split(" ");
        int[] a = new int[s.length];

        for (int i = 0; i < s.length; i++)
            a[i] = Integer.parseInt(s[i]);

        int c = 1;
        for (int i = 0; i < a.length-1; i++) {
            if ( (i<a.length-1 && a[i] < a[i + 1]) || (i==a.length-1 && a[i]==a[i-1])) {
                if (c > 1)
                    System.out.print(a[i] + "->" + c + " ");
                c = 1;
            } else
                c++;
        }

    }
}