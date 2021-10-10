package algoSec;

import java.math.BigInteger;

/**
 * Given int[] array 'numbers[]' of any length pick the best three number (num1, num2, mum3) from 'numbers[]'
 * So if num1*num2*num3 >= any other three number in the array or MaxProduct of three numbers in 'numbers[]'
 * i.e.: numbers[] = [3, -5, -1, 0, -7, 2, 3, -2, 1]
 * result => 3*(-7)*(-5) => 105
*/

public class MaxProductOfThree {

    public static BigInteger getMaxProductOfThree(int[] numbers){
        if(numbers == null || numbers.length<3)
            return BigInteger.valueOf(0);

        //posA>=posB>=posC
        int posA = 0, posB = 0, posC = 0;
        //negA<= negB
        int negA = 0, negB = 0;

        boolean hasPositive = false;
        boolean hasZero = false;
        for(int num : numbers){
            if(num == 0){
                hasZero = true;
                continue;
            }
            if(num < 0){
                int temp = 0;
                if(num < negA){
                    temp = negA;
                    negA = num;
                    negB = temp;
                }else if(num < negB){
                    negB = num;
                }
            }else{
                hasPositive = true;
                int temp = 0;
                int temp2 = 0;
                if(num > posA){
                    temp = posA;
                    posA = num;
                    temp2 = posB;
                    posB = temp;
                    posC = temp2;
                }else if(num > posB){
                    temp = posB;
                    posB = num;
                    posC = temp;
                }else if(num > posC){
                    posC = num;
                }
            }
        }
        // special case if no positive value
        if(!hasPositive){
            //if all negatives with zero
            if (hasZero)
                return BigInteger.valueOf(0);
            //if all negatives only
            else{
                return getMaxProductOfThree(numbers, true);
            }
        }
        BigInteger result1 = BigInteger.valueOf(posA)
                                        .multiply(BigInteger.valueOf(posB))
                                        .multiply(BigInteger.valueOf(posC));
        BigInteger result2 = BigInteger.valueOf(posA)
                                        .multiply(BigInteger.valueOf(negA))
                                        .multiply(BigInteger.valueOf(negB));
        return result1.compareTo(result2) >= 0 ? result1 : result2;
    }
    private static BigInteger getMaxProductOfThree(int[] arr, boolean allNegatives){
        //posA>=posB>=posC
        int negA = Integer.MIN_VALUE, negB = Integer.MIN_VALUE, negC = Integer.MIN_VALUE;
        for(int num : arr){
            int temp = 0;
            int temp2 = 0;
            if(num > negA){
                temp = negA;
                negA = num;
                temp2 = negB;
                negB = temp;
                negC = temp2;
            }else if(num > negB){
                temp = negB;
                negB = num;
                negC = temp;
            }else if(num > negC){
                negC = num;
            }
        }
        return BigInteger.valueOf(negA)
                .multiply(BigInteger.valueOf(negB))
                .multiply(BigInteger.valueOf(negC));
    }

    public static void main(String[] args) {
        int[] test1Array = {3, -5, -1, 0, -7, 2, 3, -2, 1};
        System.out.println(getMaxProductOfThree(test1Array)); //3*-7*-5=>105
        int[] test2Array = {-3, -5, -1, 0, -7, -2, -3, -2, -1};
        System.out.println(getMaxProductOfThree(test2Array)); //0*(any neg value)=> 0
        int[] test3Array = {-7, -2, -3, -3, -5, -1, -2, -1};
        System.out.println(getMaxProductOfThree(test3Array)); //-1*-1*-2 => -2
        int[] test4Array = {700_000_000, 90_000_000, 500_000_000, 1_000_000_000, 20_000, 300_000_000, 600_000_000};
        System.out.println(getMaxProductOfThree(test4Array)); //700000000*600000000*1000000000 => 42 * 10^25
    }
}
