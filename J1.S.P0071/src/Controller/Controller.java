/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Task;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Admin
 */
public class Controller extends ArrayList<Task> implements IController{
    
//f1
    //tu dong them id = id cuoi + 1
    public String setID(){
        try{
            int i = Integer.parseInt(get(size()-1).getID());//lay id cuoi
            return i+1 +"";// cong them 1 roi chuyen ve string
        }catch(Exception e){
            return "0"; // truong hop mang trong
        }
    }
    // Them task
    @Override
    public int addTask(String requirementName, String assignee, String reviewer, String taskID, String Date, double planFrom, double planTo) throws Exception {
            String id = setID();
            if(isEmpty()) id = "0";
            Task t = new Task(id,requirementName,taskID,Date,planFrom,planTo,assignee,reviewer);
            this.add(t);
            return Integer.parseInt(id);
    }
    //f2
    //tim index cua ID
    public int findID(String ID){
        int i = 0;
        for(Task o:this){
            if(o.getID().equalsIgnoreCase(ID)) return i;
            else i++;
        }
        return -1;
    }
    //lay task theo id
    public Task getTask(String ID){
        for(Task o:this){
            if(o.getID().equalsIgnoreCase(ID)) 
                return o;
        }
        return null;
    }
    @Override
    //update task
    public void updateTask(String ID, String requirementName, String assignee, String reviewer, String taskID, String Date, double planFrom, double planTo) throws Exception {
        try{
            int i = findID(ID);
            if(i == -1) return;
            get(i).setName(requirementName);
            get(i).setTaskID(taskID);
            get(i).setDate(Date);
            get(i).setPlanFrom(planFrom);
            get(i).setPlanTo(planTo);
            get(i).setAssignee(assignee);
            get(i).setReviewer(reviewer);
        }catch(Exception e){
            throw e;
        }
    }
    @Override
    //xoa task theo id
    public void deleteTask(String id) throws Exception {
        try{
            for(Task o:this)
                if(o.getID().equalsIgnoreCase(id)){
                    remove(o);
                    break;
                }
        }catch(Exception e){
            throw e;
        }
    
    }
    @Override
    //lay ra danh sach task duoc sap xep theo id
    public ArrayList<Task> getDataTasks() {
        ArrayList<Task> T = new ArrayList<>();
        for(Task o:this)
            T.add(o);
        Collections.sort(T,new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.getID().compareTo(o1.getID());
            }
        } );
        return T;
    }
    
    
}
