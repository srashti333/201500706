package Tree;

import java.util.Arrays;

public class ConvertBTtoBST {
    public Node3 root;

    int[] treeArray;
    int index = 0;

    public ConvertBTtoBST(){
        root = null;
    }

    //convertBTBST() will convert a binary tree to binary search tree
    public Node3 convertBTBST(Node3 node) {

        //Variable treeSize will hold size of tree
        int treeSize = calculateSize(node);
        treeArray = new int[treeSize];

        //Converts binary tree to array
        convertBTtoArray(node);

        //Sort treeArray
        Arrays.sort(treeArray);

        //Converts array to binary search tree
        Node3 d = createBST(0, treeArray.length -1);
        return d;
    }

    //calculateSize() will calculate size of tree
    public int calculateSize(Node3 node)
    {
        int size = 0;
        if (node == null)
            return 0;
        else {
            size = calculateSize (node.left) + calculateSize (node.right) + 1;
            return size;
        }
    }

    //convertBTtoArray() will convert the given binary tree to its corresponding array representation
    public void convertBTtoArray(Node3 node) {
        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        else {
            if(node.left != null)
                convertBTtoArray(node.left);
            //Adds nodes of binary tree to treeArray
            treeArray[index] = node.data;
            index++;
            if(node.right != null)
                convertBTtoArray(node.right);
        }
    }

    //createBST() will convert array to binary search tree
    public Node3 createBST(int start, int end) {

        //It will avoid overflow
        if (start > end) {
            return null;
        }

        //Variable will store middle element of array and make it root of binary search tree
        int mid = (start + end) / 2;
        Node3 node = new Node3(treeArray[mid]);

        //Construct left subtree
        node.left = createBST(start, mid - 1);

        //Construct right subtree
        node.right = createBST(mid + 1, end);

        return node;
    }

    //inorder() will perform inorder traversal on binary search tree
    public void inorderTraversal(Node3 root) {

        //Check whether tree is empty
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        else {

            if(root.left!= null)
                inorderTraversal(root.left);
            System.out.print(root.data + " ");
            if(root.right!= null)
                inorderTraversal(root.right);

        }
    }

    public static void main(String[] args) {

        ConvertBTtoBST bt = new ConvertBTtoBST();
        bt.root = new Node3(1);
        bt.root.left = new Node3(2);
        bt.root.right = new Node3(3);
        bt.root.left.left = new Node3(4);
        bt.root.left.right = new Node3(5);
        bt.root.right.left = new Node3(6);
        bt.root.right.right = new Node3(7);
        System.out.println("Inorder representation of binary tree: ");
        bt.inorderTraversal(bt.root);
        Node3 bst = bt.convertBTBST(bt.root);
        System.out.println("\nInorder representation of resulting binary search tree: ");
        bt.inorderTraversal(bst);
    }
}
