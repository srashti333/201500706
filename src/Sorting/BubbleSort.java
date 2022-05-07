package Sorting;

import java.util.Scanner;

public class BubbleSort
{
    public static void bubbleSort(int arr[])
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j< arr.length-i-1;j++)
            {
                if(arr[j+1]<arr[j])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void print(int arr[])
    {
        for(int j=0;j< arr.length;j++)
        {
            System.out.print(arr[j]+ " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.printf("enter array size");
        int arr[]=new int[sc.nextInt()];
        for(int j=0;j< arr.length;j++)
        {
            arr[j]=sc.nextInt();
        }
        bubbleSort(arr);
        print(arr);
    }

}
/*sum of series, sum of even & odd, packed and unpacked*/