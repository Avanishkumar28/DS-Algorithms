public class Triangle {
  public static void main(String[] args) {
    printStarTriangle(10);
  }

  private static void printStarTriangle(int size) {
    for (int i = 1; i<=size; i++){
      for(int j = 1; j<=size-i; j++){
        System.out.print(" ");
      }
      for (int k = 1; k<2*(i-1); k++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
