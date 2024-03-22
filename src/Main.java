import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GraphWithLinkedList topological = new GraphWithLinkedList();
        NodeofGraph node40 =new NodeofGraph(40);
        NodeofGraph node10 =new NodeofGraph(10);
        NodeofGraph node20 =new NodeofGraph(20);
        NodeofGraph node30 =new NodeofGraph(30);
        NodeofGraph node60 =new NodeofGraph(60);
        NodeofGraph node50 =new NodeofGraph(50);
        NodeofGraph node70 =new NodeofGraph(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);

        System.out.println("Topological Sorting Order:");
        topological.topologicalSort(node40);

        topological.print();


    }


    static void quickSort(int[]arr,int minIndex,int maxIndex){
        if (minIndex>=maxIndex)
            return;
        int pivot = arr[maxIndex];

        int lPointer = minIndex;
        int rPointer = maxIndex;

        while (lPointer<rPointer){

            while (arr[lPointer]<=pivot&&lPointer<rPointer){
                lPointer++;
            }

            while (arr[rPointer]>=pivot && lPointer<rPointer){
                rPointer--;
            }

            swap(arr,lPointer,rPointer);
        }

        swap(arr,lPointer,maxIndex);
        quickSort(arr,minIndex,lPointer-1);
        quickSort(arr,lPointer+1,maxIndex);

    }

    static void swap(int[]arr,int minIndex,int maxIndex){
        int temp = arr[minIndex];
        arr[minIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    static void mergeSort(int[]arr){
        int arrSize = arr.length;
        if (arrSize<2)
            return;
        int leftSize = arrSize/2;
        int[]leftArr = new int[leftSize];
        int[]rightArr = new int[arr.length-leftSize];

        for (int i=0; i<leftSize;i++){
            leftArr[i] = arr[i];
        }

        for (int i=leftSize;i<arr.length;i++){
            rightArr[i-leftSize] = arr[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr,leftArr,rightArr);
    }

    static void merge(int[]parentArr,int[]leftArr,int[]rightArr){
        int parentSize= parentArr.length;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        int i=0,j=0,k=0;

        while(i<leftSize && j<rightSize){
            if (leftArr[i]<rightArr[j]){
                parentArr[k]=leftArr[i];
                i++;
            }
            else {
                parentArr[k]=rightArr[j];
                j++;
            }
            k++;
        }

        while (i<leftSize){
            parentArr[k]=leftArr[i];
            i++;
            k++;
        }

        while (j<rightSize){
            parentArr[k]=rightArr[j];
            j++;
            k++;
        }
    }
}