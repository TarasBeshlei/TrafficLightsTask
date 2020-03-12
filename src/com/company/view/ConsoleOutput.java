package com.company.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class ConsoleOutput {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void showTrafficLight (String color, int lightsAmount) {

        String dot = "⬤";
        String dot2 = "⬤";

        if (lightsAmount == 2) {
            dot2 = "";
        }

        Writer writer = new PrintWriter(System.out);

            try {
                String str = "⬤";
                writer.write(str);
                writer.flush();

                switch (color) {
                    case ("green"):
                        writer.write("\r" + ANSI_GREEN + "⬤" + ANSI_RESET + dot + dot2);
                        break;
                    case ("yellow"):
                        writer.write("\r" + "⬤" + ANSI_YELLOW + "⬤" + ANSI_RESET + "⬤");
                        break;
                    case ("red"):
                        writer.write("\r" + dot + dot2 + ANSI_RED + "⬤" + ANSI_RESET);
                        break;
                    case ("off"):
                        writer.write("\r" + "⬤⬤" + dot2 + ANSI_RESET);
                        break;
                }

                writer.flush();

            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String changeColorButtonPressed() {
        Scanner keyboard = new Scanner(System.in);
        String keyPressed = null;
        while (keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
            if(input != null) {

                if ("1".equals(input) | "2".equals(input) | "".equals(input)) {
                    keyPressed = input;
                    return keyPressed;
                } else {
                    System.out.println("Select the option");
                }
            }
        }
        keyboard.close();
        return keyPressed;
    }
}
