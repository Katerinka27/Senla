package by.balitskaya.hotel.util.sort;

import by.balitskaya.hotel.model.Guest;

import java.util.Comparator;

public class SortedByTimeGuest implements Comparator<Guest> {
    @Override
    public int compare(Guest o1, Guest o2) {
        if(o1==null)
            return 1;
        if(o2==null)
            return -1;
        if(o1.getEndTime()==null)
            return 1;
        if(o2.getEndTime()==null)
            return -1;
        if(o1.getEndTime().after(o2.getEndTime()))
            return -1;
        if(o2.getEndTime().after(o1.getEndTime()))
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Sorted by time:";
    }
}
