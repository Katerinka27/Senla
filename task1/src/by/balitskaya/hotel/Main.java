package by.balitskaya.hotel;

import by.balitskaya.hotel.facade.Facade;

public class Main {
    public static void main(String[] strings) {
        if (strings.length != 0) {
            Facade.getInstance(strings[0]);
        } else {
            Facade.getInstance(".\\data");
        }
        System.out.println(Facade.getInstance().printAllServices());
        System.out.println(Facade.getInstance().printAllGuest());
        System.out.println(Facade.getInstance().printAllRoom());
        Facade.getInstance().writeInFile();
    }
}
