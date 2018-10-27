package by.balitskaya.hotel.util;

import by.balitskaya.hotel.model.Guest;

import java.util.ArrayList;
import java.util.List;

public class ConsoleWriter {
    static public void Println(String[] strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    static public void Println(String string) {
        System.out.println(string);
    }

    static public void Println(List<Object> objects){
        for(Object object:objects){
            if(object!=null){
                System.out.println(object.toString());
            }
        }
    }
    static public void Println(ArrayList<Guest> guests){
        for (Guest guest:
             guests) {
            System.out.println(guest.toString());
        }
    }
   /* static public void Println(ArrayList<Service> services){
        for (Service service:
             services) {
            System.out.println(service.toString());
        }
    }*/

    static public void Println(Object object) {
        if (object != null) {


            System.out.println(object.toString());
        } else {
            System.out.println("object is null");
        }
    }

}
