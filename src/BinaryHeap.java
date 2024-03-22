public class BinaryHeap {
    public int[] heap;
    private int size;
    BinaryHeap(int capacity){
        heap = new int[capacity];
        size = 0;
    }
    BinaryHeap(int[]arr){
        size = arr.length;
        heap = heapify(arr);
    }

    private boolean isFull(){
        return size == heap.length;
    }

    private boolean isValidIndex(int index){
        return index >= 0 && index < size;
    }

    private void siftUp(int childIndex,int[] arr){
        int parentIndex = getParentIndex(childIndex);

        while(isValidIndex(parentIndex)&& arr[parentIndex]>arr[childIndex]){
            swapValues(childIndex,parentIndex,arr);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    private void siftDown(int parent, int[] arr){
        int leftChildIndex = getLeftChild(parent);
        boolean isLeftValid = isValidIndex(leftChildIndex);

        while (isLeftValid){
            int smallerChild = leftChildIndex;
            int rightChildIndex = getRightChild(parent);
            boolean isRightValid = isValidIndex(rightChildIndex);

            if (isRightValid && arr[rightChildIndex]<arr[leftChildIndex]){
                smallerChild = rightChildIndex;
            }
            if (arr[smallerChild]<arr[parent]){
                swapValues(smallerChild,parent,arr);
                parent = smallerChild;
                leftChildIndex = getLeftChild(parent);
                isLeftValid = isValidIndex(leftChildIndex);
            }
            else break;
        }
    }

    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private void swapValues(int child,int parent,int[]arr){
        int temp = arr[child];
        arr[child]= arr[parent];
        arr[parent]=temp;
    }

    public void insert(int value){
        if (isFull())
            resizeHeap();
        heap[size]=value;
        siftUp(size,heap);
        size+=1;
    }

    private void resizeHeap(){
        int[] newHeap = new int[size*2];
        for (int i:heap) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    private int getLeftChild(int parent){
        return (2*parent)+1;
    }

    private int getRightChild(int parent){
        return (2*parent)+2;
    }

    private boolean isEmpty(){
        return size==0;
    }

    public void deleteMin(){
        if (!isEmpty()){
            swapValues(0,size-1,heap);
            size-=1;
            siftDown(0,heap);
        }
    }

    public int[] heapify(int[]arr){
        int startIndex = getParentIndex(size-1);
        if (isValidIndex(startIndex)){
            for (int j = startIndex;j>=0;j--){
                siftDown(j,arr);
            }
        }
        return arr;
    }

    public int[] heapify(int[]arr,int startIndex){
        if (isValidIndex(startIndex)){
            for (int j = startIndex;j>=0;j--){
                siftDown(j,arr);
            }
        }
        return arr;
    }

    public void heapSort(int[] arr){
        int elementSize = arr.length;
        while (elementSize>0){
            int temp = arr[elementSize-1];
            arr[elementSize-1] = arr[0];
            arr[0] =temp;
            elementSize-=1;
            heapify(arr,elementSize);
        }

    }
}
