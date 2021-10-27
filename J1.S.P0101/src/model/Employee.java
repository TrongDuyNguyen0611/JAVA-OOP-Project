package model;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duy
 */
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private Date dob;
    private String gender;
    private double salary;
    private String egency;

    public Employee() {
    }
    
    public Employee(String id, String firstName, String lastName, String phone, String email, String address, Date dob, String gender, double salary, String egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.salary = salary;
        this.egency = egency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return egency;
    }

    public void setEgency(String egency) {
        this.egency = egency;
    }
    
    public String formatdate(){
        String date="";
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        return df.format(dob);
    }
    
    public int compareTo(Employee o) {
        if (this.salary < o.salary) {
            return -1;
        } else if (this.salary > o.salary) {
            return 1;
        } else {
            return 0;

        }
    } 
    @Override
    public String toString() {
        return    id + "\t" + firstName + "\t" + lastName + "\t" + phone + "\t" + email + "\t" + address + "\t   " + formatdate() + "  \t " + gender + "\t" + salary + "  \t " + egency ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
    
 