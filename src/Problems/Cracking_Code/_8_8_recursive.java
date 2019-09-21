package Problems.Cracking_Code;
import java.util.*;
public class _8_8_recursive {
    static String os;
    static ArrayList<String> permutations;
    static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public static void main(String[] args) {
        permutations = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        os = sc.next();
        for (int i = 0; i < os.length(); i++){
            if (!map.containsKey(os.charAt(i))) {
                map.put(os.charAt(i), 1);
            }
            else {
                map.put(os.charAt(i),map.get(os.charAt(i))+1);
            }
        }
        permute("",os.length());
        System.out.println(permutations.size());

    }
    static void permute(String s, int remaining) {
        if (remaining == 0) {
            System.out.println(s);
            permutations.add(s);
            return;
        }
        for (Character c: map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c,count-1);
                permute(s+c.toString(),remaining-1);
                map.put(c, count);
            }
        }

    }
}
