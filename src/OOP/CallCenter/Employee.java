package OOP.CallCenter;

public abstract class Employee implements Comparable<Employee> {
    private int rank;
    private String name;
    private boolean done = false;

    public Employee(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {return this.name;}
    public boolean getDone() {return this.done;}
    public void setDone(boolean onCall) {this.done = done;}
    public abstract int getRank();

    @Override
    public int compareTo(Employee E) {
        return this.getRank() - E.getRank();
    }
}

