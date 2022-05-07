package Tree;

import java.util.Scanner;

public class BinartTreeArray {
    int[] arr;
    static int lastusedindex;

    public BinartTreeArray(int size) {
        arr = new int[size+1];
        this.lastusedindex = 0;
    }
    public void insert(int val)
    {
        if(arr.length-1 == lastusedindex)
        {
            System.out.println("Array is full");
        }
        else
        {
            arr[lastusedindex+1]= val;
            lastusedindex++;
        }
    }
    public void traversepreorder(int index)
    {
        if(index>lastusedindex)
        {
            return;
        }
        else {
            System.out.print(arr[index] + "  ");
            traversepreorder(index * 2);
            traversepreorder(index * 2 + 1);
        }
    }
    public void traverse(int index)
    {
        if(index>lastusedindex)
        {
            return;
        }
        else {
            traverse(index * 2);
            System.out.print(arr[index] + "   ");
            traverse(index * 2 + 1);
        }
    }
    public int search(int value)
    {
        int j=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==value)
            {
                j=i;
                return i;
            }
        }
        return  j;
    }
    public void delete(int val)
    {
        int index=search(val);
        if(index==-1)
        {
            return;
        }
        arr[index]=arr[lastusedindex];
        arr[lastusedindex]=-1;
        lastusedindex--;
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        BinartTreeArray obj=new BinartTreeArray(q);
        char ch='y';
        System.out.println("""
                              press <1> for insertion.
                              press <2> for traversalpreorder.
                              press <3> for traversal.
                              press <4> for search.
                              press <5> for delete. \n
                              """);

        while(ch=='y'||ch=='Y')
        {
            int n=sc.nextInt();
            switch(n)
            {
                case 1:
                    for(int o=0;o<q;o++)
                    {
                        obj.insert(sc.nextInt());
                    }
                    System.out.println("enter index");
                    obj.traverse(sc.nextInt());
                    break;
                case 2:
                    System.out.println("enter index");
                    obj.traversepreorder(sc.nextInt());
                    break;
                case 3:
                    System.out.println("enter index");
                    obj.traverse(sc.nextInt());
                    break;
                case 4:
                    System.out.println("enter value");
                    System.out.println(obj.search(sc.nextInt()));
                    break;
                case 5:
                    System.out.println("enter value");
                    obj.delete(sc.nextInt());
                    obj.traverse(1);
                    break;
                default:
                    System.out.println("enter valid value");
            }
            System.out.println("\nenter y/n");
            ch=sc.next().charAt(0);
        }
    }


}
