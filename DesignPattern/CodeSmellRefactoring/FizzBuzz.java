package workshop;
public class FizzBuzz {
    public static String say(int number) {
        String strReturn = null;

        if(DivisibleByThree(number) && DivisibleByFive(number))
        {
            strReturn = "FizzBuzz";
        }
        else if(DivisibleByThree(number))
        {
            strReturn = "Fizz";
        }
        else if(DivisibleByFive(number))
        {
            strReturn = "Buzz";
        }
        else
        {
            strReturn = String.valueOf(number);
        }

        return strReturn;
    }

    public static boolean DivisibleByThree(int number) {
        if(number % 3== 0)
            return true;
        else
            return false;
    }

    public static boolean DivisibleByFive(int number) {
        if(number % 5== 0)
            return true;

        else
            return false;
    }



}
