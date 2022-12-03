package com.info;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> allNumbers = createTenThousandList();

        Number n1 = new Number("10000 Numbers", allNumbers);

        ExecutorService pool = Executors.newFixedThreadPool(6);
        pool.execute(n1);

        pool.shutdown();
    }

    static ArrayList<Integer> createTenThousandList() {
        int i = 1;
        ArrayList<Integer> numbers = new ArrayList<>();

        while (i <= 10000) {
            numbers.add(i);
            i++;
        }

        return numbers;
    }
}
