package Problems.SPOJ;
//https://www.spoj.com/problems/SCAVHUNT/
import java.util.*;
public class SCAVHUNT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTimes = sc.nextInt();

        for (int j = 0; j < numTimes; j++) {
            HashMap<String, String> map = new HashMap<>();
            int numPlaces = sc.nextInt();
            for (int i = 0; i < numPlaces - 1; i++) {
                map.put(sc.next(), sc.next());
            }
            System.out.println("Scenario #" + (j+1) + ":");
            String trackString = "";
            for (String s : map.keySet()) {
                if (!map.containsValue(s)) {
                    trackString = s;
                    break;
                }
            }
            do {
                System.out.println(trackString);
                trackString = map.get(trackString);
            }
            while (map.containsKey(trackString));
            System.out.println(trackString);

        }

    }
}
