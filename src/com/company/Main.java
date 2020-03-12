package com.company;

import com.company.view.ConsoleOutput;

public class Main {

    static int colorChangesCounter = 0;

    public static void main(String[] args) {

        System.out.println("1- 3 colors\n2- 2 colors");

        ConsoleOutput consoleOutput = new ConsoleOutput();
        String buttonPressedForLightsAmount = consoleOutput.changeColorButtonPressed();

        int lightsAmount = 0;

        if (buttonPressedForLightsAmount.equals("1")) {
            lightsAmount = 3;
        } else if(buttonPressedForLightsAmount.equals("2")) {
            lightsAmount = 2;
        }
        while(true) {
            System.out.println("\n1-Change colors\n2-Night mode");
            String buttonPressedForChangeColor = consoleOutput.changeColorButtonPressed();

            if (buttonPressedForChangeColor.equals("1")) {
                if (colorChangesCounter % 2 == 0) {
                    switchColors(lightsAmount);
                } else {
                    reversedSwitch(lightsAmount);
                }

            } else if (buttonPressedForChangeColor.equals("2")) {
                while("".equals(consoleOutput.changeColorButtonPressed())) {
                    nightMode(lightsAmount);
                }

            }
        }

    }

    private static void switchColors(int lightsAmount) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        greenLight(consoleOutput, lightsAmount);

        if (lightsAmount != 2) {
            yellowLight(consoleOutput, lightsAmount);
        }

        redLight(consoleOutput, lightsAmount);
        colorChangesCounter += 1;
    }

    private static void reversedSwitch(int lightsAmount) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        redLight(consoleOutput, lightsAmount);

        if (lightsAmount != 2) {
            yellowLight(consoleOutput, lightsAmount);
        }
        consoleOutput.showTrafficLight("green", lightsAmount);
        colorChangesCounter += 1;
    }

    private static void nightMode(int lightsAmount) {
        if(lightsAmount >= 3) {
            ConsoleOutput consoleOutput = new ConsoleOutput();
            consoleOutput.showTrafficLight("yellow", lightsAmount);
            makeDelay(1500);
            consoleOutput.showTrafficLight("off", lightsAmount);
            makeDelay(1500);
        } else {
            System.out.println("There are no yellow light");
        }
    }

    private static void greenLight(ConsoleOutput consoleOutput, int lightsAmount) {
        for (int i = 0; i < 2; i++) {
            consoleOutput.showTrafficLight("green", lightsAmount);
            makeDelay(1000);
            consoleOutput.showTrafficLight("off", lightsAmount);
            makeDelay(1000);
        }
    }

    private static void yellowLight(ConsoleOutput consoleOutput, int lightsAmount) {
        consoleOutput.showTrafficLight("yellow", lightsAmount);
        makeDelay(1000);
    }

    private static void redLight(ConsoleOutput consoleOutput, int lightsAmount) {
        consoleOutput.showTrafficLight("red", lightsAmount);
        makeDelay(1000);
    }

    private static void makeDelay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
