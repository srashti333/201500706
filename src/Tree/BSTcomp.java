package Tree;

public class BSTcomp
{
    class node
    {
        int key;
        node left,right;
        public node(int item)
        {
            key = item;
            left=right=null;
        }
    }
    node root;
    BSTcomp()
    {
        root=null;
    }
    void deletekey(int key)
    {
        root = deleterec(root,key);
    }
    node deleterec(node root, int key)
    {
        if(root==null)
            return root;
        if(key<root.key)
            root.left = deleterec(root.left,key);
        else if(key>root.key)
            root.right = deleterec(root.right,key);
        else
        {
            if(root.left==null)
                return root.right;
            else if(root.right==null)
                return root.left;
            root.key = minvalue(root.right);
            root.right = deleterec(root.right,root.key);
        }
        return root;
    }
    int minvalue(node root)
    {
        int minv = root.key;
        while(root.left!=null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    // insertion
    void insert(int key)
    {
        root = insertrec(root,key);
    }
    node insertrec(node root, int key)
    {
        if(root==null){
            root = new node(key);
            return root;
        }
        if(key<root.key)
            root.left = insertrec(root.left,key);
        else if(key>root.key)
            root.right = insertrec(root.right,key);
        return root;
    }
    // traversing
    // inorder
    void inorder()
    {
        inorderrec(root);
    }
    void inorderrec(node root)
    {
        if(root!=null)
        {
            inorderrec(root.left);
            System.out.println(root.key);
            inorderrec(root.right);
        }
    }
    void preorder()
    {
        preorderrec(root);
    }
    void preorderrec(node root) {
        if(root!=null)
        {
            System.out.println(root.key);
            preorderrec(root.left);
            preorderrec(root.right);
        }

    }
    void postorder()
    {
        postorderrec(root);
    }
    void postorderrec(node root)
    {
        if(root!=null)
        {
            postorderrec(root.left);
            postorderrec(root.right);
            System.out.println(root.key);
        }

    }

    public static void main(String[] args) {
        BSTcomp tree = new BSTcomp();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("inorder traversal of the given tree");
        tree.inorder();
        System.out.println("preorder traversal of the given tree");
        tree.preorder();
        System.out.println("postorder traversal of the given tree");
        tree.postorder();
        System.out.println("\n delete 20");
        tree.deletekey(20);
        System.out.println("inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("\n deletekey 30");
        tree.deletekey(30);
        System.out.println("inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("\n deletekey ");
        tree.deletekey(50);
        System.out.println("inorder traversal of the modified tree");
        tree.inorder();
    }
}

