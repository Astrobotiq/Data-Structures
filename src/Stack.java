import java.util.EmptyStackException;

public class Stack {
    private int size;
    private int[] nums;
    private int top;

    public Stack(int initialSize){
        this.size=0;
        nums = new int[initialSize];
        top=-1;
    }
    public void resize(){
        int newSize = nums.length*2;
        int[] newArray = new int[newSize];
        for (int a:nums) {
            newArray[a] = nums[a];
        }
        nums = newArray;
    }

    public void push(int data){
        if (isFull())
            resize();
        nums[++top] = data;
        size++;
    }

    public boolean isFull(){
        return size == nums.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int pop(){
        if (!isEmpty()){
            int removedData = peek();
            top--;
            size--;
            return removedData;
        }
        throw new EmptyStackException();
    }

    public int peek(){
        if (!isEmpty()){
            return nums[top];
        }
        throw new EmptyStackException();
    }
}
