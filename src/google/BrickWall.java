package google;

import java.util.*;

/**
 * https://www.careercup.com/question?id=67814
 * */

public class BrickWall {

    public static int brickWall(int wight, int height, int[] bricks){
        if (wight == 0 || height == 0)
            return 0;
        List<List<Integer>> possibleCombinations =  findCombination(wight, bricks);
        possibleCombinations.stream()
                .forEach(System.out::println);
        int combinationCount = possibleCombinations.size();

        return 0;
    }
    private static List<List<Integer>> findCombination(int wight, int[] bricks){
        if (wight == 0)
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        List<List<Integer>> allPossibleCombinations  = new ArrayList<>();
        for (int brick : bricks){
            if ((wight-brick) >= 0){
                List<List<Integer>> possibleCombinations  = findCombination(wight-brick, bricks);
                List<List<Integer>> combinationList = new ArrayList<>();
                for (List<Integer> combinations : possibleCombinations){
                    List<Integer> tempCombination = new ArrayList<>();
                    tempCombination.add(brick);
                    tempCombination.addAll(combinations);
                    combinationList.add(tempCombination);
                }
                for (List<Integer> combinations : combinationList) {
                    allPossibleCombinations.add(combinations);
                }
            }
        }
        //System.out.println(allPossibleCombinations);
        return allPossibleCombinations;
    }
    private static List<Integer> countConflict(List<List<Integer>> possibleCombinations, int layers, int wight){
        // precompute internal brick positions for easy comparison
        /*Set<Integer>[] internalPosition = new Set<>[];
        for (int index = 0; index < possibleCombinations.size(); index++){
            internalPosition[index] = getInternalPositions(possibleCombinations.get(index), wight);
        }*/

        for (int i = 0; i <= layers; i++){

        }
        return null;
    }
    private static Set<Integer> getInternalPositions(List<Integer>  layer, int wight){
        Set<Integer> internalPosition = new HashSet<>();
        int acc = 0;
        for (int brick : layer){
            acc += brick;
            internalPosition.add(acc);
        }
        internalPosition.remove(wight);
        return internalPosition;
    }

    public static void main(String[] args) {
        int[] bricks = {2,3};
        brickWall(9, 3, bricks);
    }
}
