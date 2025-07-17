import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name!");
        String userName = sc.nextLine();
        System.out.println("Hello, " + userName + "!" );
    }
}