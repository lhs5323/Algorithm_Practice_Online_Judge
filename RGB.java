import java.util.*;
public class RGB {
    public static void main(String[] args){
        similarRGB("#09f166");
    }

    public static String[] hex_digit = new String[]{0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F};
    public static int[] similarRGB(String color) {
        int max_val = 0xff; int min_val = 0x00;
        int[] color_array = new int[3];
        int index = 0;
        for(int i = 1; i < color.length(); i+=2){
            char first = color.charAt(i);
            char second = color.charAt(i+1);
            //String color_division = first+second;
            int color_division = Integer.decode("0x"+first+second);
            color_array[index] = color_division;
            //System.out.println(color_array[index]);
            index++;
        }
        return color_array;
    }
}
