package Problems.Cracking_Code;
import java.util.*;
public class _8_7_recursive {
    static String os;
    static ArrayList<String> permutations;
    public static void main(String[] args) {
        permutations = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        os = sc.next();
        permute(os.substring(0,1));

    }
    static void permute(String s) {
        if (s.length() == os.length()) {
            System.out.println(s);
            permutations.add(s);
            return;
        }

        for (int i = 0; i <= s.length();i++){
            String s_new = s.substring(0,i) + os.substring(s.length(),s.length()+1) + s.substring(i);

            permute(s_new);
        }
    }
}
