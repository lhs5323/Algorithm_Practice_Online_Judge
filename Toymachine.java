import java.util.*;

public class ToyMachine{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int copies = sc.nextInt();
    int original = sc.nextInt();
    int bitmask = 1;

    //System.out.println(original & bitmask);
    if((original == copies) || (copies <= original-2) || (((original & bitmask) == 1) && ((copies & bitmask) != 0)) || (((original & bitmask) == 0) && ((copies & bitmask) != 1))){
      System.out.println("No");
    } else{
      System.out.println("Yes");
    }
  }
}
