import Adapter.Adapter;
import Adapter.Dollar;
import Adapter.PriceDisplay;
import Adapter.Tenge;
import Database.Database;
import decorator.*;
import rent.DayRent;
import rent.HourRent;
import rent.MonthRent;
import rent.Renting;

import Database.Observed;
import Database.HouseChecker;
import java.util.Scanner;
public class Menu{
    Database database = new Database();
    Scanner s = new Scanner(System.in);
    IHouse house = new House();
    private int command;

    public void mainMenu(){
        database.connect();
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
        int observer;
        System.out.println("---------------");
        System.out.println("There are things that you can add:\n1.Garden.\n2.Pool\n3.Wi-Fi\n4.Dog house\n5.Nothing to add.");
        System.out.println("---------------");
        System.out.print("Choose decorator: ");
        command = s.nextInt();

        switch (command){
            case 1:
                if(database.checkGarden()) {
                    house = new GardenDecorator(house);
                }else {
                System.out.println("There are no houses with garden. Do you want that we notify you?(yes - 1): ");
                    observer = s.nextInt();
                    if (observer == 1) {
                        IHouse obs = new GardenDecorator(new House());
                        observer(obs);
                    }
                }
                decorator();
                break;
            case 2:
                if(database.checkPool()) {
                    house = new PoolDecorator(house);
                }else {
                    System.out.println("There are no houses with pool");
                }
                decorator(); break;
            case 3: if(database.checkWifi()) {
                house = new WifiDecorator(house);
            }else {
                System.out.println("There are no houses with wifi");
            } decorator(); break;
            case 4: if(database.checkDoghouse()) {
                house = new DoghouseDecorator(house);
            }else {
                System.out.println("There are no houses with doghouse");
            } decorator(); break;
            case 5: break;
            default: System.out.println("Wrong command. Try again."); decorator();
        }
    }

    private void buyMenu(){
        PriceDisplay priceDisplay = new Dollar(house);
        System.out.println("You bought " + house.getDescription());
        priceDisplay.priceDisplay();
        System.out.print("Show currency in Tenge?(1 - yes/0 - no): ");
        command = s.nextInt();

        if (command == 1){
            Tenge tenge = new Adapter(house);
            tenge.priceDisplay();
        }

    }
    private void rentMenu() {
        Renting renting = new Renting(house);

        System.out.println("---------------");
        System.out.println("1.Rent for month.\n2.Rent for day\n3.Rent for hour.");
        System.out.println("---------------");
        System.out.print("Choose command: ");
        command = s.nextInt();

        switch (command){
            case 1: renting.setRentStrategy(new MonthRent()); renting.renting(); break;
            case 2: renting.setRentStrategy(new DayRent()); renting.renting(); break;
            case 3: renting.setRentStrategy(new HourRent()); renting.renting(); break;
            default:
                System.out.println("Wrong command. Try again."); rentMenu();
        }
    }

    private void observer(IHouse iHouse){
        Observed obj = new HouseChecker(iHouse);
        obj.check();

        while (!obj.check()){
            decorator();
        }
        obj.notifyHouse();
    }

}
