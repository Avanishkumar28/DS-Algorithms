import java.util.Objects;

public class HashForChar {

    public static void main(String[] args) {
        for(char c = 'a'; c <= 'z'; ++c) {
            System.out.print(Objects.hash(c) + " of "+ c);
            System.out.print(" < ");
            System.out.print(c - 'a');
            System.out.println(" >, ");

        }
        for (int i = 0; i <= 25; i++){
            System.out.println((char) ('a' - i) + "  ");
        }
        for (int i = 0; i <= 25; i++){
            System.out.println((char) ('a' + i) + "  ");
        }
    }
}
