/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import model.Employee;

/**
 *
 * @author duy
 */
public class EmployeeController {
    
    
    private static final List<Employee> listEmployee = new ArrayList<>();
    
    public void addemployee(List<Employee> list,Employee em){
        list.add(em);
    }
    
    public void  removeEmployee(List<Employee> list,String searchID){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(searchID)){
                list.remove(i);
            }
        }
    }
    
    public void searchEmployee(List<Employee> list,String searchName,int index){
        for (Employee o : list) {
            String FullName=o.getFirstName()+""+o.getLastName();
            if(FullName.toLowerCase().contains(searchName.toLowerCase())){
                System.out.println(o);
                index++;
            }
        }
    }
    
    public void sortEmployee(List<Employee> list){
          Collections.sort(list,new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                if(o1.getSalary()>o2.getSalary())
                return 1;
                if(o1.getSalary()<o2.getSalary())
                return -1;
                else{
                return 0;
                }
            }    
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
