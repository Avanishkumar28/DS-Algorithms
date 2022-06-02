package amazon;

import java.util.List;

/**
 * Given stack of plate's weights for workout.
 * Arrange this stack so light weighted plate go on top of the stack
 * and heaviest will go bottom of stack.
        return min number of swap needed to do so.
 * i.e. input = [2,3,4,1], output = 3
    1st swap 4,1 => [2,3,1,4]
    2nd swap 3,1 => [2,1,3,4]
    3rd swap 2,1 => [1,2,3,4]
 * heaviest already at the bottom of stack
 * so out put will be: 3
 *
 * i.e. input = [2,4,7,5,3,9], output = 0
 * No swap needed as the lightest plate at top and heaviest plate already in the bottom
*/

public class GoodWeightEquipment {

    public static int minSwap(List<Integer> plates){
        return 0;
    }
}
