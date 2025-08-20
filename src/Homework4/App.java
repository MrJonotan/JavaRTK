package Homework4;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TV device1 = new TV("Samsung", "SuperTV 6", 43, true);
        TV device2 = new TV("Toshiba", "MiddleOne", 17, false);
        System.out.println("You watch: " + TV.getTVName(device1));
        System.out.println("You can:\r\nP - turn off\r\n(+ -) - change volume\r\ns- get information about TV\r\nor enter a number to select a channel");
        availableFunctions(device1);
    }

    private static void availableFunctions(TV device) {
        Scanner sc = new Scanner(System.in);
        String remoteControlCommand = sc.next();
        while (!remoteControlCommand.equals("P")){
            String result = remoteControlFunctions(remoteControlCommand, device);
            System.out.print(result);
            availableFunctions(device);
        }
    }

    private static String remoteControlFunctions(String variable, TV device){
        return switch (variable) {
            case "P" -> device.power();
            case "+" -> device.changeVolume("+");
            case "-" -> device.changeVolume("-");
            case "s" -> TV.getInfo(device);
            default -> device.changeChannel(variable);
        };
    }
}
