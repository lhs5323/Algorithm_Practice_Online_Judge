import java.util.*;
import java.util.stream.Collectors;

public class algorithm_2108 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // number of ints stored in 'n'
    int n = sc.nextInt();

    //list array
    List<Integer> list_result = new ArrayList<Integer>();

    //if sc has next int in line
    if (sc.hasNextInt()){
      for (int i = 0; i < n; i++) {
        //store them into a list
        list_result.add(sc.nextInt());
        //System.out.println(list_result);
      }
    }

    //1 method
    System.out.println(list_average(list_result));

    //2 method
    Collections.sort(list_result);
    System.out.println(middle_element(list_result));

    //3 method
    System.out.println(count_element(list_result));

    //4 method
    System.out.println(list_result.get(list_result.size()-1) - list_result.get(0));
  }

    // First method: sum of list numbers and divided by the length of the list(mean)
    public static int list_average(List<Integer> array){
      int average_sum = 0;
      for (int i = 0; i < array.size(); i++){
        average_sum = average_sum + array.get(i);
      }
      average_sum = (average_sum / array.size());
      return average_sum;
    }

    // Second Method: find the middle element's value(median)
    public static int middle_element(List<Integer> array){
      int median = 0;
      median = array.get((array.size()/2));
      return median;
    }

    //Third method to cacluate the mode
    public static int count_element(List<Integer> array){
      int count = 0; int maxCount = 0; int result = 0;
      HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
      for (int i = 0; i < array.size(); i++){
        if (hs.get(array.get(i)) != null){
          count = hs.get(array.get(i));
          count = count + 1;
          hs.put(array.get(i), count);

          if (count > maxCount){
            maxCount = count;
            //result = array.get(i);
          }
        } else {
          hs.put(array.get(i), 1);
        }
      }
      //Map<Integer, Integer> map = new HashMap<>();
      Map<Integer, Integer> swapped = hs.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
      if (swapped.get(maxCount) == maxCountZA
      }
      //return result;
    }
}
