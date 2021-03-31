package za.co.wethinkcode.mastermind;

import java.util.Random;
import java.util.ArrayList;


public class CodeGenerator {
    private final Random random;

    public CodeGenerator(){
        this.random = new Random();
    }

    public CodeGenerator(Random random){
        this.random = random;
    }

    /*
     * Generates a random 4 digit code, using this.random, where each digit is in the range 1 to 8 only.
     * Duplicated digits are allowed.
     * @return the generated 4-digit code
     */

    public String generateCode(){
        ArrayList<String> arrayCode = new ArrayList<String>();

        for (int x = 0; x < 4; x++) {
            int code_num = random.nextInt((8-1) + 1) + 1;
            arrayCode.add(Integer.toString(code_num));
        }
        
        String code = arrayCode.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");
        return code;
    }
}
