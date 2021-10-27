/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class Task {
    String ID;
    String Name;
    String TaskTypeID;
    String Date;
    double planTo;
    double planFrom;
    String Assignee;
    String Reviewer;
    static int count = 0;
    public Task() {
        
    }

    public Task(String id, String Name, String TaskTypeID, String Date, double planFrom, double planTo, String Assignee, String Reviewer) {
        ID = id;
        this.Name = Name;
        this.TaskTypeID = TaskTypeID;
        this.Date = Date;
        this.planTo = planTo;
        this.planFrom = planFrom;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Task.count = count;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTaskID() {
        return TaskTypeID;
    }

    public void setTaskID(String TaskID) {
        this.TaskTypeID = TaskID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(Double planTo) {
        this.planTo = planTo;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double PlanFrom) {
        this.planFrom = PlanFrom;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }
    
    public String transCode(String code){
        switch(code){
            case "1": return "Code" ;
            case "2": return "Test";
            case "3": return "Design";
            case "4": return "Review";
            default:return null;
        }
    }
    public String changeDate(String a){
        String[] tokens = a.split("-");
        return tokens[1] +"-"+tokens[0]+"-"+tokens[2];
    }
    public String toString(){
        return String.format("%-20s%-20s%-20s%-20s%-20.1f%-20s%-20s",ID,Name,transCode(TaskTypeID),changeDate(Date),(planTo-planFrom),Assignee,Reviewer);
    }
    
    
   
}
