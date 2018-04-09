import java.util.*;

public class TravelSchedule{
  public static void main(String[] args){
    int[][] flight = new int[][]{{0,1,1},{1,0,1},{1,1,0}};
    int[][] day = new int[][]{{7,0,0,5},{0,7,0,5},{0,0,7,5}};
    System.out.println(maxVacationDays(flight, day));
  }

  public int maxVacationDays(int[][] flights, int[][] days){

    int[] schedule = new int[days[0].length]; int week = 0; int visit = 0;
    while(week <= days[0].length-1){
      int rest = 0;
      for(int j = 0; j < flights.length; j++){
        if(flights[visit][j] == 1){
          //rest = days[j][week];
          if(days[j][week] > rest){
            rest = days[j][week  ];
            visit = j;
          }
          schedule[week] = rest;
          //week++;
        }
      }
      if(rest == 0){
        schedule[week] = days[visit][week];
      }
      week++;
    }
    int total_rest = 0;

    for(int i = 0; i < schedule.length; i++){
      total_rest = total_rest + schedule[i];
      //System.out.println(schedule[i]);
    }
    return total_rest;
  }
}
