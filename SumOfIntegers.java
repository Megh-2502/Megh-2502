import java.util.InputMismatchException;

public class SumOfIntegers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            try {
                int number = Integer.parseInt(args[i]);
                if (number < 0) {
                    throw new IllegalArgumentException("Negative number");
                } else if (number % 10 == 0) {
                    throw new IllegalArgumentException("Evenly divisible by 10");
                } else if (number > 1000 && number < 2000) {
                    throw new IllegalArgumentException("Between 1000 and 2000");
                } else if (number > 7000) {
                    throw new IllegalArgumentException("Greater than 7000");
                } else {
                    sum += number;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: " + args[i]);
                continue;
            }
        }

        System.out.println("Sum of all numbers: " + sum);
    }
}
