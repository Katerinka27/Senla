package by.balitskaya.hotel.util.sort;

import by.balitskaya.hotel.model.Guest;

import java.util.Comparator;

public class SortedByNameGuest implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if(o1==null)
            return -1;
        if(o2==null)
            return 1;
        return o1.getName().compareTo(o2.getName());
    }
    @Override
    public String toString() {
        return "Sorted by name";
    }
}
