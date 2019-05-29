package UFPT.pkg_bf_4_5_19;
import java.util.*;
public class Length_Encoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        if (next.equals("E")) {
            String toEncode = sc.next();

            Set<Character> set = new HashSet<>();
            int count = 0;
            String output = "";
            int num = 0;
            while (count < toEncode.length()) {
                char c = toEncode.charAt(count);
                if (!set.contains(c)) {
                    if (num > 0) {
                        output += num;
                    }
                    set.clear();
                    set.add(c);
                    output += c;
                    num = 1;
                }
                else {
                    num++;
                }
                count++;
            }
            output += num;
            System.out.println(output);
        }
        else if (next.equals("D")) {
            String output ="";
            String toDecode = sc.next();
            for (int i = 0; i < toDecode.length(); i+=2) {
                char c = toDecode.charAt(i);
                int num = Character.getNumericValue(toDecode.charAt(i+1));
                for (int j = 0; j < num; j++) {
                    output += c;
                }
            }
            System.out.println(output);

        }
    }
}
