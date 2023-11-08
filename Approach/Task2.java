import java.util.*;

public class Task2 {
    public static void main(String[] arg) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int odd = 1, even = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j + 1 >= n) {
                    if (i % 2 == 0) {
                        System.out.print(odd + " ");
                        odd += 2;
                    } else {
                        System.out.print(even + " ");
                        even += 2;
                    }
                } else
                    System.out.print("  ");
            }
            System.out.println();
        }

    }
}
