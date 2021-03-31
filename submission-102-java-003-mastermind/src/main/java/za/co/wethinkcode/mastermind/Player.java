package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;
    private Boolean quit = false;
    private int chances = 11;
    private int correctPlace = 0;
    private int inCode = 0;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream){
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */

    public String getGuess() {
        
        System.out.printf("Input 4 digit code:\n");
        
        while(true) {
            boolean range = true;
            String guess = inputScanner.nextLine();

            try {
                Integer digits = Integer.parseInt(guess);
            } catch (NumberFormatException e) {
                System.out.printf("Please enter exactly 4 digits (each from 1 to 8).\n");
                System.out.printf("Input 4 digit code:\n");
                continue;
            }
    
            if (guess.length() != 4) {
                System.out.printf("Please enter exactly 4 digits (each from 1 to 8).\n");
                System.out.printf("Input 4 digit code:\n");
                continue;
            }
    
            String[] arrayCode = guess.split("");
            for (String x : arrayCode) {
                if (Integer.parseInt(x) == 9 || Integer.parseInt(x) == 0) {
                    range = false;
                    break;
                }
            }
    
            if (range == false) {
                System.out.printf("Please enter exactly 4 digits (each from 1 to 8).\n");
                System.out.printf("Input 4 digit code:\n");
                continue;
            }
    
            return guess;
        }
    }

    public boolean wantsToQuit() {
        return this.quit;
    }

    public int getChances() {
        return chances;
    }

    public void lostChance() {
        this.chances--;
    }

    public int setCorrectPlace() {
        return correctPlace;
    }

    public void increaseCorrectPlace() {
        this.correctPlace++;
    }

    public int setInCode() {
        return inCode;
    }

    public void increaseInCode() {
        this.inCode++;
    }

    public void setZero() {
        this.correctPlace = 0;
        this.inCode = 0;
    }
}
