import java.util.*;
import java.lang.Double;
public class Ranking {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Entry>> list = new ArrayList<>();
        int numRounds = sc.nextInt();

        for (int j = 0; j < numRounds; j++) {
            list.add(new ArrayList<Entry>());
            for (int i = 0; i < 26; i++) {
                double score = sc.nextDouble();
                Entry e = new Entry(i, score);
                list.get(j).add(e);
            }

        }
        ArrayList<Entry> finalList = new ArrayList<>();
        for (int i = 0; i < list.get(0).size(); i++) {
            int sum  = 0;
            for(int k = 0; k < numRounds; k++) {
                sum+=list.get(k).get(i).getValue();
            }
            Entry e = new Entry(i,sum);
            finalList.add(e);
        }
        Collections.sort(finalList);
        for (int i = 0; i < finalList.size();i++) {
            System.out.println("key: " + (finalList.get(i).getKey() + 1) + " value: " + finalList.get(i).getValue() + " rank: " + (i+1));
        }

    }
}
class Entry implements Comparable<Entry> {
    private int key;
    private double value;

    public Entry(int key, double value) {
        this.key = key;
        this.value = value;
    }

    // getters
    public double getValue() {
        return this.value;
    }
    public int getKey() {
        return this.key;
    }

    @Override
    public int compareTo(Entry other) {
        return Double.compare(this.getValue(),other.getValue());

    }
}