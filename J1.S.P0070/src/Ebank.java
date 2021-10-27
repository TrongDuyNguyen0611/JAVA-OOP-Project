
import java.util.Locale;
import java.util.ResourceBundle;

public class Ebank {
    ResourceBundle words;
    private Locale locale;
    private int wrongTime;
    
    public Ebank() {
        this.locale = new Locale("en");
        this.wrongTime = 0;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        words = ResourceBundle.getBundle("Language/" + locale, locale);
        
    }
    public Locale getLocale() {
        return locale;
    }
    
    public int getwrongTime() {
        return wrongTime;
    }

    public void setwrongTime(int wrongTime) {
        this.wrongTime = wrongTime;
    }
    public void upWrongTime(){
        wrongTime++;
    }
    String getMess(String key){
        return words.getString(key);
    }
    String checkAccountNumber(String acc) {
        if (!acc.matches("[\\d]{10}")) {
            return "errCheckInputAccount";
        }
        return "Correct";
    }
    
      String checkPassword(String pass) {
        if (!pass.matches("(?=.*[a-zA-Z]{1,})(?=.*[0-9]{1,}).{8,31}")) {
            return "errCheckPassword";
        }
        return "Correct";
    }
    
     String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (!captchaGenerate.contains(captchaInput)&&!captchaInput.isEmpty()) {
            return "errCaptchaIncorrect";
        }
        return "Correct";
    }

     String generateCaptcha() {
        String captcha = "";
        String src = "qw9ertyui6oJKLpaQWERsd0fghj1klzASD7xcvVBNb2nmTY3U8IOP4FGHZ5XCM";
        while (captcha.length() != 6) {
            captcha += src.charAt((int) (Math.random() * (src.length() - 1)));
        }
        return captcha;
    }

//    public void login() {
//        int choose = v.menu();
//        switch (choose) {
//            case 1:
//                setLocale(new Locale("vi"));
//                break;
//            case 2:
//                setLocale(new Locale("en"));
//                break;
//            case 3:
//                break;
//        }
//        v.inputAccountNumber();
//        v.inputPassword();
//        setwrongTime(0);
//        if (getwrongTime()!= 5) {
//            v.inputCapcha();
//        }
//        if (getwrongTime()!= 5) {
//            v.languageGet("loginSuccess", locale);
//        }
//    }
}
