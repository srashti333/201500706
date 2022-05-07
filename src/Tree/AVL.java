package Tree;

class Node2
{
    int data;
    Node2 left;
    Node2 right;
    int height;
    int balance;
    public Node2(int data)
    {
        this.data = data;
    }
}
public class AVL {

    public static Node2 rightrotation(Node2 A)
    {
        Node2 B = A.left;
        Node2 Bright = B.right;
        B.right = A;
        A.left = Bright;
        updateheightandbalance(A);
        updateheightandbalance(B);
        return B;
    }
    public static Node2 leftrotation(Node2 A)
    {
        Node2 B = A.right;
        Node2 Bleft = B.left;
        B.left = A;
        A.right = Bleft;
        updateheightandbalance(A);
        updateheightandbalance(B);
        return B;
    }
    public static Node2 getrotation(Node2 node)
    {
        updateheightandbalance(node);
        if(node.balance ==2 )
        {
            if(node.left.balance == 1)
            {
                return rightrotation(node);
            }
            else
            {
                node.left = leftrotation(node.left);
                return rightrotation(node);
            }
        }
        else if (node.balance== -2)
        {
            if(node.right.balance==-1)
            {
                return leftrotation(node);
            }
            else
            {
                node.right = rightrotation(node.right);
                return leftrotation(node);
            }
        }
        return node;
    }
    public static void updateheightandbalance(Node2 troot)
    {
        int lh = -1;
        int rh = -1;
        if (troot.left != null)
            lh = troot.left.height;
        if(troot.right !=null)
            rh = troot.right.height;
        troot.balance =lh-rh;
        troot.height = Math.max(lh,rh)+1;
    }
    public static void display(Node2 node)
    {
        if(node== null)
        {
            return;
        }
        String str ="";
        str += node.left!= null?node.left.data+" " : ".";
        str+="< -"+ node.data+"->";
        str+=  node.right!= null?node.right.data+" " : ".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static Node2 insert(Node2 root, Node2 newnode) {
        if (root == null) {
            root = newnode;
            return root;
        } else if (newnode.data < root.data) {
            if (root.left == null) {
                root.left = newnode;
            } else {
                root.left=insert(root.left, newnode);

            }
        } else if (newnode.data > root.data) {
            if (root.right == null) {
                root.right = newnode;
            } else {
                root.right= insert(root.right, newnode);

            }
        }
        root= getrotation(root);
        return root;
    }
    public static void main(String[] args) {
        Node2 n1 = new Node2(30);

        Node2 n2 = new Node2(20);

        Node2 n3 = new Node2(10);

        insert(null, n1);
        Node2 root = insert(n1, n2);
        root = insert(root,new Node2(25));
        root= insert(root, n3);
        root = insert(root,new Node2(11));
        root= insert(root,new Node2(5));
        System.out.println("display data");
        display(root);

    }
}