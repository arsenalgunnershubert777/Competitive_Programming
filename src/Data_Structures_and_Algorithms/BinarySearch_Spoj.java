package Data_Structures_and_Algorithms;
import java.util.*;
//https://www.spoj.com/status/start=40
//this didn't work out because it wasn't fast enough, needed scanf in C lol
public class BinarySearch_Spoj {



    public static void main (String[] args)
    {

        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] strs = s.trim().split("\\s+");
        int N = Integer.parseInt(strs[0]);
        int Q = Integer.parseInt(strs[1]);
        int[] array = new int[N];

        s = input.nextLine();
        strs = s.trim().split("\\s+");

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(strs[i]);

        }

        for (int i = 0; i < Q; i++) {
            int value = input.nextInt();
            int lo = 0;
            int hi = array.length - 1;
            boolean found = false;
            int index = 0;
            while (lo <= hi) { //binary search right here
                int mid = lo + (hi-lo)/2;
                if (array[mid] == value) {
                    found = true;
                    index = mid;
                    break;
                }
                else if (value > array[mid]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid -1;
                }
            }
            if (found) {
                while (index >=0 && array[index] == value) {
                    index--;
                }
                System.out.println(index+1);
            }
            else {
                System.out.println( -1);
            }
        }


    }

}
