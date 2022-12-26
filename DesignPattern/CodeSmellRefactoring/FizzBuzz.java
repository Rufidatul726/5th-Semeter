package workshop;

import java.util.List;

public class FizzBuzz {
    public static String say(int number) {
        List<String> words = List.of("Fizz", "Buzz");
        List<Integer> numbers = List.of(3, 5);

        String result = "";
        for (int i = 0; i < words.size(); i++) {
            if (number % numbers.get(i) == 0) {
                result += words.get(i);
            }
        }
        if (result.isEmpty()) {
            result = String.valueOf(number);
        }
        return result;
    }

}
