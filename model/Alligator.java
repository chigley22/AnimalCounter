package model;

public class Alligator extends Animal implements Countable {

    public Alligator() {
        this.count = 0;
    }

    @Override
    public void incrementCount() {
        count += 1;
        System.out.println("Added an alligator. Current count: " + count);
    }
}

