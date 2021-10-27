/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View();
        Controller ctrl = new Controller();
        v.Menu();
        while (true) {
            int choice = ctrl.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    v.Add();
                    break;
                case 2:
                    v.Sub();
                    break;
                case 3:
                    v.Mul();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
