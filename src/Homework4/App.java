package Homework4;

import java.util.Scanner;

public class App {
    public int selectUser = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TV device1 = new TV("Samsung", "SuperTV 6", 43, true);
        TV device2 = new TV("Toshiba", "MiddleOne", 17, false);

//        int userSelectTV = -1;
//        do {
//            System.out.println("Hello! Choose a TV: \n1." + TV.getTVName(device1) + "\r\n2." + TV.getTVName(device2));
//            userSelectTV = sc.nextInt();
//        }while (userSelectTV > 0 && userSelectTV < 3);
//        TV sectedTV = selectUser(userSelectTV, device1, device2);
        System.out.println("You watch: " + TV.getTVName(device1));
        System.out.println("You can:\r\nP - turn on or off\r\n(+ -) - change volume\r\nor enter a number to select a channel");
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
                default -> device.changeChannel(variable);
            };
    }

//    private static TV selectUser(int selectUser, TV device1, TV device2){
//        return switch (selectUser){
//            case 1 -> device1;
//            case 2 -> device2;
//            default -> device1;
//        };
//    }
}
