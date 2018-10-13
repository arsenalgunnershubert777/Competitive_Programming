package UFPT;
import java.util.*;
import java.io.*;
public class Min_Val_Rect {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int numTests = Integer.parseInt(sc.readLine());

        for (int i = 0;i < numTests; i++) {
            int numSticks = Integer.parseInt(sc.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            String s = "";
            s = sc.readLine();
            String[] strs = s.trim().split("\\s+");



            ArrayList<Integer> availSticksFinal = new ArrayList<>();
            HashSet<Integer> set = new HashSet<>();

            for (int j = 0; j < numSticks; j++) {
                Integer number = Integer.parseInt(strs[j]);
                boolean bool = set.add(number);
                if (!bool) {
                    availSticksFinal.add(number);
                    set.remove(number);

                }


            }
            availSticksFinal.sort(Collections.reverseOrder());

            int minDistance = availSticksFinal.get((0)) - availSticksFinal.get(1);
            float minRatio = ((float) availSticksFinal.get(0)) / availSticksFinal.get(1);
            int index = 0;
            for (int j = 1; j < availSticksFinal.size() - 1; j++) {
                int distance = availSticksFinal.get(j) - availSticksFinal.get(j + 1);
                if (distance < minDistance) {
                    float ratio = ((float) availSticksFinal.get(j)) / availSticksFinal.get(j + 1);
                    if (ratio < minRatio) {
                        minRatio = ratio;
                        index = j;
                        if (distance == 0)
                            break;

                    }
                    minDistance = distance;


                }

            }
            System.out.println(availSticksFinal.get(index) + " " + availSticksFinal.get(index) + " " + availSticksFinal.get(index + 1) + " " + availSticksFinal.get(index + 1));



        }
    }
}
