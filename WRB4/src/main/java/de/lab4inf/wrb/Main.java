package de.lab4inf.wrb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
    	WRBScript script = new WRBScript();
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print(">");
                String s = br.readLine();
 
                //System.out.println(script.parse(s));
                script.parse(s);

            } catch (Exception exception) {
                System.out.println(exception.toString());
                exception.printStackTrace();
            }
        }
    }
}