package OOP.CallCenter;


public class Respondent extends Employee {
    private static final int RESPONDENT_RANK = 1;
    public Respondent(String name) {
        super(name, RESPONDENT_RANK);
    }

    @Override
    public int getRank() {
        return RESPONDENT_RANK;
    }
}
