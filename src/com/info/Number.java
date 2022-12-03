package com.info;

import java.util.ArrayList;

public class Number implements Runnable {

    private String name;
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> first = new ArrayList<>();
    private ArrayList<Integer> second = new ArrayList<>();
    private ArrayList<Integer> third = new ArrayList<>();
    private ArrayList<Integer> fourth = new ArrayList<>();
    private ArrayList<Integer> evenNumbers = new ArrayList<>();
    private ArrayList<Integer> oddNumbers = new ArrayList<>();

    public Number(String name, ArrayList<Integer> numbers) {
        this.name = name;
        this.numbers = numbers;
        createNumberLists();
    }

    @Override
    public void run() {
        try {
            calculate(this.getFirst());
            Thread.sleep(1000);

            calculate(this.getSecond());
            Thread.sleep(1000);

            calculate(this.getThird());
            Thread.sleep(1000);

            calculate(this.getFourth());
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void calculate(ArrayList<Integer> numbers) {
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evens.add(number);
            } else {
                odds.add(number);
            }
        }

        this.setEvenNumbers(evens);
        this.setOddNumbers(odds);
    }

    void createNumberLists() {
        for (Integer i : this.getNumbers()) {
            if (i < 2500)
                this.getFirst().add(i);
            else if (i < 5000)
                this.getSecond().add(i);
            else if (i < 7500)
                this.getThird().add(i);
            else
                this.getFourth().add(i);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getFirst() {
        return first;
    }

    public void setFirst(ArrayList<Integer> first) {
        this.first = first;
    }

    public ArrayList<Integer> getSecond() {
        return second;
    }

    public void setSecond(ArrayList<Integer> second) {
        this.second = second;
    }

    public ArrayList<Integer> getThird() {
        return third;
    }

    public void setThird(ArrayList<Integer> third) {
        this.third = third;
    }

    public ArrayList<Integer> getFourth() {
        return fourth;
    }

    public void setFourth(ArrayList<Integer> fourth) {
        this.fourth = fourth;
    }

    public ArrayList<Integer> getEvenNumbers() {
        return evenNumbers;
    }

    public void setEvenNumbers(ArrayList<Integer> evenNumbers) {
        this.evenNumbers = evenNumbers;
    }

    public ArrayList<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public void setOddNumbers(ArrayList<Integer> oddNumbers) {
        this.oddNumbers = oddNumbers;
    }
}
