import java.util.EmptyStackException;
public class StackwLinkedList {
    Node top;
    int size;

    public StackwLinkedList(){
        top = null;
        size=0;
    }
    public void push(int data){
        if (isEmpty()){
            top = new Node(data);
            size++;}
        else {
            Node curr = new Node(data);
            curr.next = top;
            top = curr;
            size++;
        }
    }

    public int peek(){
        if (!isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int pop(){
        if (!isEmpty()){
            int removedData = top.data;
            top = top.next;
            size--;
            return removedData;
        }
        throw new EmptyStackException();
    }
}
