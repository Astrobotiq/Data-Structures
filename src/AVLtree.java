public class AVLtree {
    NodeOfAVL root;


    NodeOfAVL insert(int data,NodeOfAVL x){
        if (x==null)
            return new NodeOfAVL(data);
        if (data<x.data){
            x.left = insert(data,x.left);
        }
        else if (data>x.data){
            x.right = insert(data,x.right);
        }
        else
            return x;

        x.h = 1+max(height(x.left),height(x.right));

        int balance = getBalanceFactor(x);

        if (balance>1 && data<x.left.data){ //  LL
            return rightRotate(x);
        }
        if (balance<-1 && data>x.right.data){ //  RR
            return leftRotate(x);
        }
        if (balance>1 && data>x.left.data){ //  lR
            x.left = leftRotate(x.left);
            return rightRotate(x);
        }
        if (balance<-1 && data<x.right.data){//  RL
            x.right = rightRotate(x.right);
            return leftRotate(x);
        }
        return x;
    }

    public int getBalanceFactor(NodeOfAVL N){
        if (N==null)
            return 0;
        return (height(N.left)-height(N.right));
    }

    public int height(NodeOfAVL N){
        if(N==null)
            return 0;
        else
            return N.h;
    }

    int max(int a,int b){
        return (a>b)?a:b;
    }

    NodeOfAVL leftRotate(NodeOfAVL a){
        NodeOfAVL b = a.right;
        NodeOfAVL c = b.left;
        b.left = a;
        a.right = c;
        a.h = max(height(a.left),height(a.right))+1;
        b.h = max(height(b.left),height(b.right))+1;

        return b;
    }

    NodeOfAVL rightRotate(NodeOfAVL b){
        NodeOfAVL a = b.left;
        NodeOfAVL c = a.right;
        a.right = b;
        b.left = c;
        b.h = max(height(b.left),height(b.right))+1;
        a.h = max(height(a.left),height(a.right))+1;

        return a;

    }


    void preOrder(NodeOfAVL node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
