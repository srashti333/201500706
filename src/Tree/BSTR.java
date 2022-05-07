package Tree;

import java.util.Scanner;

public class BSTR
{
    static Node2 root;
    public static Node2 insertIntoBST(Node2 root, int data)
    {
        Node2 newnode=new Node2(data);
        if(root==null)
        {root=newnode;
        }
        else if(data<root.data)
        {
            root.left= insertIntoBST(root.left,data);
        }
        else if(data>root.data)
        {
            root.right=insertIntoBST(root.right,data);
        }
        return root;
    }
    public void deleteNode(int n)
    {
        delete(root,n);
    }
    public Node2 delete(Node2 root, int n) {
        if(root == null) {
            return null;
        }
        if(n > root.data) {
            root.right = delete(root.right,n);
        }else if(n < root.data) {
            root.left = delete(root.left,n);
        }else {
            if(root.right == null) {

                return root.left;
            }else if(root.left == null) {
                return root.right;
            }
            root.data = minValue(root.right);

            root.right = delete(root.right,root.data);

        }



        return root;

    }
    private static int minValue(Node2 root) {

        int minVal = root.data;
        while(root.left != null) {
            minVal= root.left.data;
            root = root.left;
        }
        return minVal;
    }
    public void search(int k)
    {
        searchNode(root,k);
    }
    public static boolean searchNode(Node2 root, int k){
        if(root == null) {
            return false;
        }

        int rootData = root.data;
        if(k<rootData) {
            return searchNode(root.left,k);
        }else if(k>rootData) {
            return searchNode(root.right,k);
        }else {
            return true;
        }
    }

    public void preorder()
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
    public void postorder()
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

    public void inorder()
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


    public void print(Node2 root) {
        if(root == null) {
            return;
        }
        String toPrint = root.data +" ";
        if(root.left != null) {
            toPrint += "L: " + root.left.data +" ";

        }
        if(root.right!= null) {
            toPrint += "R: " + root.right.data + " ";
        }
        System.out.println(toPrint);

        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BSTR obj=new BSTR();
        char ch='y';
        Node2 root=null;
        System.out.println("""
                              press <1> for insertion.
                              press <2> for inorder.
                              press <3> for preorder.
                              press <4> for postorder.
                              press <5> for searching.
                              press <6> for deleting
                              press<7> for printing.
                              """);

        while(ch=='y'||ch=='Y') {
            int n = sc.nextInt();
            switch (n) {
                case 1:

                    root=obj.insertIntoBST(root,sc.nextInt());
                    obj.inorder1(root);
                    break;
                case 2:
                    obj.inorder();
                    break;
                case 3:
                    obj.preorder();
                    break;
                case 4:
                    obj.postorder();
                    break;
                case 5:
                    obj.search(sc.nextInt());
                    break;
                case 6:
                    obj.deleteNode(sc.nextInt());
                    break;
                case 7:
                    obj.print(root);
                    break;
                default:
                    System.out.println("enter valid value");
            }
            System.out.println("\nenter y/n");
            ch = sc.next().charAt(0);
        }

    }
}
