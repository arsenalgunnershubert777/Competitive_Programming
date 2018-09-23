package Testing;

public class Shortcuts {
    public static void main(String[] args) {
        int index = -1;
        int n = 5;
        while (true) {
            index = (index + n - 1) % n;
            System.out.println(index);
        }

    }
}
