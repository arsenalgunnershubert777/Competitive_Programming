package UFPT;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Periodic_Strings {
    public static void main(String[] args) throws java.io.IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s=sc.readLine())!=null) {


            int count = 0;
            boolean periodic;


            ArrayList<Character> check = new ArrayList<>();
            ArrayList<Character> backup = new ArrayList<>();
            int size = s.length();
            while(count < size) {
                char c = s.charAt(count);
                if (count != 0 && c == s.charAt(count - 1)) {

                    periodic = true;
                    while (periodic && count < size) {


                        /*String s1 = Check.substring(0, Check.length() - 1);
                        Check.delete(0, Check.length() - 1);
                        Check.append(s1);*/
                        char last = check.remove(check.size()-1);
                        check.add(0, last);

                        for (int i = 0; i < check.size(); i++) {
                            if (count == size) {
                                check.clear();
                                check.addAll(backup);
                                periodic = false;
                                break;
                            }
                            else {

                                if (s.charAt(count) != check.get(i)) {
                                    periodic = false;
                                    check.clear();
                                    check.addAll(backup);
                                    check.remove(check.size()-1);
                                    //Check.delete(0, Check.length());
                                    //Check.append(Backup.substring(0,Backup.length()-1));
                                    count--;
                                    break;
                                }
                                else {
                                    backup.add(s.charAt(count));

                                    count++;
                                }


                            }
                        }

                    }


                }
                else {

                    check.add(c);
                    backup.add(c);
                   // Check.append(s.charAt(count));
                    //Backup.append(s.charAt(count));

                    count++;
                }


            }
            System.out.println(check.size());
        }
    }
}
