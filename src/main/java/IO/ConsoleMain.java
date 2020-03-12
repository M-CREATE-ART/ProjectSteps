package IO;

import java.util.Scanner;

public class ConsoleMain implements Console {
    private Scanner sc = new Scanner(System.in);


    @Override
    public void print(String line) {

    }

    @Override
    public void printLn(String line) {
        System.out.print(line);
    }

    @Override
    public String readLn() {
        return sc.nextLine();
    }
}
