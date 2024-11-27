
import java.util.Calendar;
import java.util.Scanner;

public class CalAge {
    private int birthYear, birthMonth, birthDay;
    private int currentYear, currentMonth, currentDay;

    // Method to set the date of birth and current date
    public void setDateOfBirth(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.birthYear = year;
            this.birthMonth = month;
            this.birthDay = day;
        } else {
            System.out.println("Invalid date entered!");
        }

        // Get current date
        Calendar currentDate = Calendar.getInstance();
        this.currentYear = currentDate.get(Calendar.YEAR);
        this.currentMonth = currentDate.get(Calendar.MONTH) + 1; // Months are 0-based
        this.currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
    }
    public boolean isValidDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            return false;
        }

        // Handle leap year for February
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                if (day < 1 || day > 29) {
                    return false;
                }
            } else {
                if (day < 1 || day > 28) {
                    return false;
                }
            }
        }

        // Handle months with 30 days
        else if (month == 4  ||month == 6 || month == 9 || month == 11) {
            if (day < 1 || day > 30) {
                return false;
            }
        }

        // Handle months with 31 days
        else {
            if (day < 1 || day > 31) {
                return false;
            }
        }
        return true;
    }

    // Method to calculate age in years and months
    public double calculateAge() {
        int years = currentYear - birthYear;
        int months = currentMonth - birthMonth;

        if (months < 0) {
            years--;
            months += 12;
        }

        double ageInYears = years + (double) months / 12;
        return ageInYears;
    }

    // Main method to test the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalAge calAge = new CalAge();
        System.out.print("Enter your birth year: ");
        int year = scanner.nextInt();
        System.out.print("Enter your birth month: ");
        int month = scanner.nextInt();
        System.out.print("Enter your birth day: ");
        int day = scanner.nextInt();

        // Set the date of birth and current date
        calAge.setDateOfBirth(year, month, day);

        // Calculate and display the age
        double age = calAge.calculateAge();
        System.out.println("Your age is: " + age + " years.");
    }
}

