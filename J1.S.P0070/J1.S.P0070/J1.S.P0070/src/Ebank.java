
import java.util.Locale;
import java.util.ResourceBundle;

public class Ebank {
    ResourceBundle words;
    private Locale locale;
    private int wrongTime;//so lan sai, dung ca cho sai mat khau
    
    public Ebank() {
        this.locale = new Locale("en");
        this.wrongTime = 0;
    }
    //set locale + bundle
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
    //lay mess tu bundle
    String getMess(String key){
        return words.getString(key);
    }
    //kiem tra account
    String checkAccountNumber(String acc) {
        if (!acc.matches("[\\d]{10}")) {
            return getMess("errCheckInputAccount");
        }
        return getMess("Correct");
    }
    //kiem tra password
    String checkPassword(String pass) {
        if (!pass.matches("(?=.*[a-zA-Z]{1,})(?=.*[0-9]{1,}).{8,31}")) {
            return getMess("errCheckPassword");
        }
        return getMess("Correct");
    }
    //kiem tra captcha
     String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (!captchaGenerate.contains(captchaInput)&&!captchaInput.isEmpty()) {
            return getMess("errCaptchaIncorrect");
        }
        return getMess("Correct");
    }
    //sinh ngau nhien capcha
     String generateCaptcha() {
        String captcha = "";
        String src = "qw9ertyui6oJKLpaQWERsd0fghj1klzASD7xcvVBNb2nmTY3U8IOP4FGHZ5XCM";
        while (captcha.length() != 6) {
            captcha += src.charAt((int) (Math.random() * (src.length() - 1)));
        }
        return captcha;
    }

}
