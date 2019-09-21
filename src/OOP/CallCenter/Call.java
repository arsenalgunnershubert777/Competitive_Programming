package OOP.CallCenter;

public class Call {
    private int number;
    private boolean done = false;
    public Call(int number) {
        this.number = number;
    }
    public int getNumber() {return this.number;}
    public boolean getDone() {
        return this.done;
    }
    public boolean setDone(boolean done) {
        return this.done = done;
    }
}
