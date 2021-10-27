
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Validation {
    public static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg){
        int i = 0;
        boolean loop = true;
        do
        {
            System.out.print(msg);
            try
            {
                i = Integer.parseInt(sc.nextLine());
                loop = false;
            }
            catch(NumberFormatException e)
            {
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
    
    public static double getDouble(String msg, double min, double max) {
        String result;

        while (true) {
            try {
                System.out.format("%s (%.2f - %.2f):", msg, min, max);
                result = sc.nextLine().trim();
                if (result.replaceAll("\\.", "").matches("\\d+")) {
                    if (min > Double.parseDouble(result) || max < Double.parseDouble(result)) {
                        continue;
                    }
                    return Double.parseDouble(result);
                }
                
            } catch (NumberFormatException e) {
                
            }
        }
    }
}
