import java.util.*;

public class Triangle{
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      int sum = 0;
      int[] angles = new int[3];

      for (int i = 0; i < angles.length; i++){
        angles[i] = sc.nextInt();
        sum += angles[i];
      }

      if(sum != 180){
          System.out.println("Error");
      } else if((angles[0] == angles[1]) && (angles[1] == angles[2])) {
        System.out.println("Equilateral");
      } else if(((angles[0] == angles[1]) && (angles[0] != angles[2])) || ((angles[0] == angles[2]) && (angles[1] != angles[2])) || ((angles[1] == angles[2]) && (angles[1] != angles[0]))) {
        System.out.println("Isosceles");
      } else if ((angles[0] != angles[1]) && (angles[1] != angles[2])) {
        System.out.println("Scalene");
      }

    }
}
