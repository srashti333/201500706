package Tree;

import java.util.ArrayList;
import java.util.Scanner;

class Node
{
    int data;
    Node3 left;
    Node3 right;
    public Node(int data)
    {
        this.data=data;
    }

}
public class BinarySearchTree
{
    static Node2 root;

    Node2 current=root;
    Node2 p;
    public static void insert(int x)
    {
        Node2 newnode=new Node2(x);
        newnode.data=x;
        if(root==null)
        {
            root=newnode;
            return;
        }
        else{
            Node2 current=root;
            Node2 parent=null;
            while(true)
            {
                parent=current;
                if(x< parent.data)
                {
                    current=current.left;
                    if(current==null)
                    {
                        parent.left=newnode;
                        return;
                    }
                }
                else
                {
                    current=current.right;
                    if(current==null)
                    {
                        parent.right=newnode;
                        return;
                    }
                }
            }

        }
    }

    public static void preorder()
    {
        preorder1(root);
    }

    public static void preorder1(Node2 root)
    {
        if(root==null)
            return;
        preorder1(root.left);
        System.out.print(root.data+" ");
        preorder1(root.right);
    }
    public static void postorder()
    {
        postorder1(root);
    }

    public static void postorder1(Node2 root)
    {
        if(root==null)
            return;
        postorder1(root.left);
        System.out.print(root.data+" ");
        postorder1(root.right);
    }

    public static void inorder()
    {
        inorder1(root);
    }
    public static void inorder1(Node2 root)
    {
        if(root==null)
            return;
        inorder1(root.left);
        System.out.print(root.data+" ");
        inorder1(root.right);
    }

    public static Node2 search(int x)
    {
        Node2 current =root;
        while(current.data!=x)
        {
            if(current.data>x)
            {
                current=current.left;
            }
            else
            {
                current=current.right;
            }
            if(current==null)
                return null;
        }
        return current;
    }

    public static ArrayList path(Node2 root, int val)
    {
        if(root == null)
        {
            return null;
        }
        if(root.data == val)
        {
            ArrayList output = new ArrayList();
            output.add(root.data);
            return output;
        }
        else if(val<root.data)
        {
            ArrayList left= path(root.left,val);
            if(left != null) {
                left.add(root.data);
            }
            return left;
        }
        else
        {
            ArrayList right = path(root.right, val);
            if(right != null){
                right.add(root.data);
            }
            return right;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        char ch='y';
        System.out.println("""
                              press <1> for insertion.
                              press <2> for traversal.
                              press <3> for searching.\n
                              """);

        while(ch=='y'||ch=='Y')
        {
            int n=sc.nextInt();
            switch(n)
            {
                case 1:
                    insert(sc.nextInt());
                    inorder();
                    break;
                case 2:
                    inorder();
                    break;
                case 3:
                    search(sc.nextInt());
                    break;
                default:
                    System.out.println("enter valid value");
            }
            System.out.println("\nenter y/n");
            ch=sc.next().charAt(0);
        }
    }

}

