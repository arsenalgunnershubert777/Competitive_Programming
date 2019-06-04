package Problems.UVa;
import java.util.*;
import java.io.*;
public class Vacation { //did not meet time requirement
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));

        String s = input.readLine();
        String[] strs = s.trim().split("\\s+");
        int numVouchers = Integer.parseInt(strs[0]);
        int numDays = Integer.parseInt(strs[1]);
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Voucher[] vouchers = new Voucher[numVouchers];
        int earliestIndex = -1;
        int earliestStart = 0;
        for (int i = 0; i < numVouchers; i++) {
            s = input.readLine();
            strs = s.trim().split("\\s+");
            int l = Integer.parseInt(strs[0]);
            int r = Integer.parseInt(strs[1]);
            int cost = Integer.parseInt(strs[2]);
            vouchers[i] = new Voucher(l, r, cost);


        }
        Arrays.sort(vouchers);

        int currCost = -1;
        for (int i = 0; i < vouchers.length; i++) {
            Voucher v = vouchers[i];
            for (int j = i+1; j < vouchers.length; j++) {
                Voucher w = vouchers[j];
                int start = v.r;
                if (start < w.l) {
                    if (v.duration + w.duration == numDays) {
                        int cost = v.cost + w.cost;
                        if (currCost == -1)
                            currCost = cost;
                        else if (v.cost + w.cost < currCost)
                            currCost = cost;
                    }
                }

            }
        }
        System.out.println(currCost);

    }
}
class Voucher implements Comparable<Voucher> {
    public int l;
    public int r;
    public int cost;
    public int duration;
    public Voucher(int l, int r, int cost){
        this.l = l;
        this.r = r;
        this.cost = cost;
        this.duration = r-l+1;
    }

    @Override
    public int compareTo(Voucher o) {
        return this.r - o.r;

    }
}
