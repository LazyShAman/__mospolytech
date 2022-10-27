//package com.company;
import java.util.Scanner;

public class for4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        float price = in.nextFloat();
        float R = 0;

        for (int i = 1; i <= 10; i++) {
            R = price * (float)(i);
            System.out.println(R);
        }
    }
}