import decorator.*;
import rent.DayRent;
import rent.HourRent;
import rent.MonthRent;
import rent.Renting;

import java.util.Scanner;
public class Menu {
    Scanner s = new Scanner(System.in);
    IHouse house = new House();
    Renting renting = new Renting();
    private int command;

    public void mainMenu(){
        System.out.println("Let's find a house! What do you want to be with your house?");
        decorator();
        System.out.println("---------------");
        System.out.println("1.Buy. 2.Rent. 3.Exit.");
        System.out.println("---------------");
        System.out.print("Choose command: ");
        command = s.nextInt();

        switch (command){
            case 1:buyMenu(); break;
            case 2:rentMenu(); break;
            case 3: break;
            default:
                System.out.println("Wrong command. Try again."); mainMenu(); break;
        }
    }

    private void decorator(){
        System.out.println("---------------");
        System.out.println("There are things that you can add:\n1.Garden.\n2.Pool\n3.Wi-Fi\n4.Dog house\n5.Nothing to add.");
        System.out.println("---------------");
        System.out.print("Choose decorator: ");
        command = s.nextInt();

        switch (command){
            case 1: house = new GardenDecorator(house); decorator(); break;
            case 2: house = new PoolDecorator(house); decorator(); break;
            case 3: house = new WifiDecorator(house); decorator(); break;
            case 4: house = new DoghouseDecorator(house); decorator(); break;
            case 5: break;
        }
    }

    private void buyMenu(){
        System.out.println("You bought " + house.getDescription());
    }
    private void rentMenu() {
        System.out.println("---------------");
        System.out.println("1.Rent for month.\n2.Rent for day\n3.Rent for hour.");
        System.out.println("---------------");
        System.out.print("Choose command: ");
        command = s.nextInt();

        switch (command){
            case 1: renting.setRentStrategy(new MonthRent(), house); renting.renting(); break;
            case 2: renting.setRentStrategy(new DayRent(), house); renting.renting(); break;
            case 3: renting.setRentStrategy(new HourRent(), house); renting.renting(); break;
        }
    }
}
