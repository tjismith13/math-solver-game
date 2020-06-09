import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IntChecker {
    public boolean isInt(String answer) {

        //Take answer as string and convert to character array
        char[] chars = answer.toCharArray();
        List<Boolean> charIsInt = new ArrayList<>();
        for(char c : chars) {

            //If every number is an int add true to a boolean array
            if(c == '1' || c == '2' || c == '3' || c == '4'|| c == '5' ||
            c == '6' || c == '7' || c == '8' || c == '9' || c == '0') {
                charIsInt.add(true);
            }

            //If answer is blank add false
            else if(answer.isBlank() || answer.isEmpty()) {
                charIsInt.add(false);
            }
            else {
                charIsInt.add(false);
            }
        }
        //if it contains false (anything but int) return false
       return(!charIsInt.contains(false));
    }
}
