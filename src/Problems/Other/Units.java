package Problems.Other;
import java.util.*;
public class Units {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int numUnits = sc.nextInt();
            if (numUnits == 0) {
                break;
            }
            sc.nextLine();
            sc.nextLine();
            HashMap<String, String> mapRight = new HashMap<>();
            HashMap<String, String> mapLeft = new HashMap<>();
            HashMap<String, Integer> mapNumRight = new HashMap<>();
            HashMap<String, Integer> mapNumLeft = new HashMap<>();

            for (int i = 0; i < numUnits - 1; i++) {
                String parent = sc.next();
                sc.next();
                int conversion = sc.nextInt();
                String child = sc.next();

                if (mapRight.containsKey(parent)) {
                    while (true) {
                        if (!mapNumRight.containsKey(parent)) {
                            mapRight.put(parent, child);
                            mapNumRight.put(parent, conversion);
                            mapLeft.put(child, parent);
                            mapNumLeft.put(child, conversion);
                            break;
                        } else if (mapNumRight.get(parent) > conversion) {
                            int prevConv = mapNumRight.get(parent);
                            String prevChild = mapRight.get(parent);
                            mapRight.put(parent, child);
                            mapRight.put(child, prevChild);
                            mapNumRight.put(parent, conversion);
                            mapNumRight.put(child, prevConv / conversion);
                            mapLeft.put(prevChild, child);
                            mapLeft.put(child, parent);
                            mapNumLeft.put(prevChild, prevConv / conversion);
                            mapNumLeft.put(child, conversion);
                            break;

                        } else {


                            conversion /= mapNumRight.get(parent);
                            parent = mapRight.get(parent);


                        }
                    }


                } else if (mapLeft.containsKey(child)) {
                    while (true) {
                        if (!mapNumLeft.containsKey(child)) {
                            mapRight.put(parent, child);
                            mapNumRight.put(parent, conversion);
                            mapLeft.put(child, parent);
                            mapNumLeft.put(child, conversion);
                            break;
                        } else if (mapNumLeft.get(child) > conversion) {
                            int prevConv = mapNumLeft.get(child);
                            String prevParent = mapLeft.get(child);
                            mapLeft.put(child, parent);
                            mapLeft.put(parent, prevParent);
                            mapNumLeft.put(child, conversion);
                            mapNumLeft.put(parent, prevConv / conversion);
                            mapRight.put(prevParent, parent);
                            mapRight.put(parent, child);
                            mapNumRight.put(prevParent, prevConv / conversion);
                            mapNumRight.put(parent, conversion);

                            break;
                        } else {

                            conversion /= mapNumLeft.get(child);

                            child = mapLeft.get(child);

                        }
                    }


                } else {
                    mapRight.put(parent, child);
                    mapNumRight.put(parent, conversion);
                    mapLeft.put(child, parent);
                    mapNumLeft.put(child, conversion);
                }

            }
            String head = "";
            for (String s : mapRight.keySet()) {
                if (!mapLeft.containsKey(s)) {
                    head = s;
                }
            }
            String parent = head;
            int num = mapNumRight.get(head);
            System.out.print("1");
            while (mapRight.containsKey(head)) {

                System.out.print(head + " = " + num);

                head = mapRight.get(head);
                if (mapNumRight.containsKey(head)) {
                    num *= mapNumRight.get(head);
                } else {
                    System.out.println(head);
                }
            }
        }
    }
}

