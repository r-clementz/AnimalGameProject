package com.animalgame;

import java.util.Scanner;

public class Helper {

    Scanner console = new Scanner(System.in);

    public void createMenu(String ...menuChoice) {
        int counter = 1;
        System.out.println("Please enter the number representing your choice: ");
        System.out.println("*".repeat(50));
        System.out.println(" ");
        for (String choice : menuChoice) {
            System.out.print(counter + ". " + choice +"\n");
            counter ++;
        }
        System.out.println(" ");
        System.out.println("*".repeat(50));
    }

    public void clear() {
        System.out.println("\n".repeat(50));
    }

    public void validateInput () {
        while (!console.hasNextInt()) {
            System.out.println("Invalid input. Please choose a number from the menu.");
            console.next();
        }
    }


}
