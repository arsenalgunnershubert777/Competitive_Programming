package UFPT;
import java.util.*;
public class Qualification {
    //no idea yet
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numProbs = sc.nextInt();
        int numTeams = sc.nextInt();
        ArrayList<ArrayList<Integer>> reference = new ArrayList<>();
        for (int i = 0; i < numProbs; i++) {
            reference.add(new ArrayList<>());
            for (int j = 0; j < numProbs;j++) {

                if (sc.nextInt() == 1) {
                    reference.get(i).add(j);
                }
            }
        }
    }
}
