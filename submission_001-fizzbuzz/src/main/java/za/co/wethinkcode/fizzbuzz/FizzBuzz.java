package za.co.wethinkcode.fizzbuzz;

import java.util.ArrayList;

public class FizzBuzz {
    public String checkNumber(int number) {
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if ( divisibleBy3 && divisibleBy5 ) {
            return "FizzBuzz";
        }

        if (divisibleBy3 && !divisibleBy5) {
            return "Fizz";
        }

        if (divisibleBy5 && !divisibleBy3) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public String countTo(int number) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        ArrayList<String> numbers = new ArrayList<String>();

        for(int i=1; i <= number; i++) {
            numbers.add(fizzBuzz.checkNumber(i));
        }
        return numbers.toString();
    }
}
