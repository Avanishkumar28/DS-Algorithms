package javamagazine;

import java.util.Arrays;

public class ArrayCopy {

    public static void main(String[] args) {
        String[][] src = {{"A"},{"B", "C"},{"D", "E", "F"}};
        System.out.println(src);
        String[][] dest = Arrays.copyOf(src, 3); // line n1
        System.out.println(dest);
        System.out.println(Arrays.deepToString(src));
        System.out.println(Arrays.deepToString(dest));
        src[2][2]= "X"; // line n2
        System.out.print(src[2].equals(dest[2]));
    }
}
