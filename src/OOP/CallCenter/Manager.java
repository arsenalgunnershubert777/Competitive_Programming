package OOP.CallCenter;

public class Manager extends Employee {
    private static final int MANAGER_RANK = 2;
    public Manager(String name) {
        super(name, MANAGER_RANK);
    }

    @Override
    public int getRank() {
        return MANAGER_RANK;
    }
}
