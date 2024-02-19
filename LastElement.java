import java.util.*;

class LastElement {
    public static void main(String[] args) {
        Scanner x=new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n=x.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
            a[i]=x.nextInt();

        for (int i : a)
            queue.offer(i);
        int k = x.nextInt();
        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            queue.poll();
        }
        while (!queue.isEmpty())
            System.out.print(queue.poll()+" ");
    }
}

