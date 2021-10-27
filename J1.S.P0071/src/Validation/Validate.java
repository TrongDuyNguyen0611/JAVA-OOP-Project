/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validate {
    public static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg, int min, int max){
        int i = 0;
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                i = Integer.parseInt(sc.nextLine());
                if(i >= min && i <= max)
                    loop = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println(e.toString());
            }
        }while(loop);
        
        return i;
    }
    
    public static String getString(String msg, boolean isEmpty, String pattern){
        String line = null;
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            if(line.isEmpty() && !isEmpty){
                System.out.println("Please do not enter emtpy!");
                continue;
            }
                
            else
            {
                if(pattern.isEmpty()) break;
                else if(line.matches(pattern)){              
                    break;
                }
                continue;
            }
        }while(true);
        line = line.trim().replaceAll("\\s+", " ");
        return line;
    }
    
    public static double getDouble(String msg, double min, double max,String pattern) {
        String input;

        while (true) {
            try {
                System.out.format("%s (%.2f - %.2f):", msg, min, max);
                input = sc.nextLine().trim();
                if(input.matches(pattern)&& !pattern.isEmpty()){
                    return 0;
                }
                double result = Double.parseDouble(input);
                if (min > result || max < result || result % 0.5 != 0) {
                    continue;
                    }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());;
            }
        }
    }
     public static String getDate( String msg,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy");
        dateFormat.setLenient(false);
        String Line ="";
        Date date;
        int year;
        do{
            System.out.print(msg);
            Line = sc.nextLine();
            if(Line.matches(pattern)&&!pattern.isEmpty())
                return Line;
            try{
                date = dateFormat.parse(Line);
                year = Integer.parseInt(Line.split("-")[2]);
                if(year> 2021 || year < 2000) continue;
                break;
            }catch(Exception ex){
                continue;
            }
        }while(true);
        return dateFormat.format(date);
     }
      public static String getStringID(String msg, boolean isEmpty, String pattern){
        String line = null;
        do
        {
            System.out.print(msg);
            line = sc.nextLine();
            if(line.isEmpty() && !isEmpty){
                break;
            }
                
            else
            {
                if(pattern.isEmpty()) break;
                else if(line.matches(pattern)){              
                    break;
                }
                continue;
            }
        }while(true);
        line = line.trim().replaceAll("\\s+", " ");
        return line;
    }
     
    
}
