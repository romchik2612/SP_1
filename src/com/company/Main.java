package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FReader fReader = new FReader("src/resources/test.txt");
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Write command 1-13 or end");
            String next = input.next();
            if (next == "end") System.exit(0);
            new Commands(fReader.getWords(),Integer.parseInt(next));
        }
    }



}
