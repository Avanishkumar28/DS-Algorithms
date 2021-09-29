package algo.sort;

import java.util.Arrays;

public class QuickSort {

    public static int[] quickSort(int[] array){
        quickSort(array, 0, array.length-1);
        return array;
    }
    private static void quickSort(int[] array, int left, int right){
        if(left >= right)
            return;
        int pivot = array[(left+right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index-1);
        quickSort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right){
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        int[] test1Array1 = {15,3,9,8,5,2,7,1,6};
        System.out.println("Before sorted: "+ Arrays.toString(test1Array1));
        System.out.println("After sorted: "+ Arrays.toString(quickSort(test1Array1)));

        int[] test2Array1 = {1,3,4,9,8,5,10,7,1,6};
        System.out.println("Before sorted: "+ Arrays.toString(test2Array1));
        System.out.println("After sorted: "+ Arrays.toString(quickSort(test2Array1)));
    }
}
