package Problems.Codeforces;
import java.util.*;
public class They_Are_Everywhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numFlats = sc.nextInt();
        String pokeMon = sc.next();


        HashMap<Character, Integer> uniquePokemon = new HashMap<>();

        for (int i = 0; i < pokeMon.length();i++) {
            uniquePokemon.put(pokeMon.charAt(i), -1);

        }
        int numUnique = uniquePokemon.keySet().size();
        int first;
        int last;
        int min = -1;
        HashSet<Character> uniques = new HashSet<>();
        TreeSet<Integer> indexes = new TreeSet<>();
        for (int i = 0; i < pokeMon.length();i++) {
            Character c = pokeMon.charAt(i);
            if (uniques.size() == numUnique) {
                indexes.remove(uniquePokemon.get(c));
                indexes.add(i);
                uniquePokemon.put(c, i);
            }

            else if (uniques.add(c)) {
                indexes.add(i);
                uniquePokemon.put(c, i);
            }
            else {
                indexes.remove(uniquePokemon.get(c));
                indexes.add(i);
                uniquePokemon.put(c, i);
            }


            if (uniques.size() == numUnique) {


                first = indexes.first();

                last = i;

                if (last - first + 1 < min || min == -1) {
                    min = last - first + 1;
                }

            }




        }

        System.out.println(min);

    }
}
