/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Task;
import Validation.Validate;
import java.util.*;
/**
 *
 * @author Admin
 */
public class View {
    Controller ctrl = new Controller();

    public View() throws Exception {
        ctrl.addTask("Program", "Duy", "Lead", "1", "feb-06-2021", 8, 15);
        ctrl.addTask("Draw", "Hoang", "Lead", "2", "nov-11-2021", 7.5, 17);
        ctrl.addTask("Coder", "Duc", "Lead", "3", "jan-23-2021", 8, 14);
        ctrl.addTask("Program", "Tien", "Lead", "4", "jan-2-2021", 8, 13);
    }
    
    public void menu(){
        System.out.println("==============Task program==============");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Display Task");
        System.out.println("5. Exit");
    }
//    Chon option
    public void Option() throws Exception{
        int choice;
        do{
        menu();
        choice = Validate.getInt("Enter choice:", 1, 5);
        switch(choice){
            case 1:
                System.out.println("-------------------------------Add task-------------------------------");
                addtask();
                break;
            case 2:
                System.out.println("-----------------------------Update Task----------------------------");
                updatetask();
                break;
            case 3:
                System.out.println("-----------------------------Del Task-----------------------------");
                deleteTask();
                break;
            case 4:
                System.out.println("---------------------------- Task descending order-----------------------------------");
                ShowTask();
                break;
        }
        }while(choice != 5);
    }
//    Them task
    public void addtask() throws Exception {
        String requirementName, assignee,reviewer, taskID, Date;
        double planFrom, planTo;
        requirementName = Validate.getString("Requirement Name: ", false, "^[A-Za-z ]+");
        taskID = Validate.getString("Task Type: ", false, "[1-4]");
        Date = Validate.getDate("Date:","");
        planFrom = Validate.getDouble("From: ",8, 17,"");
        planTo = Validate.getDouble("To:", planFrom + 0.5, 17.5,"");
        assignee = Validate.getString("Assignee: ", false, "^[A-Za-z ]+");
        reviewer = Validate.getString("Reviewer: ", false, "^[A-Za-z ]+");
        ctrl.addTask(requirementName, assignee, reviewer, taskID, Date, planFrom, planTo);
        System.out.println("Add Successfully !");
    }
    
//    Update task
    public void updatetask(){
        if(ctrl.isEmpty()) System.out.println("List is empty!");
        else{
            try{
                String ID,requirementName, assignee,reviewer, taskID, Date;
                double planFrom, planTo;
                Task t ;
                do{
                    ID = Validate.getStringID("Requirement ID:",false, "");
                    t = ctrl.getTask(ID);
                    if(t == null) System.out.println("code does not exist");
                }while(t == null);

                requirementName = Validate.getString("Requirement Name: ", false, "^[A-Za-z ]+");
                if(requirementName.equalsIgnoreCase("nope")){
                    requirementName = t.getName();
                }
                taskID = Validate.getString("Task Type: ", false, "[1-4]|nope|Nope");
                if(taskID.equalsIgnoreCase("nope")){
                    taskID = t.getTaskID();
                }
                Date = Validate.getDate("Date:","Nope|nope");
                if(Date.equalsIgnoreCase("nope")){
                    Date = t.getDate();
                }
                planFrom = Validate.getDouble("From: ",8, 17,"nope|Nope");
                if(planFrom == 0){
                    planFrom = t.getPlanFrom();
                }
                    do{
                        planTo = Validate.getDouble("To:", planFrom + 0.5, 17.5,"nope|Nope");
                        if(planTo == 0){
                             planTo = t.getPlanTo();
                        }
                }while(planTo == 0||planTo==planFrom|| planTo < planFrom);
                assignee = Validate.getString("Assignee: ", false, "^[A-Za-z ]+");
                if(assignee.equalsIgnoreCase("nope")){
                    assignee = t.getAssignee();
                }
                reviewer = Validate.getString("Reviewer: ", false, "^[A-Za-z ]+");
                if(reviewer.equalsIgnoreCase("nope")){
                    reviewer = t.getReviewer();
                }
                ctrl.updateTask(ID, requirementName, assignee, reviewer, taskID, Date, planFrom, planTo);
                System.out.println("Update Successfully !");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
    }
}
    public void deleteTask(){
        if(ctrl.isEmpty()) System.out.println("List is empty!");
        else{
            try{
                String ID;
                do{
                    ID = Validate.getStringID("Requirement ID:",false, "");
                    if(ID.isEmpty()){
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
                        for(Task o:ctrl.getDataTasks()){
                            System.out.println(o);
                            }
                            break;
                    }
                }while(ctrl.findID(ID)==-1);
                    ctrl.deleteTask(ID);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        
    }
    public void ShowTask(){
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        for(Task o:ctrl.getDataTasks()){
            System.out.println(o);
        }
    }
    
}
