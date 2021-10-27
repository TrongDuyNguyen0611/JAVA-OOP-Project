package view;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duy
 */
public class Validation {

    public void menu(){
        System.out.println("1.Add employees");
        System.out.println("2.Update employees");
        System.out.println("3.Remove employees");
        System.out.println("4.Search employees");
        System.out.println("5.Sort employees by salary");
        System.out.println("6.Exit");
    }
    
    
    Scanner sc = new Scanner(System.in);
    public String getString(String mess,String error) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (!txt.trim().isEmpty()) {
                break;
            }else{
                System.out.println(error);
            }
        }
        return txt;
    }
    public String getStringSearch(String mess,String error) {
        String txt = "";
        System.out.print(mess);
        txt = sc.nextLine();
        return txt;
    }
    
    public int getChoice(String mess, int min, int max) {
        int number = 0;
        while (true) {
            try {
                System.out.print(mess);
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max) {
                    System.out.println("Choice within 1-5, please input again");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid number, please input again");
            }
        }
        return number;
    }
    
    //    Check dublicate ID
    public String CheckaddID(List<Employee> list){
      Validation v=new Validation();
        while(true){
            String id=v.getString("Enter ID:", "Invalid ID,please input again");
            int index=0;
            for (Employee o : list) {
                if(o.getId().equals(id)){
                index=1;
                break;
                }
            }       
        if(index==0){
            return id;
        }else{
            System.out.println("ID exit,Please input again!");
            }
        }
    }
    
    public String CheckupdateID(List<Employee> list){
      Validation v=new Validation();
        while(true){
            String id=v.getString("Enter ID:", "Invalid ID,please input again");
            int index=0;
            for (Employee o : list) {
                if(o.getId().equals(id)){
                index=1;
                break;
                }
            }       
        if(index==1){
            return id;
        }else{
            System.out.println("ID not exit,Please input again!");
            }
        }
    }
  
    public String getGender(String mess,String error) {
        String txt = "";
        while (true) {
            System.out.print(mess);
            txt = sc.nextLine();
            if (txt.trim().equalsIgnoreCase("Male")||txt.trim().equalsIgnoreCase("Female")) {
                break;
            }else{
                System.out.println(error);
            }
        }
        return txt;
    }
    
    public Date getDate(String mess, String error){
        Date date = null;
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        while(true){
            try{
                System.out.println(mess);
                date=df.parse(sc.nextLine());
                break;
            }catch(Exception e){
                System.out.println(error);
            }
        }
        return date;
    }
    
      public double getSalary(String mess,String error) {
        double number = 0;
        while (true) {
            try {
                System.out.print(mess);
                number = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
        return number;
    }
    
    
}
