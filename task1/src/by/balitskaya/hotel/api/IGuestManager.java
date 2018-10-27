package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Guest;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IGuestManager {
    public List<Guest> lastGuests(int numberRoom);
    public double pricePerRoom(String name);
    public void settleInRoom(String name, int numberRoom, Date startTime, Date endTime);
    public void evictFromRoom(String name);
    public void addGuest(Guest guest);
    public void addServiceToGuest(int numberService, String nameGuest);
    public List<Guest> sort(Comparator comparator);
    public int countGuest();
    public String[] toStrings();
}
