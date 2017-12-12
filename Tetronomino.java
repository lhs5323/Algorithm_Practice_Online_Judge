import java.util.*;
import java.lang.Math;

public class Tetronomino{
  public static int[][] paper;
  public static int max;
  //public static int h;
  //public static int w;
  //public static int square_max;

  public static int l_block(int x, int y){
    int value = 0;
    int case_1 = 0; int case_2 = 0; int case_3 = 0; int case_4 = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 2; j++){
        value = value + paper[i][j];
        case_1 = paper[x+i][y+j+1] + paper[x+i+1][y+j+1];
        case_2 = paper[x+i+1][y+j+1] + paper[x+i+2][y+j+1];
        case_3 = paper[x+i+1][y+j] + paper[x+i+2][j+j];
        case_4 = paper[x+i][y+j] + paper[x+i+1][y+j];
      }
    }

    value = Math.max(Math.max(Math.max(value - case_1, value - case_2), value - case_3), value - case_4);
    int value_1 = 0;
    int case_5 =0; int case_6 =0; int case_7 =0; int case_8 =0;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 3; j++){
        value_1 = value_1 + paper[i][j];
        case_5 = paper[x+i][y+j+1] + paper[x+i][y+j+2];
        case_6 = paper[x+i+1][y+j+1] + paper[x+i+1][y+j+2];
        case_7 = paper[x+i][y+j] + paper[x+i][y+j+1];
        case_8 = paper[x+i+1][y+j+1] + paper[x+i+1][y+j+2];
      }
    }
    value_1 = Math.max(Math.max(Math.max(value_1 - case_5, value_1 - case_6), value_1 - case_7), value_1 - case_8);
    return Math.max(value, value_1);
  }
  //fuck you shaped tetris
  public static int mountain_block(int x, int y){
    int value = 0;
    int case_1 = 0; int case_2 = 0; int case_3 = 0; int case_4 = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 2; j++){
        value = value + paper[i][j];
        case_1 = paper[x+i][y+j+1] + paper[x+i+2][y+j+1];
        case_2 = paper[x+i][y+j] + paper[x+i+2][y+j];

      }
    }
    value = Math.max(value - case_1, value - case_2);
    int value_1 = 0;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 3; j++){
        value_1 = value_1 + paper[i][j];
        case_3 = paper[x+i][y+j] + paper[x+i][y+j+2];
        case_4 = paper[x+i+1][y+j] + paper[x+i+1][y+j+2];
      }
    }
    value_1 = Math.max(value_1 - case_3, value_1 - case_4);
    return Math.max(value, value_1);
  }
  //zigzag tetris
  public static int zigzag(int x, int y){
    int value = 0;
    int case_1 = 0; int case_2 = 0; int case_3 = 0; int case_4 = 0;
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 2; j++){
        value = value + paper[i][j];
        case_1 = paper[x+i][y+j] + paper[x+i+2][y+j+1];
        case_2 = paper[x+i][y+j+1] + paper[x+i+2][y+j];
      }
    }
    value = Math.max(value-case_1, value - case_2);
    int value_1 = 0;
    for (int i = 0; i < 2; i++){
      for (int j = 0; j < 3; j++){
        value_1 = value_1 + paper[i][j];
        case_3 = paper[x+i][y+j] + paper[x+i+1][y+j+2];
        case_4 = paper[x+i][y+j+2] + paper[x+i+1][y+j];
      }
    }
    value_1 = Math.max(value_1 - case_3, value_1-case_4);
    return (Math.max(value, value_1));
  }

  public static int perfect_square(int x, int y){
    int value = 0;
    for (int i = 0; i < 3; i++){
      for (int j= 0; j < 3; j++){
        value = paper[x+i][y+j] + paper[x+i+1][y+j] + paper[x+i][y+j+1] + paper[x+i+1][y+j+1];
        if (value > max){
          max = value;
        }
        //System.out.println(value);
      }
    }
    //System.out.println(max);
    return max;
  }

  public static int straight(int x, int y){
    int value = 0;
    for (int i = 0; i < 4; i++){
      for(int j = 0; j < 1; j++){
        value = value + paper[x+i][y+j];
      }
    }
    int value_1 = 0;
    for (int i = 0; i < 1; i++){
      for(int j = 0; j < 4; j++){
        value_1 = value_1 + paper[x+i][y+j];
      }
    }
    return Math.max(value, value_1);
  }


  public static void main(String[] args){

    //int max = 0; int value = 0;
    //int[][] paper;
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int w = sc.nextInt();
    //int[][] ppaper;
    paper = new int [h][w];
    //Tetronomino tetro = new Tetronomino(H, W);
    for (int i = 0; i < h; i++){
      for (int j = 0; j < w; j++) {
        paper[i][j] = sc.nextInt();
      }
    }
    //int max_1 =0; int max_2 =0; int max_3 =0; int max_4 = 0; int max_5 = 0;
    int square_max = 0;
    for (int n = 0; n < h-3; n++){
      for (int m = 0; m < w-3; m++){
        if (square_max < perfect_square(n,m)){
          square_max = perfect_square(n,m);
        }
        //square_max = perfect_square(n,m);
        //max_2 = straight(n,m);
        //max_3 = mountain_block(n,m);
        //max_4 = l_block(n,m);
        //max_5 = zigzag(n,m);

      }
    }
    System.out.println(square_max);
    //System.out.println(perfect_square());
    //System.out.println(Math.max(Math.max(Math.max(Math.max(max_1,max_2),max_3),max_4),max_5));


  }

  //block


}
