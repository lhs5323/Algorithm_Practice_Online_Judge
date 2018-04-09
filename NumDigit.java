import java.util.*;

public class NumDigit{
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int digit = 0;
    for (int i = 1; i<n+1; i = i*10){
      digit += n - i + 1;
    }
    System.out.println(digit);
  }
}
