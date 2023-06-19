package ru.otus.spring.service;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;
@Service
public class IOServiceImpl implements IOService {
    private final PrintStream output;
    private final Scanner input;

    public IOServiceImpl() {
        output = System.out;
        input = new Scanner(System.in);
    }

    @Override
    public void outputString(String s){
        output.println(s);
    }

    @Override
    public int readInt(){
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public int readIntWithPrompt(String prompt){
        outputString(prompt);
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public String readStringWithPrompt(String prompt){
        outputString(prompt);
        return input.nextLine();
    }
}