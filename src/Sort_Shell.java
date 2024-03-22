public class Sort_Shell {
    static void shellSort(int[] arr){


        for (int gap = arr.length/2;gap>0;gap=gap/2){
            for (int i=0 ; i+gap< arr.length;i++){
                int tmp = arr[i];
                if ( arr[i]>arr[i+gap] ){
                    arr[i]=arr[i+gap];
                    arr[i+gap]= tmp;
                }
            }
        }


    }
}
