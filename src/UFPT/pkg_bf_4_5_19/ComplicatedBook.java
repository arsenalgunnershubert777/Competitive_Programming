package UFPT.pkg_bf_4_5_19;
import java.util.*;
import java.io.*;
public class ComplicatedBook {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s= input.readLine();
        String[] strs = s.trim().split("\\s+");

        int permLength = Integer.parseInt(strs[0]);
        int numSorts = Integer.parseInt(strs[1]);
        int[] list = new int[permLength];
        s= input.readLine();
        strs = s.trim().split("\\s+");
        for (int i = 0; i < permLength; i++) {
            list[i] = Integer.parseInt(strs[i]);
        }
        for (int i = 0; i < numSorts; i++) {
            s= input.readLine();
            strs = s.trim().split("\\s+");
            int leftBound = Integer.parseInt(strs[0]) - 1;
            int rightBound = Integer.parseInt(strs[1]) -1;
            int position = Integer.parseInt(strs[2]) -1;
            int[] toSort = new int[rightBound - leftBound + 1];
            for (int j = 0; j < rightBound -leftBound + 1; j++) {
                toSort[j] = list[j +leftBound];
            }
            Arrays.sort(toSort);
            if (toSort[position- leftBound] == list[position]) {
                System.out.println("Yes");
            }
            else
                System.out.println("No");
        }
    }
}
