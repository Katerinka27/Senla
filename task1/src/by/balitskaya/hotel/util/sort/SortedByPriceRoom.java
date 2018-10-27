package by.balitskaya.hotel.util.sort;

import by.balitskaya.hotel.model.Room;

import java.util.Comparator;

public class SortedByPriceRoom implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if(o1==null)
            return -1;
        if(o2==null)
            return 1;
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Sorted by price";
    }
}
