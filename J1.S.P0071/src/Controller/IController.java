/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IController {
    public int addTask(String requirementName,String assignee,String reviewer,String taskID,String Date,double planFrom,double planTo) throws Exception;
    public void updateTask(String ID,String requirementName,String assignee,String reviewer,String taskID,String Date,double planFrom,double planTo) throws Exception;
    public void deleteTask (String id) throws Exception;
    public ArrayList<Task> getDataTasks();
}
