package Problems.SPOJ;
//https://www.spoj.com/problems/HOMO/
import java.util.*;
public class HOMO {
    public static void main(String[] args) {
        //too slow
        /*Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();


        int numEntries = sc.nextInt();

        for (int i = 0; i < numEntries; i++) {
            if (sc.next().equals("insert")) {
                int num = sc.nextInt();
                list.add(num);
                set.add(num);

            }
            else {
                int num = sc.nextInt();
                ((LinkedList<Integer>) list).removeFirstOccurrence(num);
                if (!list.contains(num)) {
                    set.remove(num);
                }
            }

            if (list.size() <= 1) {
                System.out.println("neither");
            }
            else if (list.size() > set.size() && set.size() > 1) {
                System.out.println("both");
            }
            else if (set.size() > 1) {
                System.out.println("hetero");
            }
            else if (set.size() == 1) {
                System.out.println("homo");
            }
            else {
                System.out.println("neither");
            }
        }*/

        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        String status = "neither";
        int count = 0;

        int numEntries = sc.nextInt();
        for (int i = 0; i < numEntries; i++) {
            if (sc.next().equals("insert")) {
                int num = sc.nextInt();
                if (!map.containsKey(num)) {
                    boolean isEmpty = map.isEmpty();
                    map.put(num, 1);


                    if(isEmpty){
                        status = "neither";
                    }else{
                        if(status.equals("homo") || status.equals("both")){
                            status = "both";
                        }else{
                            status = "hetero";
                        }
                    }
                }
                else {
                    int freq = map.get(num);
                    map.replace(num, freq + 1);

                    if(map.get(num) == 2){
                        if(status.equals("neither")){
                            status = "homo";
                            count++;
                        }else{
                            status = "both";
                            count++;
                        }
                    }
                }


            }
            else {
                int num = sc.nextInt();
                if (map.containsKey(num)) {


                    int freq = map.get(num);
                    if (freq > 1) {
                        map.replace(num, freq - 1);
                        if (map.get(num) == 1) {

                            if(map.get(num) == 1){
                                count--;
                                if(status.equals("homo")){
                                    status= "neither";
                                }else if(status.equals("both")){
                                    status = "hetero";
                                    if(count > 0){
                                        status = "both";
                                    }
                                }
                            }
                        }
                    } else {
                        map.remove(num);


                        if(map.size() <= 1){
                            if(count == 1){
                                status = "homo";
                            }else{
                                status = "neither";
                            }
                        }

                    }
                }
            }
            System.out.println(status);





        }
    }

}

