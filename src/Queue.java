import java.util.EmptyStackException;

public class Queue {
    private int front,rear;
    private int[] nums;

    public Queue(int size){
        nums = new int[size];
        front=rear=-1;
    }

    public void enqueue(int data){
        if (isFull())
            resize();
        if (isEmpty())
            front++;
        nums[++rear]=data;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        if (front==rear)
            front=rear=-1;
        int temp = nums[rear];
        front++;
        return temp;
    }

    public int peek(){
        return nums[rear];
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return rear == nums.length;
    }

    public void resize(){
        int newSize = nums.length*2;
        int[] newArray = new int[newSize];
        for (int a:nums) {
            newArray[a] = nums[a];
        }
        nums = newArray;
    }
}
