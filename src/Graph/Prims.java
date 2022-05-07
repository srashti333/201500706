package Graph;

import java.util.Scanner;

public class Prims
{
    public static void prims(int matrix[][])
    {
        int n=matrix.length;
        int parent[]=new int[n];
        boolean vis[]=new boolean[n];
        int weight[]=new int[n];

        parent[0]=-1;
        weight[0]=0;
        for(int i=n;i<n;i++)
        {
            weight[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            int minvertex=findMinimum(vis,weight);
            vis[minvertex]=true;
            for (int j = 0; j <n ; j++) {
                if(matrix[minvertex][j] !=0 && !vis[j])
                {
                    if(weight[j]>matrix[minvertex][j])
                    {
                        weight[j]= matrix[minvertex][j];
                        parent[j]= minvertex;
                    }
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            if(i<parent[i])
            {
                System.out.println(i+ "   "+parent[i]+ "   "+ weight[i]);
            }
            else
                System.out.println(parent[i]+ "   "+ i + "   " + weight[i]);
        }
    }

    private static int findMinimum(boolean[] vis, int[] weight) {
        int minvertex=-1;
        for(int i=0;i<vis.length;i++)
        {
            if(!vis[i] && (minvertex==-1 || weight[i]<weight[minvertex]))
            {
                minvertex=i;
            }
        }
        return minvertex;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of vertex & no. of edges");
        int n=sc.nextInt();
        int e=sc.nextInt();
        int matrix[][]=new int[n][n];
        for(int i=0;i<e;i++)
        {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            matrix[v1][v2]=weight;
            matrix[v2][v1]=weight;
        }

        prims(matrix);
    }
}
