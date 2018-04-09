/***************************************************************
4013. [모의 SW 역량테스트] 특이한 자석
scanner input variables: t_case(테스트케이스), t_rotate(회전 수),
                        move[i][j](i=gear_num, j = right or left 회전)
                        magnet[i][j](톱니바퀴 날(n극 혹은 s극))
main variables: 1,2,3,4 gear[](자석달린 톱니바튀#), answer(점수)

간단한 문제설명: 4개의 톱니 놓여져 있었고, 각 톱니는 8개의 ‘날’(튀어나온 곳)를 가지고 있다.
톱니의 각 날 마다 N 극 또는 S 극의 자성을 가지고 있다. input으로 톱니의 #와 회전수가 주어진다
특정 위치의 날이 상극이면 반대로 돌아감....같은 자성을 가진 날이면 돌아가지 않음.

접근: 구현(가짓수 비교)ㅜ 다른 알고리즘 모르겠음 ㅜ
**************************************************************/
import java.util.*;

public class MagnetRotation{
  public static int[][] magnet;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t_case = sc.nextInt();
    int t_rotate = sc.nextInt();
    magnet = new int[4][8];
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 8; j++){
        magnet[i][j] = sc.nextInt();
      }
    }
    int[][] move = new int[t_rotate][2];
    for(int i = 0; i < t_rotate; i++){
      for(int j = 0; j < 2; j++){
          move[i][j] = sc.nextInt();
      }
    }
    int[] first_gear = new int[8]; int[] second_gear = new int[8]; int[] third_gear = new int[8]; int[] fourth_gear = new int[8];
    for(int i = 0; i < magnet.length; i++){
      for(int j = 0; j < magnet[0].length; j++){
        if(i == 0){
          first_gear[j] = magnet[0][j];
        } else if(i == 1){
          second_gear[j] = magnet[1][j];
        } else if (i == 2){
          third_gear[j] = magnet[2][j];
        } else{
          fourth_gear[j] = magnet[3][j];
        }
      }
    }
    //number of conditions
    for(int i = 0; i < move.length; i++){
      for(int j = 0; j < 2; j++){
        int which_gear = move[i][0]; int move_gear = move[i][1];
        //first gear: moves, check either first gear(2nd position) or second gear(6th position)
        //whether it contains same magnetism, continue step 3rd and 4th gear
        if(which_gear == 1){
          if(move_gear == 1){
            first_gear = move_right(get_magnet(which_gear-1));
            if(magnet[0][2] != magnet[1][6]){
              second_gear = move_left(get_magnet(which_gear));
              if(magnet[1][2] != magnet[2][6]){
                System.out.println(magnet[1][6]);
                System.out.println(magnet[2][2]);
                third_gear = move_right(get_magnet(which_gear+1));
                if(magnet[2][6] != magnet[3][2]){
                  fourth_gear = move_left(get_magnet(which_gear+2));
                }
              }
            }
          } else {
              first_gear = move_left(get_magnet(which_gear-1));
              if(magnet[0][2] != magnet[1][6]){
                second_gear = move_right(get_magnet(which_gear));
                if(magnet[1][2] != magnet[2][6]){
                  third_gear = move_left(get_magnet(which_gear+1));
                  if(magnet[2][6] != magnet[3][2]){
                    fourth_gear = move_right(get_magnet(which_gear+2));
                }
              }
            }
          }
          //second gear: moves chk first_gear and then third and fourth
        } else if(which_gear == 2){
            if(move_gear == 1){
              second_gear = move_right(get_magnet(which_gear-1));
              if(magnet[1][6] != magnet[0][2]){
                first_gear = move_left(get_magnet(which_gear-2));
              }
              if(magnet[1][2] != magnet[2][6]){
                third_gear = move_left(get_magnet(which_gear+1));
                if(magnet[2][2] != magnet[3][6]){
                  fourth_gear = move_right(get_magnet(which_gear+2));
                }
              }
            } else{
                second_gear = move_left(get_magnet(which_gear-1));
                if(magnet[1][6] != magnet[0][2]){
                  first_gear = move_right(get_magnet(which_gear-2));
                }
                if(magnet[1][2] != magnet[2][6]){
                  third_gear = move_right(get_magnet(which_gear+1));
                  if(magnet[2][2] != magnet[3][6]){
                    fourth_gear = move_left(get_magnet(which_gear+2));
                  }
                }
            }
            //third gear: same above but compare with fourth first
          } else if(which_gear == 3){
              if(move_gear == 1){
                third_gear = move_right(get_magnet(which_gear-1));
                if(magnet[2][2] != magnet[3][6]){
                  fourth_gear = move_left(get_magnet(which_gear));
                }
                if(magnet[2][6] != magnet[1][2]){
                  second_gear = move_left(get_magnet(which_gear-2));
                  if(magnet[1][6] != magnet[0][2]){
                    first_gear = move_right(get_magnet(which_gear-3));
                  }
                }
              } else{
                third_gear = move_left(get_magnet(which_gear-1));
                if(magnet[2][2] != magnet[3][6]){
                  fourth_gear = move_right(get_magnet(which_gear));
                }
                if(magnet[2][6] != magnet[1][2]){
                  second_gear = move_right(get_magnet(which_gear-2));
                  if(magnet[1][6] != magnet[0][2]){
                    first_gear = move_left(get_magnet(which_gear-3));
                  }
                }
              }
              //fourth gear
          } else {
            if(move_gear == 1){
              fourth_gear = move_right(get_magnet(which_gear-1));
              if(magnet[3][6] != magnet[2][2]){
                third_gear = move_left(get_magnet(which_gear-2));
                if(magnet[2][6] != magnet[1][2]){
                  second_gear = move_right(get_magnet(which_gear-3));
                  if(magnet[1][6] != magnet[0][2]){
                    first_gear = move_left(get_magnet(which_gear-4));
                  }
                }
              }
            } else {
                fourth_gear = move_left(get_magnet(which_gear-1));
                if(magnet[3][6] != magnet[2][2]){
                  second_gear = move_right(get_magnet(which_gear-2));
                  if(magnet[2][6] != magnet[1][2]){
                    third_gear = move_left(get_magnet(which_gear-3));
                    if(magnet[1][6] != magnet[0][2]){
                      fourth_gear = move_right(get_magnet(which_gear-4));
                  }
                }
              }
            }
          }
        }
        //magnet[][] 다시 초기화
        for(int a = 0; a < magnet.length; a++){
          for(int b = 0; b < magnet[0].length; b++){
            if(a == 0){
              magnet[0][b] = first_gear[b];
            } else if(a == 1){
              magnet[1][b] = second_gear[b];
            } else if(a == 2){
              magnet[2][b] = third_gear[b];
            } else{
              magnet[3][b] = fourth_gear[b];
            }
          }
        }
      }
      //printing score
    int[] score = new int[]{1,2,4,8}; int answer = 0;
    for(int result = 0; result < 4; result++){
      if(magnet[result][0] == 0){
        answer = answer;
      } else{
        answer = answer + score[result];
      }
    }
    System.out.println(answer);
  }
  //extracting magnet from a gear
  public static int[] get_magnet(int gear_num){
    int[] each_magnet = new int[8];
    for(int x = 0; x < 8; x++){
        each_magnet[x] = magnet[gear_num][x];
      }
    return each_magnet;
  }

  //rotate right
  public static int[] move_right(int[] machine){
    int temp = machine[machine.length-1];
    for(int i = machine.length-2; i >= 0; i--){
      machine[i+1] = machine[i];
    }
    machine[0] = temp;
    return machine;
  }

  //rotate left
  public static int[] move_left(int[] machine){
    int temp = machine[0];
    for(int i = 1; i < machine.length; i++){
      machine[i-1] = machine[i];
    }
    machine[machine.length-1] = temp;
    return machine;
  }
}
