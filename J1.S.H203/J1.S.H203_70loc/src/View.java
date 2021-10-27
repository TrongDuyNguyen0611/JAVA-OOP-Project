
import java.util.Scanner;

public class View {
    static Scanner sc = new Scanner(System.in);
    static void printReverse(String line){
        while(line.isEmpty()){
            System.out.print("Empty!"+ "\n" + "Enter input: ");
            line = sc.nextLine();
        }
        System.out.println("\nOutput: " + Controller.Reverse(line));   
    }
}
