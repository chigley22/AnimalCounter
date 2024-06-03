package model;

public class Sheep extends Animal implements Countable {

    public Sheep() {
        this.count = 0;
    }

    @Override
    public void incrementCount() {
        count += 2;
        System.out.println("Added two sheep. Current count: " + count);
    }
}
