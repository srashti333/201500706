package Sorting;
import java.util.Scanner;


public class InsertionSort
{
    static void insertionSort(int arr[])
    {
        for (int i=1; i<arr.length; ++i)
        {
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
    public static void print(int arr[])
    {
        for(int j=0;j< arr.length;j++)
        {
            System.out.print(arr[j]+ " ");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("enter array size");
        int arr[] = new int[sc.nextInt()];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = sc.nextInt();
        }
        insertionSort(arr);
        print(arr);
    }
}

