
public class Controller {
    static String Reverse(String line){
        if(line.trim().isEmpty()) return line;
        StringBuilder result = new StringBuilder(); 
        String[] words = line.split("\\s+"); 
        if(words.length == 0) return line;
        for(int i = words.length - 1; i >= 0; i--){
            if(i == words.length - 1){ 
                result.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1) + " ");
            }
            else result.append(words[i] + " ");
        }     
        return result.toString().trim();
    }
}
