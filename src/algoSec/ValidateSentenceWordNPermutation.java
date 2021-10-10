package algoSec;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given A file of words (Dictionary)
 * Validate an input sentence if its word or permutation are present in the Dictionary
 *
 * Consider all charterer in the word and word in the sentence are in lower case and a-z only
*/

public class ValidateSentenceWordNPermutation {

    public static boolean validateSentence(String sentence, Set<List<Integer>> wordBank){
        if(wordBank == null || sentence == null)
            return false;

        String[] words = sentence.split("\\s+");
        for (String word : words){
            List<Integer> wCount = wordToCharCount(word.toLowerCase());
            if (!wordBank.contains(wCount))
                return false;
        }
        return true;
    }

    private static Set<List<Integer>> processWordSet(Set<String> wordSet) {
        if (wordSet == null)
            return new HashSet<>();
        Set<List<Integer>> processedWords = new HashSet<>();
        for (String word : wordSet){
            List<Integer> charCountArray = wordToCharCount(word.toLowerCase());
            if (charCountArray != null)
                processedWords.add(charCountArray);
        }
        return processedWords;
    }
    private static List<Integer> wordToCharCount(String word){
        if (word == null)
            return null;
        if (word == null || "".equals(word))
            return new ArrayList<>(26);
        int[] charCountArray = new int[26];
        for (char c : word.toCharArray()){
            charCountArray[c - 'a'] += 1;
        }
        return Arrays.stream(charCountArray).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Set<String> wordSet = FileProcessor.readFile("src/algoSec/word_bank.txt");
        Set<List<Integer>> processedWords = processWordSet(wordSet);

        String test1Sentence = "I have a dog";
        System.out.println("Sentence <"+test1Sentence+"> is valid: "
                + validateSentence(test1Sentence,processedWords));
        String test2Sentence = "I have a Hours";
        System.out.println("Sentence <"+test2Sentence+"> is valid: "
                + validateSentence(test2Sentence,processedWords));
        String test3Sentence = "Great si dog";
        System.out.println("Sentence <"+test3Sentence+"> is valid: "
                + validateSentence(test3Sentence,processedWords));
    }


}
