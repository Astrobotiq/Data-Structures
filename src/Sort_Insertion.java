public class Sort_Insertion {


    //Insertion Function that I take from slides
    static void insertionSort(int[] arr){
        int t;

        for (int i=1;i<arr.length;i++ ){
            int temp = arr[i];
            for (t=i ; t>=0 && temp<arr[t-1];t--){
                arr[t] = arr[t-1];
            }
            arr[t] = temp;
        }

    }
}
