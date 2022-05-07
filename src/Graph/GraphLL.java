package Graph;

import java.util.*;

public class GraphLL
{
    HashMap<Integer, LinkedList<Integer>> obj;
    GraphLL()
    {
        obj=new HashMap<>();
    }
    public void addedge(int source,int dest,boolean isbidirectional)
    {
        LinkedList<Integer> l=obj.getOrDefault(source,new LinkedList<>());
        l.add(dest);
        obj.put(source,l);
        if(isbidirectional)
        {
            LinkedList l1=obj.getOrDefault(dest,new LinkedList<>());
            l1.add(source);
            obj.put(dest,l1);
        }
    }
    public void bfs(int source)
    {
        Queue<Integer> bfs=new LinkedList<>();
        bfs.add(source);
        Set<Integer> vis=new HashSet<>();
        vis.add(source);
        while(!bfs.isEmpty())
        {
            int  front=bfs.poll();
            System.out.print(front+" ");
            LinkedList<Integer> neighbourList=obj.get(front);
            for(int i:neighbourList)
            {
                if(!vis.contains(i))
                {
                    bfs.add(i);
                    vis.add(i);
                }
            }
        }
    }

    public void ssppbfs(int source)
    {
        Queue<Integer> bfs=new LinkedList<>();
        bfs.add(source);
        Map<Integer,Integer> dis=new HashMap<>();
        for(int vertex:obj.keySet())
        {
            dis.put(vertex,Integer.MAX_VALUE);
        }
        dis.put(source,0);
        while(!bfs.isEmpty())
        {
            int front=bfs.poll();
            LinkedList<Integer> neighbourList=obj.get(front);
            for(int i:neighbourList)
            {
                if(dis.get(i)==Integer.MAX_VALUE)
                {
                    bfs.add(i);
                    int distance=dis.get(front)+1;
                    dis.put(i,distance);
                    System.out.println("Distance of "+i+"from source "+source+"is= "+ distance);
                }
            }
        }
    }
    public void dfs(int source)
    {
        Set<Integer> vis=new HashSet<>();
        dfsHelper(source,vis);
    }
    public void dfsHelper(int source,Set<Integer> vis)
    {
        System.out.println(source);
        vis.add(source);
        LinkedList<Integer> neighbourlist=new LinkedList<>();
        for(int i:neighbourlist)
        {
            dfsHelper(i,vis);
        }
    }

    public static void main(String[] args) {
        GraphLL gra=new GraphLL();
        Scanner sc=new Scanner(System.in);
        char ch='y';
        System.out.println("""
                              press <1> for addedge.
                              press <2> for bfs.
                              press <3> for dfs.
                              press <4> for ssspbfs.\n
                              """);

        while(ch=='y'||ch=='Y')
        {
            int n=sc.nextInt();
            switch(n)
            {
                case 1:
                    gra.addedge(sc.nextInt(),sc.nextInt(),sc.nextBoolean());
                    gra.bfs(sc.nextInt());
                    break;
                case 2:
                    gra.bfs(sc.nextInt());
                    break;
                case 3:
                    gra.dfs(sc.nextInt());
                    break;
                case 4:
                    gra.ssppbfs(sc.nextInt());
                default:
                    System.out.println("enter valid value");
            }
            System.out.println("\nenter y/n");
            ch=sc.next().charAt(0);
        }
    }

}
