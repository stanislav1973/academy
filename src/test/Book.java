package test;

import java.util.List;
import java.util.Vector;

public class Book {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new Vector<>();
        Thread thread = new Thread(() -> addNumbers(numbers));
        thread.start();
        //thread.join();
        addNumbers(numbers);
        System.out.println(numbers.size()); // < 200_000
    }

    private static  void  addNumbers(List<Integer> numbers) {
        for (int i = 0; i < 100_000; ++i) {
            numbers.add(i);
        }
    }
    }

