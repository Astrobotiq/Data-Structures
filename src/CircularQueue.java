import java.util.EmptyStackException;

public class CircularQueue {
    private int front,rear;
    private int[] nums;

    public CircularQueue(int size){
        front=rear=-1;
        nums = new int[size];
    }

    public void enqueue(int data){
        if (isFull())
            resize();
        if (isEmpty())
            front++;
        rear = (rear+1)% nums.length;
        nums[rear]=data;
    }

    public int dequeue(){
        if (isEmpty())
            throw new EmptyStackException();
        int temp=nums[front];
        if (rear==front)
            rear=front=-1;
        else {
            front = (front+1)%nums.length;
        }
        return temp;
    }

    public int peek(){
        return nums[rear];
    }

    public boolean isEmpty(){
        return rear==-1;
    }

    public boolean isFull(){
        return (rear+1)% nums.length==front;
    }

    public void resize(){
        int[] tempArr = new int[nums.length*2];
        int i = 0;
        int j = front;

        do {
            tempArr[i++]=nums[j];
            j=(front+1)% nums.length;
        }while (front != j);

        front=0;
        rear=(tempArr.length-1);
        nums=tempArr;
    }
}
