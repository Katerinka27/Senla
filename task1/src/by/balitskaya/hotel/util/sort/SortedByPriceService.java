package by.balitskaya.hotel.util.sort;

import by.balitskaya.hotel.model.Service;

import java.util.Comparator;

public class SortedByPriceService implements Comparator<Service> {
    @Override
    public int compare(Service o1, Service o2) {
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
