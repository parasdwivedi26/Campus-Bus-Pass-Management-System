package com.campusbuspass.util;

import java.util.Scanner;

public final class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {}

    public static String text(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    public static int integer(String prompt) {
        while (true) {
            try { return Integer.parseInt(text(prompt)); }
            catch (NumberFormatException e) { System.out.println("Enter a valid integer."); }
        }
    }

    public static double decimal(String prompt) {
        while (true) {
            try { return Double.parseDouble(text(prompt)); }
            catch (NumberFormatException e) { System.out.println("Enter a valid number."); }
        }
    }
}
