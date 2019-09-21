package OOP.CallCenter;
import java.util.*;
public class CallCenter {
    private ArrayList<Call> Calls =new ArrayList<>();
    private PriorityQueue<Employee> Employees = new PriorityQueue<>();
    private HashMap<Call, Employee> Handling = new HashMap<>();
    private CallCenter() {

    }
    private static CallCenter instance = null;
    public static CallCenter getCallCenter() {
        if (instance == null) {
            return new CallCenter();

        }
        else {
            return instance;
        }
    }
    public void addCall(Call call) {
        Calls.add(call);
    }
    public void addEmployee(Employee E) {
        Employees.add(E);
    }

    public void update() {
        //make matches
        for (Call c : Calls) {

            Employee E = Employees.poll();
            while (E.getDone()) {
                if (!Employees.isEmpty()) {
                    E = Employees.poll();
                }
                else {
                    System.out.println("Ran out of available call handlers! Please wait.");
                    return;
                }
            }
            Handling.put(c, E);
            System.out.println(c.getNumber() + " " + E.getName() + " " + E.getRank());

        }

        //update callers that are done
        for (Call c: Handling.keySet()) {
            if (c.getDone() == true) {
                Employees.add(Handling.get(c));
                Handling.remove(c);
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Employee> emps = new ArrayList<>();
        for (int i = 0; i <  10; i++) {
            int randomNum = new Random().nextInt(3)+1;
            Employee E;
            switch (randomNum) {
                case 1:
                    E = new Respondent("R" + i + "");
                    break;
                case 2:
                    E = new Manager("M" + i + "");
                    break;
                case 3:
                    E = new Director("D" + i + "");
                    break;
                default:
                    E = new Respondent("R" + i + "");
                    break;
            }
            emps.add(E);
        }
        ArrayList<Call> calls =  new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            calls.add(new Call(i));
        }

        CallCenter center = CallCenter.getCallCenter();

        for (int i = 0; i < 10; i++) {
            center.addCall(calls.get(i));
            center.addEmployee(emps.get(i));

        }
        center.update();

    }
}



