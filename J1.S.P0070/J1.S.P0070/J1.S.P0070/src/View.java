
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADMIN
 */
public class View {

    private final Scanner sc = new Scanner(System.in);
    Ebank e = new Ebank();
    public View() {
    }

    public void inputPassword() {
        e.setwrongTime(0);
        String pass;
        while (true) {
            pass = inputString("enterPassword", false, ".*");
            if (e.checkPassword(pass).equals("Correct")) {
                break;
            }
            System.out.println(e.checkPassword(pass));
            e.upWrongTime();
            if (e.getwrongTime() == 5) {
                System.out.println(e.getMess("errWrong"));
                System.out.println(e.getMess("errLoginFail"));
                break;
            }
        }
    }
    public void inputAccountNumber() {
        String acc;
        while (true) {
            acc = inputString("enterAccountNumber", false, ".*");
            if (e.checkAccountNumber(acc).equals("Correct")) {
                break;
            }
            System.out.println(e.checkAccountNumber(acc));
        }
    }
    public int inputInt(int min, int max, String msg) {
        System.out.print(msg);
        while (true) {
            try {
                int a = Integer.parseInt(sc.nextLine());
                if (a <= max && a >= min) {
                    return a;
                }
                System.out.println(e.getMess("errCheckInputInt"));
                System.out.println(e.getMess("again"));


            } catch (Exception ex) {
                System.out.println(e.getMess("errIntRange"));
                System.out.println(e.getMess("again"));
            }
        }
    }
    public void inputCapcha() {
        e.setwrongTime(0);
        String capcha, genarate;
        while (true) {
            genarate = e.generateCaptcha();
            System.out.println("Capcha: " + genarate);
            capcha = inputString("enterCaptcha", true, ".*");
            if (e.checkCaptcha(capcha, genarate).equals("Correct")) {
                break;
            }
            System.out.println(e.checkCaptcha(capcha, genarate));
            e.upWrongTime();
            if (e.getwrongTime() == 5) {
                System.out.println(e.getMess("errWrong"));
                System.out.println(e.getMess("errLoginFail"));
                break;
            }
        }
    }
    public String inputString(String msg, Boolean isEmpty, String pattern) {
        System.out.println(e.getMess(msg));
        if (isEmpty) {
            return sc.nextLine();
        }
        String text;
        while (true) {
            text = sc.nextLine();
            if (text.isEmpty()) {
                System.out.println(e.getMess("errCheckInputString"));
                System.out.println(e.getMess("again"));
                continue;
            }
            if (!text.matches(pattern)) {
                System.out.println(e.getMess("errString"));
                continue;
            }
            return text;
        }
    }
    public int menu(){
        return inputInt(1, 3, "--------Login Program---------"
                + "\n1. Vietnamese"
                + "\n2. English"
                + "\n3. Exit"
                + "\nPlease choice one option: ");
    }
    public void login() {
        Locale locale = e.getLocale();
        int choose = menu();
        switch (choose) {
            case 1:
                e.setLocale(new Locale("vi"));
                break;
            case 2:
                e.setLocale(new Locale("en"));
                break;
            case 3:
                return;
        }
        inputAccountNumber();
        inputPassword();
        if (e.getwrongTime() == 5) return;
        inputCapcha();
        if (e.getwrongTime() < 5) {
            System.out.println(e.getMess("loginSuccess"));
        }
    }
}
