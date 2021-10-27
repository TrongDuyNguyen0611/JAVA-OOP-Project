
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

    public void languageGet(String key,Locale locale) {
        ResourceBundle words = ResourceBundle.getBundle("Language/" + locale, locale);
        String value = words.getString(key);
        System.out.printf(value);
    }
    public void inputPassword() {
        e.setwrongTime(0);
        String pass;
        while (true) {
            pass = inputString("enterPassword", false, ".*");
            if (e.checkPassword(pass).equals("Correct")) {
                break;
            }
            languageGet(e.checkPassword(pass), e.getLocale());
            e.upWrongTime();
            if (e.getwrongTime() == 5) {
                languageGet("errWrong", e.getLocale());
                languageGet("errLoginFail", e.getLocale());
                break;
            }
        }
    }
    public void inputAccountNumber() {
        Locale locale = e.getLocale();
        String acc;
        while (true) {
            acc = inputString("enterAccountNumber", false, ".*");
            if (e.checkAccountNumber(acc).equals("Correct")) {
                break;
            }
            languageGet(e.checkAccountNumber(acc), locale);
        }
    }
    public int inputInt(int min, int max, String msg) {
        Locale locale = e.getLocale();
        System.out.print(msg);
        while (true) {
            try {
                int a = Integer.parseInt(sc.nextLine());
                if (a <= max && a >= min) {
                    return a;
                }
                languageGet("errCheckInputInt",locale);
                languageGet("again",locale);
            } catch (NumberFormatException e) {
                languageGet("errIntRange",locale);
                languageGet("again",locale);
            }
        }
    }
    public void inputCapcha() {
        Locale locale = e.getLocale();
        e.setwrongTime(0);
        String capcha, genarate;
        while (true) {
            genarate = e.generateCaptcha();
            System.out.println("Capcha: " + genarate);
            capcha = inputString("enterCaptcha", false, ".*");
            if (e.checkCaptcha(capcha, genarate).equals("Correct")) {
                break;
            }
            languageGet(e.checkCaptcha(capcha, genarate), locale);
            e.upWrongTime();
            if (e.getwrongTime() == 5) {
                languageGet("errWrong", locale);
                languageGet("errLoginFail", locale);
                break;
            }
        }
    }
    public String inputString(String msg, Boolean isEmpty, String pattern) {
        Locale locale = e.getLocale();
        languageGet(msg, locale);
        if (isEmpty) {
            return sc.nextLine();
        }
        while (true) {
            String text = sc.nextLine();
            if (text.isEmpty()) {
                languageGet("errCheckInputString", locale);
                languageGet("again", locale);
                continue;
            }
            if (!text.matches(pattern)) {
                languageGet("errString", locale);
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
            languageGet("loginSuccess", locale);
        }
    }
}
