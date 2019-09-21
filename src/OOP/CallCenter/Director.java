package OOP.CallCenter;

public class Director extends Employee {
    private static final int DIRECTOR_RANK = 3;
    public Director(String name) {
        super(name, DIRECTOR_RANK);
    }

    @Override
    public int getRank() {
        return DIRECTOR_RANK;
    }
}
