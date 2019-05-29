package UFPT.pkg_bf_4_5_19;
//https://odzkskevi.qnssl.com/2c6b512b8481d415d3ab8dfa08bbcf8b?v=1536949343
import java.util.*;
import java.io.*;
import java.math.*;
public class Jolly_Jumpers {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = input.readLine()) != null) {
            String[] strs = s.trim().split("\\s+");
            int N = Integer.parseInt(strs[0]);
            HashSet<Integer> set = new HashSet<>();
            boolean Jolly = true;
            for (int i = 1; i < strs.length - 1;i++) {

                int diff = Math.abs((Integer.parseInt(strs[i]) - Integer.parseInt(strs[i+1])));

                if ( diff < N && !set.contains(diff)){
                    set.add(diff);
                }
                else {
                    Jolly = false;
                    System.out.println("Not jolly");
                    break;
                }
            }
            if (Jolly) {
                System.out.println("Jolly");
            }


        }

    }

}
