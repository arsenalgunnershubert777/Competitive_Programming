package UFPT.pkg_bf_4_5_19;
//https://www.spoj.com/problems/AGGRCOW/
        import java.util.*;

public class AGGRCOW {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int j = 0; j < numTests; j++) {
            int numStables = sc.nextInt();
            int numCows = sc.nextInt();
            TreeSet<Integer> stableLocations = new TreeSet<>();
            for (int i = 0; i < numStables; i++) {
                stableLocations.add(sc.nextInt());
            }
            ArrayList<Integer> stables = new ArrayList<>(stableLocations);
            int lo = 1;
            int hi = stables.get(numStables - 1) - stables.get(0);
            int mid;
            while (lo <= hi) {
                mid = lo + (hi - lo) / 2;
                if (distanceWorks(mid, stables, numCows)) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }

            }
            System.out.println(hi);
        }


    }

    static boolean distanceWorks (int n, ArrayList<Integer> stableLocations, int numCows) {
        numCows--;
        int prevPos = stableLocations.get(0);
        for (int i = 1; i < stableLocations.size(); i++) {
            if (stableLocations.get(i) - prevPos >= n) {
                numCows--;
                prevPos = stableLocations.get(i);
                if (numCows <= 0)
                    return true;
            }
        }
        return false;

    }
}
