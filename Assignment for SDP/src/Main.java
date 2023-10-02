import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Renting renting = new Renting();
        RentStrategy rentStrategy = new MonthRent();
        System.out.println("Hello! Welcome to Potolok.kz! There are our services below.");
        System.out.println("1. Rent for month\n2. Rent for day\n3. Rent for hours");
        System.out.print("Select rent type:");
        int command = s.nextInt();
        if (command == 1) {
            rentStrategy = new MonthRent();
        } else if (command == 2) {
            rentStrategy = new DayRent();
        } else if (command == 3) {
            rentStrategy = new HourRent();
        }

        renting.rent((RentStrategy)rentStrategy);
    }
}