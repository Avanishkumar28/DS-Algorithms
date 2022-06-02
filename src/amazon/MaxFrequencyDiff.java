package amazon;

/**
 * Given string (all lower chars) identify substring which contains max difference of the character's frequency.
 *
 * i.e. input= "abccca", output=2
 *  all sub-strings
 *  "a" max diff of frequency frcy(a)-frcy(a) => 1-1 = 0
 *  "b" max diff of frequency frcy(b)-frcy(b) => 1-1 = 0
 *  "c" max diff of frequency frcy(a)-frcy(a) => 1-1 = 0
 *  "ab" max diff of frequency frcy(a)-frcy(b) => 1-1 = 0
 *  .
 *  .
 *  .
 *  "bccc" max diff of frequency frcy(c)-frcy(b) => 3-1 = 2
 *  "ccca" max diff of frequency frcy(a)-frcy(a) => 3-1 = 2
 *
 *  Here only two sub-string "bccc" and "ccca" having max frequency diff that is 2
 *  so out put will be 2
**/

public class MaxFrequencyDiff {

}
