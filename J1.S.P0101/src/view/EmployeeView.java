package view;

import controller.EmployeeController;
import view.Validation;
import model.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duy
 */
public class EmployeeView {
        EmployeeController Controller=new EmployeeController();
        Validation v=new Validation();
    
//  Add Employee by ID
    public void addEmployee(List<Employee> list){
        String id=v.CheckaddID(list);
        String fname=v.getString("Enter frist name: ","Invalid frist name,please input again !");
        String lname=v.getString("Enter last name: ","Invalid last name,please input again !");
        String phone=v.getString("Enter phone : ","Invalid phone,please input again !");
        String  email=v.getString("Enter email: ","Invalid email,please input again !");
        String address=v.getString("Enter address: ","Invalid address,please input again !");
        Date date=v.getDate("Enter date(dd-MM-yyyy): ","Invalid date,please input again !");
        String gender=v.getGender("Enter gender(Male or Female): ","Invalid gender,please input again !");
        double salary=v.getSalary("Enter salary: ","Invalid salary:,please input again !");
        String egency=v.getString("Enter egency: ","Invalid egency:,please input again !");
        Employee em=new Employee(id, fname, lname, phone, email, address, date, gender, salary, egency);
        Controller.addemployee(list, em);
        for (Employee o : list) {
            System.out.println(o);
        }
    }
    
//  Remove Employee by ID
    public void removeEmployee(List<Employee> list){
        Validation v=new Validation();
        String searchID=v.getString("Enter ID: ","Invalid ID,please input again !");
        Controller.removeEmployee(list, searchID);
        for (Employee o : list) {
            System.out.println(o);
        }
    }

    public void updateEmployee(List<Employee> list){
        Scanner sc=new Scanner(System.in);
        String id=v.CheckupdateID(list);
        for (Employee o : list) {
            if(o.getId().equals(id)){
                System.out.println("Choise one option update:");
                System.out.println("'All':Update all  "+"'Fn':Frist name"+"  "+"'Ln':Last name"+"  "+"'P':phone"+"  "+"'E':Email"+"  "+"'Ad':address"+"  "+"'D':date"+"  "+"'G':gender"+"  "+"'S':salary"+"  "+"'Eg':egency");
                while(true){
                System.out.print("Your option:");
                String option=sc.nextLine();            
                 switch(option){
                        case "Fn":
                            String fname=v.getString("Enter frist name: ","Invalid frist name,please input again !");
                            o.setFirstName(fname);
                            break;
                        case "Ln":
                            String lname=v.getString("Enter last name: ","Invalid last name,please input again !");
                            o.setLastName(lname);
                            break ;
                        case "P": 
                            String phone=v.getString("Enter phone : ","Invalid phone,please input again !");
                            o.setPhone(phone);
                            break;
                        case "E": 
                            String  email=v.getString("Enter email: ","Invalid email,please input again !");
                            o.setEmail(email);
                            break;
                        case "Ad":
                            String address=v.getString("Enter address: ","Invalid address,please input again !");
                            o.setAddress(address);
                            break;
                        case "D":
                             Date date=v.getDate("Enter date(dd-MM-yyyy): ","Invalid date,please input again !");
                            o.setDob(date);
                            break;
                        case "G":
                            String gender=v.getGender("Enter gender(Male or Female): ","Invalid gender,please input again !");
                             o.setGender(gender);
                            break;
                        case "S":
                             double salary=v.getSalary("Enter salary: ","Invalid salary:,please input again !");
                             o.setSalary(salary);
                            break;
                        case "Eg":
                            String egency=v.getString("Enter egency: ","Invalid egency:,please input again !");
                            o.setEgency(egency);
                            break;
                        case "All":
                            fname=v.getString("Enter frist name: ","Invalid frist name,please input again !");
                            o.setFirstName(fname);
                            lname=v.getString("Enter last name: ","Invalid last name,please input again !");
                            o.setFirstName(lname);
                            phone=v.getString("Enter phone : ","Invalid phone,please input again !");
                            o.setPhone(phone);
                            email=v.getString("Enter email: ","Invalid email,please input again !");
                            o.setEmail(email);
                            address=v.getString("Enter address: ","Invalid address,please input again !");
                            o.setAddress(address);
                            date=v.getDate("Enter date(dd-MM-yyyy): ","Invalid date,please input again !");
                            o.setDob(date);
                            gender=v.getGender("Enter gender(Male or Female): ","Invalid gender,please input again !");
                            o.setGender(gender);
                            salary=v.getSalary("Enter salary: ","Invalid salary:,please input again !");
                            o.setSalary(salary);
                            egency=v.getString("Enter egency: ","Invalid egency:,please input again !");
                            o.setEgency(egency);
                            break;
                    }
                break;
                }   
            }
        }
        for (Employee o : list) {
            System.out.println(o);
        }
    }
    
    
//    Search ID by name
    public void searchEmployee(List<Employee> list){
        String searchName=v.getStringSearch("Enter Name: ","Invalid Name,please input again !");
        if (searchName.isEmpty()){
            for (Employee o : list) {
                System.out.println(o);
            }
        }
        int index=0;
        Controller.searchEmployee(list,searchName,index);
        if(index!=0){
            System.out.println("Name not found!");
        }else{
            System.out.println("Name exits!");
        }
    }
    
    
//    Sort employees by salary
    public void sortEmployee(List<Employee> list){
         Controller.sortEmployee(list);
        for (Employee o : list) {
            System.out.println(o);
        }
    }
    
       
}
