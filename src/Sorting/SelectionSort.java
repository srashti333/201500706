package Sorting;

import java.util.Scanner;

public class SelectionSort
{
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min= j;
                }
            }
            int temp= arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void print(int arr[])
    {
        for(int j=0;j< arr.length;j++)
        {
            System.out.print(arr[j]+ " ");
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.printf("enter array size");
        int arr[]=new int[sc.nextInt()];
        for(int j=0;j< arr.length;j++)
        {
            arr[j]=sc.nextInt();
        }
        selectionSort(arr);
        print(arr);

    }
}
