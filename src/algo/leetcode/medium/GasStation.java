package algo.leetcode.medium;

/**
134. Gas Station
        There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

        You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next
        (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

        Given two integer arrays gas and cost,
        return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
        otherwise return -1. If there exists a solution, it is guaranteed to be unique
Constraints:

        gas.length == n
        cost.length == n
        1 <= n <= 104
        0 <= gas[i], cost[i] <= 104
Example 1:

        Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        Output: 3
        Explanation:
        Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
        Travel to station 4. Your tank = 4 - 1 + 5 = 8
        Travel to station 0. Your tank = 8 - 2 + 1 = 7
        Travel to station 1. Your tank = 7 - 3 + 2 = 6
        Travel to station 2. Your tank = 6 - 4 + 3 = 5
        Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
        Therefore, return 3 as the starting index.
**/


public class GasStation {

    /**
     * n --> num of city to visite
    * Time --> O(n)
    * Space --> O(1)
    **/
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0)
            return -1;
        int fuelNeededNextCity = 0, start = 0, balanceFuel = 0;
        for(int i = 0; i < gas.length; i++){
            balanceFuel += gas[i] - cost[i];
            if(balanceFuel < 0){
                start = i+1;
                fuelNeededNextCity += balanceFuel;
                balanceFuel = 0;
            }
        }
        return (balanceFuel + fuelNeededNextCity) >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] test1Gas = new int[]{1,2,3,4,5};
        int[] test1Cost = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(test1Gas, test1Cost)); //3

        int[] test2Gas = new int[]{6,7,4,10,6,5};
        int[] test2Cost = new int[]{5,6,7,8,6,4};
        System.out.println(canCompleteCircuit(test2Gas, test2Cost));//3

        int[] test3Gas = new int[]{5,5,4,10,6,5};
        int[] test3Cost = new int[]{5,6,7,8,6,4};
        System.out.println(canCompleteCircuit(test3Gas, test3Cost));//-1
    }
}
