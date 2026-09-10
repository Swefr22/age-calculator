import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class AgeCalculator {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter
            .ofPattern("MM/dd/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your date of birth (MM/dd/yyyy): ");

        String input = scanner.nextLine().trim();
        try {
            LocalDate dateOfBirth = LocalDate.parse(input, DATE_FORMAT);
            LocalDate today = LocalDate.now();

            if (dateOfBirth.isAfter(today)) {
                System.out.println("Date of birth cannot be in the future.");
                return;
            }

            Period age = Period.between(dateOfBirth, today);
            System.out.printf("Your age is %d years, %d months, and %d days.%n",
                    age.getYears(), age.getMonths(), age.getDays());
        } catch (DateTimeParseException exception) {
            System.out.println("Invalid date. Please use MM/dd/yyyy, for example 04/25/1995.");
        }
    }
}