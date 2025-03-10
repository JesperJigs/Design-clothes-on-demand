package View;

import java.util.Scanner;

public class PrintView {

    Scanner scanner = new Scanner(System.in);


    public void display(String message) {
        System.out.println(message);
    }

    public String customerInput(String input){
        System.out.println(input);
        return scanner.nextLine();
    }
}
