public class TreeNode {

    static final int COUNT = 10;

    NodeOfTree root;

    public TreeNode(int data){
        root = new NodeOfTree(data);
    }



    public NodeOfTree findMin(NodeOfTree x){
        if(x.left !=null){
            return findMin(x.left);
        }
        return x;
    }

    public NodeOfTree findMax(NodeOfTree x){
        if(x.left != null){
            return findMax(x.right);
        }
        return x;
    }

    public void insert(int data,NodeOfTree x){
        if (data<x.data){
            if (x.left != null){
                insert(data,x.left);
            }
            else {
                x.left = new NodeOfTree(data);
            }
        }
        else if (data>x.data){
            if (x.right != null){
                insert(data,x.right);
            }
            else {
                x.right = new NodeOfTree(data);
            }
        }
    }

    public NodeOfTree search(int element,NodeOfTree x){
        if (element==x.data){
            return x;
        }
        else if (element<x.data){
            if (x.left != null){
                return search(element,x.left);
            }
            else{
                return null;}
        }
        else {
            if (x.right != null){
                return search(element,x.right);
            }
            else{
                return null;}
        }
    }

    public int minValue(NodeOfTree root){
        while(root.left!=null){
            minValue(root.left);
        }
        return root.data;
    }

    public NodeOfTree delete(int element,NodeOfTree x){
        if (x == null)
            return null;
        if (element<x.data){
            x.left= delete(element,x.left);
        }
        else if (element>x.data){
            x.right= delete(element,x.right);
        }
        else if (x.left != null && x.right!=null){
            x.data = minValue(x.right);
            x.right= delete(x.data,x.right);
        }
        else{
            x = (x.left != null) ? x.left : x.right;
        }
        return x;
    }

    public int findDepth(NodeOfTree x){
        if (x==null){
            return 0;
        }
        int leftDept=0,rightDepth = 0;
        if (x.left!=null){
            leftDept =findDepth(x.left);
        }
        else if (x.right!=null){
            rightDepth =findDepth(x.right);
        }
        int max = (leftDept>rightDepth)?leftDept:rightDepth;

        return (max+1);
    }

    static void preorder(NodeOfTree x){
        System.out.println(x.data);
        if (x.left!=null)
            preorder(x.left);
        if (x.right!=null)
            preorder(x.right);
    }

    static void inorder(NodeOfTree x){

        if (x.left!=null)
            inorder(x.left);
        System.out.println(x.data);
        if (x.right!=null)
            inorder(x.right);
    }

    static void postorder(NodeOfTree x){
        if (x.left!=null)
            postorder(x.left);
        if (x.right!=null)
            postorder(x.right);
        System.out.println(x.data);
    }


    static void print2DUtil(NodeOfTree root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(NodeOfTree root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
