package org.example;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Hello world!
 *
 */
public class App
{

    public void convertString(String s){
        try {
            if(!s.isEmpty()){
                StringBuffer sb = new StringBuffer(s);
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if(i%2 == 0)
                        sb.setCharAt(i, Character.toLowerCase(c));
                    else
                        sb.setCharAt(i, Character.toUpperCase(c));
                }
                System.out.println(s.toUpperCase());
                System.out.println(sb);
            }
            else{
                System.err.println("String should not be empty!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void createCSV(String s, String filePathWithName){
        try {
            if(!s.isEmpty()) {
                if(filePathWithName.toLowerCase().endsWith(".csv")){
                    File oututFile = new File(filePathWithName);
                    StringJoiner intStringJoiner = new StringJoiner(",");
                    Arrays.stream(s.chars().toArray())
                            .mapToObj(intValue -> String.valueOf((char) intValue))
                            .forEach(intStringJoiner::add);
                    String joined = intStringJoiner.toString();
                    FileWriter myWriter = new FileWriter(oututFile);
                    myWriter.write(joined);
                    myWriter.close();
                    System.out.println("CSV created!");
                }
                else{
                    System.err.println("File format should be .csv !");
                }
            }
            else{
                System.err.println("String should not be empty!");
            }
        } catch (Exception e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inStr = "hello world";
        App obj = new App();
        obj.convertString(args[0]);
        obj.createCSV(args[0], args[1]);

    }
}
