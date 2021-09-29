package cisco;

import java.util.Arrays;

public class ShiftLeft {

    public static int[] shiftLeft(int arr[], int num){
        int[] tempArr = new int[arr.length];
        int tempIndex = num % tempArr.length;
        for (int index = 0; index < arr.length; index++){
            if(tempIndex >= tempArr.length)
                tempIndex = 0;
            tempArr[tempIndex] = arr[index];
            tempIndex++;
        }
        return tempArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(shiftLeft(arr, 21)));
        System.out.println(Arrays.toString(shiftLeft(arr, 2)));
        System.out.println(Arrays.toString(shiftLeft(arr, 4)));
        System.out.println(Arrays.toString(shiftLeft(arr, 87)));
    }
}
