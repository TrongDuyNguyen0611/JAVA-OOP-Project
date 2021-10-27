package Main;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import view.EmployeeView;
import view.Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duy
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        EmployeeView e=new EmployeeView();
        Validation v =new Validation();
        v.menu();
        List<Employee> list=new ArrayList<>();
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        list.add(new Employee("101","Nguyen ","Duy","0972902366","duy@gmail.com","Ha Noi",df.parse("06-11-2000"),"Male",2000,"Egency 1"));
        list.add(new Employee("102","Nguyen ","Long","0983538953","long@gmail.com","Ha Noi",df.parse("02-02-2000"),"Male",2500,"Egency 2"));
        list.add(new Employee("103","Trinh ","Ngoc","0973293923","hoang@gmail.com","Hung Yen",df.parse("03-12-2000"),"Female",1200,"Egency 3"));
        list.add(new Employee("104","Nguyen ","Dat","0982632389","dat@gmail.com","Ha Noi",df.parse("08-10-2000"),"Male",5000,"Egency 4"));
        list.add(new Employee("105","Dao ","Trang","0356329039","trang@gmail.com","HCM",df.parse("03-09-2000"),"Female",1000,"Egency 5"));
        list.add(new Employee("106","Nguyen ","Tu","0923829323","tu@gmail.com","Can Tho",df.parse("07-10-2000"),"Male",1500,"Egency 6"));
        list.add(new Employee("107","Vu ","Luan","0338392328","luan@gmail.com","Ha Noi",df.parse("02-06-2000"),"Male",1800,"Egency7"));
        list.add(new Employee("108","Tran ","Linh","0923329929","linh@gmail.com","Bac Ninh",df.parse("06-08-2000"),"Female",3600,"Egency 8"));
        list.add(new Employee("109","Nguyen","Thai","0932829323","thai@gmail.com","Da Nang",df.parse("12-01-2000"),"Male",2200,"Egency 9"));
        list.add(new Employee("110","Ngo ","Cuong","0323090808","cuong@gmail.com","HCM",df.parse("02-08-2000"),"Male",2600,"Egency 10"));
        
        while(true){
            int choice=v.getChoice("Enter Choice :",1,6);
            switch(choice){
                case 1:
                    e.addEmployee(list);
                    break;
                case 2:
                    e.updateEmployee(list);
                    break;
                case 3:
                    e.removeEmployee(list);
                    break;
                case 4:
                    e.searchEmployee(list);
                    break;
                case 5:
                    e.sortEmployee(list);
                    break;
                case 6:
                    System.exit(0);
                    break;
            } 
        }
  
    
    }
        
}
