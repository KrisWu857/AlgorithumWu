package com.Exception;

import java.util.Scanner;

public class LaoDa {
    public static void main(String[] args) {
        while (true) {
            System.out.print("input one to revive kb:");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();

            if (a == 1) {
                System.out.println("I am welcome !");
            } else {
                System.out.println("it,s not funny");
            }
        }
    }

}
