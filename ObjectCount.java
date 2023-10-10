import java.io.*;
import java.util.*;

class Student{
    static int student=0;
     void add(){
         student++;
     }
     void print(){
         System.out.println(student+" ");
     }
}

class Rockstar{
    static int rockstar=0;
     void add(){
         rockstar++;
     }
     void print(){
         System.out.println(rockstar+" ");
     }
}

class Hacker{
    static int hacker=0;
     void add(){
         hacker++;
     }
     void print(){
         System.out.println(hacker+" ");
     }
}

public class M {

    public static void main(String[] args) {
    Scanner x=new Scanner(System.in);
    int n=x.nextInt();
    x.nextLine();
    String[] a=new String[n];
    Student student=new Student();
    Rockstar rockstar=new Rockstar();
    Hacker hacker=new Hacker();
    for(int i=0;i<n;i++){
        a[i]=x.nextLine();
        if(a[i].equals("Student"))
            student.add();
        else if(a[i].equals("Hacker"))
            hacker.add();
        else if(a[i].equals("Rockstar"))
            rockstar.add();
    }
    student.print();
    rockstar.print();
    hacker.print();
    }
}
