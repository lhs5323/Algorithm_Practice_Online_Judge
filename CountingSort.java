import java.util.*;
import java.math.BigInteger;

public class CountingSort{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    BigInteger[] unsorted = new BigInteger[n];
    for(int i = 0; i < n; i++){
      unsorted[i] = sc.nextBigInteger();
    }
    int max = -10^9 -1; int min = 10^9+1;
    BigInteger max_val = BigInteger.valueOf(max);
    BigInteger min_val = BigInteger.valueOf(min);
    for(int i = 0; i < unsorted.length; i++){ // setting the range of counting array
      if(unsorted[i].compareTo(max_val) > 0){
        max_val = unsorted[i];
      }
      if(unsorted[i].compareTo(min_val) < 0){
        min_val = unsorted[i];
      }
    }
    BigInteger max_range = max_val.subtract(min_val).add(BigInteger.ONE);
    BigInteger[] counting = new BigInteger[max_range.intValue()];
    BigInteger j = BigInteger.ZERO;
    BigInteger counting_length = BigInteger.valueOf(counting.length);
    while(j.compareTo(counting_length) < 0){
      counting[j.intValue()] = BigInteger.ZERO;
      j = j.add(BigInteger.ONE);
    }
    for(int i = 0; i < unsorted.length; i++){ //Counting array, occurence of element
      BigInteger value = unsorted[i];
      //BigInteger min_val = BigInteger.valueOf(min);
      BigInteger index = value.subtract(min_val);
      counting[index.intValue()] = counting[index.intValue()].add(BigInteger.ONE); // shift
    }

    int count = 0;
    BigInteger a = BigInteger.ZERO;
    while(a.compareTo(counting_length) < 0){
      BigInteger b = BigInteger.ZERO;
      while(b.compareTo(counting[a.intValue()]) < 0){
        unsorted[count] = a.add(min_val);
        count = count + 1;
        b = b.add(BigInteger.ONE);
      }
      a = a.add(BigInteger.ONE);
    }


    System.out.println(unsorted[k-1]);
  }
}
