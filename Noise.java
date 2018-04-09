import java.util.*;
import java.math.BigInteger;

public class Noise{
    public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
      BigInteger a = sc.nextBigInteger();
      char pattern = sc.next().charAt(0);
      //System.out.println(pattern);
      BigInteger b = sc.nextBigInteger();

      if (pattern == '*'){
        BigInteger mult = a.multiply(b);
        System.out.println(mult);
      } else if(pattern == '+'){
        BigInteger add = a.add(b);
        System.out.println(add);
      }

    }
}
