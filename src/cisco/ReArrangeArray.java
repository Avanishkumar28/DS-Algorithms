package cisco;

import java.util.Arrays;

public class ReArrangeArray {

    public static void reArrange(int[] arr1, int[] arr2){
        int index1 = 0, index2 = 0;
        int[] tempArray = new int[arr1.length+arr2.length];
        int counter = 0;
        while (index1<arr1.length && index2<arr2.length){
            if (arr1[index1] < arr2[index2]){
                tempArray[counter] = arr1[index1];
                index1++;
            }else{
                tempArray[counter] = arr2[index2];
                index2++;
            }
            counter ++;
        }
        if(index1 < arr1.length){
            while (index1 < arr1.length){
                tempArray[counter] = arr1[index1];
                index1++;
                counter++;
            }
        }
        if(index2 < arr2.length){
            while (index2 < arr2.length){
                tempArray[counter] = arr2[index2];
                index2++;
                counter++;
            }
        }
        index1 = 0;
        index2 = 0;
        for (int n : tempArray){
            if(index1 < arr1.length){
                arr1[index1] = n;
                index1++;
            }else{
                arr2[index2] = n;
                index2++;
            }
        }

    }

    public static void main(String[] args) {
        int[] test1Arr1 = {3,5,7};
        int[] test1Arr2 = {2,4};
        reArrange(test1Arr1, test1Arr2);
        System.out.println("test1Arr1: "+Arrays.toString(test1Arr1));
        System.out.println("test1Arr2: "+Arrays.toString(test1Arr2));

        int[] test2Arr1 = {1,3,4,5,7};
        int[] test2Arr2 = {2,4};
        reArrange(test2Arr1, test2Arr2);
        System.out.println("test2Arr1: "+Arrays.toString(test2Arr1));
        System.out.println("test2Arr2: "+Arrays.toString(test2Arr2));
    }
}
